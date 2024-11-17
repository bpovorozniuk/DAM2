package com.dam2.BDsrc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professors {

    private String nom;
    private String cognoms;

    public Professors(String nom, String cognoms) {
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public Professors(){
    };

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

    public void addDam2(Professors professorObject,Connection connection) {
        String query = "INSERT INTO professors (nom) VALUES (?)";
        try (PreparedStatement statment = connection.prepareStatement(query)) {
            statment.setString(1, professorObject.getNom());
            statment.executeUpdate();
            System.out.println("Professor afegit: " + professorObject.getNom());
        } catch (SQLException e) {
            System.err.println("Error afegint el professor: " + e.getMessage());
        }
    }

    public void deleteDam2(int professorId,Connection connection) {
        String query = "DELETE FROM professors WHERE id = ?";
        try (PreparedStatement statment = connection.prepareStatement(query)) {
            statment.setInt(1, professorId);
            int rowsAffected = statment.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Professor eliminat amb ID: " + professorId);
            } else {
                System.out.println("No s'ha trobat cap professor amb ID: " + professorId);
            }
        } catch (SQLException e) {
            System.err.println("Error eliminant el professor: " + e.getMessage());
        }
    }

    public void updateDam2(int professorId, String newName,Connection connection) {
        String query = "UPDATE professors SET nom = ? WHERE id = ?";
        try (PreparedStatement statment = connection.prepareStatement(query)) {
            statment.setString(1, newName);
            statment.setInt(2, professorId);
            int rowsAffected = statment.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Professor actualitzat amb ID: " + professorId + ", Nom: " + newName);
            } else {
                System.out.println("No s'ha trobat cap professor amb ID: " + professorId);
            }
        } catch (SQLException e) {
            System.err.println("Error actualitzant el professor: " + e.getMessage());
        }
    }

    public void readDam2(Connection connection) {
        String query = "SELECT id, nom FROM professors";
        try (PreparedStatement statment = connection.prepareStatement(query);
                ResultSet rs = statment.executeQuery(query)) {
            System.out.println("Llista de professors:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nom");
                String surname = rs.getString("cognoms");

                System.out.println("- ID: " + id + ", Nom: " + name + ", Cognoms" + surname);
            }
        } catch (SQLException e) {
            System.err.println("Error llistant els professors: " + e.getMessage());
        }
    }

}
