package chapter12;

import helper.properties.PropertiesDBEnum;

import java.sql.*;
import java.util.ResourceBundle;

public class DBConnector {
    private static final String BASE_NAME = "database";
    public static Connection getConnection() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle(BASE_NAME);
            String url = resource.getString(PropertiesDBEnum.URL.getPart());
            String user = resource.getString(PropertiesDBEnum.USER.getPart());
            String pass = resource.getString(PropertiesDBEnum.PASSWORD.getPart());
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
