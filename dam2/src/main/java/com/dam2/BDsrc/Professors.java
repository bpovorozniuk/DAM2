package com.dam2.BDsrc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Professors {
    
    private String nom;
    private String cognoms;

    public Professors(String nom, String cognoms) {
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
       this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public void addDam2(Professors professor, Connection connection) {
        String sql = "INSERT INTO professors (nom, cognoms) VALUES (?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getNom());
            stmt.setString(2, professor.getCognoms());
            stmt.executeUpdate();
            System.out.println("El profesor s'ha afegit correctament!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readDam2(Connection connection) throws SQLException {
        String sql = "SELECT * FROM professors";  

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            
            while (rs.next()) {
                
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i); 
                    Object columnValue = rs.getObject(i); 
                    System.out.print(columnName + ": " + columnValue + " | ");
                }
                System.out.println(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error llegint les dades de la taula 'persones'", e);
        }
    }
    
}

