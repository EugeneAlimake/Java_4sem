package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class MyDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("db");

        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");
        String dbname = resource.getString("db.dbname");

        Properties prop = new Properties();

        prop.put("user", user);
        prop.put("password", password);
        prop.put("dbname", dbname);
        return (Connection)DriverManager.getConnection(url, prop);
    }
    }


