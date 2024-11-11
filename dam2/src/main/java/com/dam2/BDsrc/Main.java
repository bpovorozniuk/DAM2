package com.dam2.BDsrc;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        
        DBConnection connect = new DBConnection();
        Connection connection = DBConnection.createConnection();
        
        Professors profe1 = new Professors("Arthur", "KingJR");
        profe1.addDam2(profe1, connection);

        System.out.println("Les dades: ");

        try {
            Professors.readDam2(connection); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }
}