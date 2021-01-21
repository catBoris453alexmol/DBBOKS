package ru.sapteh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil  {
    public final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final String URL = "jdbc:mysql://localhost:3306/db_books?serverTimezone=UTC";
    public final String LOGIN = "root";
    public final String PASSWORD = "1111";

    public Connection openConnect() {
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public void closeConnect(Connection connection){
        if(connection == null)return;
        try{
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
