package db;

import User.Users;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBConnection {

    private Connection connection;
    private Statement statement;

    public Connection GetConnection() throws SQLException {
     try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            String url = "jdbc:sqlserver://DESKTOP-45NETQ3;databaseName=User;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
            /*String user = "sa";
            String password = "12345";
            String dbname = "User";
            Properties prop = new Properties();

            prop.put("user", user);
            prop.put("password", password);
            prop.put("dbname", dbname);*/
            connection = (Connection) DriverManager.getConnection(url, "sa","12345");
            System.out.println("Connection succesfull!");
        }catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

        return connection;
    }

    public ArrayList<Users> GetAllUsers() throws SQLException {
        String sqlQuery="select * from Users;";
        statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlQuery);

        ArrayList<Users> users = new ArrayList<Users>();
        while(resultSet.next()){
            String username = resultSet.getString(1);
            String password = resultSet.getString(2);
            String role = resultSet.getString(3);

            Users user = new Users(username,password,role);
            users.add(user);
        }
        return users;
    }

    public boolean AddUser(Users user) throws SQLException {
        //проверка на существующее имя пользователя
        String select="insert Users(username,password,role) values('"+user.getUsername() +"','"+user.getPassword()+ "','user');";
        statement = GetConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(select);
        return true;
    }

    public Users GetByUsername(String Username, String Password) throws SQLException {
        String select ="select * from Users where username = '"+Username+"';";
        statement = GetConnection().createStatement();
        ResultSet resultSet= statement.executeQuery(select);
        Users user=null;
        if(resultSet != null){
            while(resultSet.next()){
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);
                String role = resultSet.getString(3);
                user = new Users(username,password,role);
            }
        }
        return  user;
    }
}
