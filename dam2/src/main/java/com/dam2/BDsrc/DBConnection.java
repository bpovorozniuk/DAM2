package com.dam2.BDsrc;

import java.sql.*;

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/professors";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("La connexió s'ha establert correctament");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver no trobat.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error a la connexió");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("La connexió està tancada!");
            } catch (SQLException ex) {
                System.out.println("S'ha produït un error!");
                ex.printStackTrace();
            }
            
        }
    }
    

    
}



