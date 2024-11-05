package com.dam2.BDsrc;

import java.sql.*;
import java.net.ConnectException;

public class Main {
    public static void main(String[] args) {
        
        DBConnection connect = new DBConnection();
        
        Connection connection = DBConnection.createConnection();

        
        Professors profe1 = new Professors("David", "Fendi");

        profe1.addDam2(profe1, connection);

        
        
    }
}