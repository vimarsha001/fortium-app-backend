package edu.icet.ecom.db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    @Getter
    private Connection connection;
    private DBConnection() throws SQLException {
        String URL="jdbc:mysql://localhost:3306/fortium";
        String userName = "root";
        String password = "2007";
        connection = DriverManager.getConnection(URL,userName,password);
    }
    public static DBConnection getInstance() throws SQLException {
        return instance==null?instance=new DBConnection():instance;
    }
}
