

import DataBase.DB;
import Letters.Letter;
import Letters.people;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {
        //cd C:\Users\thesi\Desktop\4\JAVA\kva\java_6.1\src
        //javac Main.java
        //java -classpath mssql-jdbc-10.2.0.jre17.jar;. Main

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            String connectionUrl = "jdbc:sqlserver://DESKTOP-45NETQ3;databaseName=User;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false";
            Connection con = (Connection) DriverManager.getConnection(connectionUrl, "sa", "12345");
            System.out.println("Connection succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        DB helper = new DB();
        logger.info("Подлючены к базе данных");
        System.out.println("\nПервый запрос");
        logger.info("Первый запрос");
        Statement st = helper.getStatement();
        ArrayList<Letter> letters = helper.First(st);
        for (var letter : letters) {
            System.out.println(letter);
            logger.info(letter);
        }

        System.out.println("\nВторой запрос");
        logger.info("Второй запрос");
        ArrayList<people> people = helper.Second(st);
        for (var peoples : people) {
            System.out.println(peoples);
            logger.info(peoples);
        }
        System.out.println("\nТретий запрос");
        logger.info("Третий запрос");
        ArrayList<people> people2 = helper.getInfo(st);
        for (var peoples : people2) {
            System.out.println(peoples);
            logger.info(peoples);
        }
        System.out.println("\nЧетвертый запрос");
        logger.info("Четвертый запрос");
        ArrayList<people> people3 = helper.getInfo1(st);
        for (var peoples : people3) {
            System.out.println(peoples);
            logger.info(peoples);
        }
        System.out.println("\nПятый запрос");
        logger.info("Пятый запрос");
        ArrayList<Letter> letters1 = helper.getInfo2(st);
        for (var letter : letters1) {
            System.out.println(letter);
            logger.info(letter);
        }
        System.out.println("\nДо");
        logger.info("До");
        ArrayList<people> people5 = helper.getInfopeople(st);
        for (var peoples : people5) {
            System.out.println(peoples);
            logger.info(peoples);
        }
        System.out.println("\nPreparedStatement запрос");
        logger.info("PreparedStatement запрос");
        PreparedStatement ps = helper.getPreparedStatement("INSERT INTO people VALUES (?,?,?,?)");
        Date c =new Date(2002, 01, 25);
        helper.insertpeople(ps, new people("Yan", "Hallagfkf","Mr",null));
        helper.closeStatement(ps);
        System.out.println("\nПосле");
        logger.info("После");
        ArrayList<people> people6 = helper.getInfopeople(st);
        for (var peoples : people6) {
            System.out.println(peoples);
            logger.info(peoples);
        }
    }
}
