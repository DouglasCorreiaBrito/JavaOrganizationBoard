package br.com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String URL = "jdbc:mysql://localhost/dbjob?serverTimezone=UTC";
    private final static String USER = "userjob";
    private final static String PASS = "1234";
    private Connection con;

    public DBConnection() {
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
         return this.con;
    }

    public void closeCon() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
