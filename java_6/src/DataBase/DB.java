package DataBase;

import Letters.Letter;
import Letters.people;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.*;
import java.sql.*;
import java.util.ArrayList;


public class DB {


    private Connection connect;

    public DB() throws SQLException {
        connect = MyDB.getConnection();
        connect.setAutoCommit(false);
    }
    //region PreparedStatement
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connect.prepareStatement(query);
    }
    public void closeStatement(PreparedStatement ps) throws SQLException {
        ps.close();
    }
    public void insertpeople(PreparedStatement ps, people People) throws SQLException {
        ps.setString(1, People.getName());
        ps.setString(2, People.getSurname());
        ps.setString(3, People.getMiddle_name());
        ps.setDate(4, (Date) People.getBirthday());
        ps.executeUpdate();
    }

    public Statement getStatement() throws SQLException {
        return connect.createStatement();
    }
    public ArrayList<Letter> First(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("select*  From Letter where LEN(Letter.Text)=(select min(len(Letter.Text)) from Letter)");

        ArrayList<Letter> letters = new ArrayList<>();
        while (rs.next()) {
            String Sender = rs.getString(1);
            String Recipient = rs.getString(2);
            String Subject_of_the_letter = rs.getString(3);
            String Text = rs.getString(4);
            Date date = rs.getDate(5);
            letters.add(new Letter(Sender, Recipient, Subject_of_the_letter, Text, date));

        } connect.commit();
        return letters;

    }

 public ArrayList<people> Second(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT people.Name,people.Surname,people.Middle_name,people.Birthday, t1.obtaineds, t2.sents FROM\n" +
                "people LEFT JOIN\n" +
                "(SELECT (Letter.Recipient), COUNT(Letter.Recipient) AS obtaineds FROM Letter GROUP BY (Letter.Recipient))\n" +
                "AS t1 ON people.Surname = t1.Recipient LEFT JOIN\n" +
                "(SELECT Letter.Sender, COUNT(Letter.Sender) AS sents FROM Letter GROUP BY(Letter.Sender))\n" +
                "AS t2 ON people.Surname = t2.Sender\n" +
                "ORDER BY people.Surname");

        ArrayList<people> people = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String middle_name= rs.getString(3);
            Date date = rs.getDate(4);
            String qty=rs.getString(5);
            String qty1=rs.getString(6);
            people.add(new people(name, surname, middle_name, date, qty, qty1));
        }connect.commit();
        return people;
    }
    public ArrayList<people> getInfo(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT people.Name,people.Surname,people.Middle_name,people.Birthday From people inner join Letter on people.Surname=Letter.Recipient and Letter.Subject_of_the_letter ='Eat'");
        ArrayList<people> people = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String middle_name= rs.getString(3);
            Date date = rs.getDate(4);

            people.add(new people(name, surname, middle_name, date));
        }connect.commit();
        return people;
    }

    public ArrayList<people> getInfo1(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT people.Name,people.Surname,people.Middle_name,people.Birthday\n" +
                "From people inner join Letter\n" +
                "on people.Surname=Letter.Recipient and Letter.Subject_of_the_letter !='Eat'");
        ArrayList<people> people = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String middle_name= rs.getString(3);
            Date date = rs.getDate(4);

            people.add(new people(name, surname, middle_name, date));
        }connect.commit();
        return people;
    }
    public ArrayList<Letter> getInfo2(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("insert into Letter Select 'Kirkland',people.Surname,'etc','лллл','2022-04-03' From people;\n" +
                "select *\n" +
                "from Letter;");
        ArrayList<Letter> letters = new ArrayList<>();
        while (rs.next()) {
            String Sender = rs.getString(1);
            String Recipient = rs.getString(2);
            String Subject_of_the_letter = rs.getString(3);
            String Text = rs.getString(4);
            Date date = rs.getDate(5);
            letters.add(new Letter(Sender, Recipient, Subject_of_the_letter, Text, date));
        }connect.commit();
        return letters;
    }
    public ArrayList<people> getInfopeople(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM people");
        ArrayList<people> people = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString(1);
            String surname = rs.getString(2);
            String middle_name= rs.getString(3);
            Date date = rs.getDate(4);

            people.add(new people(name, surname, middle_name, date));
        }connect.commit();
        return people;
    }
    public void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public void closeConnection() throws SQLException {
        connect.close();
    }
}
