package main.ua.shapoval;

import java.sql.*;

public class DataBaseManager {
    public DataBaseManager() {
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
    public void createTable() {


        try(Statement statement = getConnection().createStatement()) {
            String crateTableQuery = "CREATE TABLE warehouse ("
                    + "id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "address_line_1 VARCHAR(100) NOT NULL,"
                    + "address_line_2 VARCHAR(100),"
                    + "city VARCHAR(50) NOT NULL,"
                    + "state VARCHAR(50) NOT NULL,"
                    + "country VARCHAR(50) NOT NULL,"
                    + "inventory_quantity INT NOT NULL DEFAULT 0)";
            statement.execute(crateTableQuery);
            System.out.println("Table 'warehouse' created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
