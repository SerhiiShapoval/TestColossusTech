package main.ua.shapoval.util;

import java.sql.*;

public class DataBaseManager {
    public DataBaseManager() {
    }
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
    public Connection getConnection(){
        final String URl =  "jdbc:postgresql://localhost:5432/warehouseDB";
        final String USER = "postgres";
        final String PASSWORD = "postgres";
        try{
            return DriverManager.getConnection(URl,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
