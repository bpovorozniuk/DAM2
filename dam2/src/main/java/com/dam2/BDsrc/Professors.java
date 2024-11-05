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

    public static void addDam2(Professors professor, Connection connection) {
        String sql = "INSERT INTO professors (nom, cognoms) VALUES (?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, professor.getNom());
            preparedStatement.setString(2, professor.getCognoms());
            preparedStatement.executeUpdate();
            System.out.println("El profesor s'ha afegit correctament!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readDam2(String tableName, Connection connection) throws SQLException {
        String sql = "SELECT * FROM ;" + tableName;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            



        }


    }

    
}

