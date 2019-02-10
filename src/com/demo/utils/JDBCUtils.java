package com.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by ForMe
 * com.demo.utils
 * 2019/2/10
 * 10:34
 */
public class JDBCUtils {
    private static String USER = null;
    private static String PASS = null;
    private static String URL = null;
    private static String DRIVER = null;

    static{
        Properties properties = new Properties();
        InputStream inputSteam = JDBCUtils.class.getResourceAsStream("/login.properties");

        try {
            properties.load(inputSteam);
            USER = properties.getProperty("user");
            PASS = properties.getProperty("password");
            URL = properties.getProperty("url");
            DRIVER = properties.getProperty("driver");
            Class.forName(DRIVER);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConn(){
        try {
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if(connection != null)
            connection.close();
        if(preparedStatement != null)
            preparedStatement.close();
        if(resultSet != null)
            resultSet.close();
    }
}
