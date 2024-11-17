package com.dam2.BDsrc;
import java.sql.*;

public class ModulProfessional {

    public void addDam2(String moduleName, Integer idProfessor,Connection connection) {
        String query = "INSERT INTO modulsprofessionals (nom, id_professor) VALUES (?, ?)";
        try (PreparedStatement statment = connection.prepareStatement(query)) {
            statment.setString(1, moduleName);
            if (idProfessor != null) {
                statment.setInt(2, idProfessor);
            } else {
                statment.setNull(2, Types.INTEGER);
            }
            statment.executeUpdate();
            System.out.println("Mòdul afegit: " + moduleName);
        } catch (SQLException e) {
            System.err.println("Error afegint el mòdul: " + e.getMessage());
        }
    }

    public void readDam2(Connection connection) {
        String query = "SELECT id, nom, professor_id FROM moduls";
        
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            System.out.println("\n=== LLISTA DE MÒDULS PROFESSIONALS ===");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                int professorId = resultSet.getInt("professor_id");
                String professorInfo = (professorId == 0) ? "Cap professor assignat" : "Professor ID: " + professorId;
                System.out.println("ID: " + id + ", Nom: " + nom + ", " + professorInfo);
            }
        } catch (SQLException e) {
            System.out.println("Error en llistar els mòduls: " + e.getMessage());
        }
    }

    // Mètode per eliminar un mòdul
    public void deleteDam2(String moduleName,Connection connection) {
        String query = "DELETE FROM modulsprofessionals WHERE nom = ?";
        try (PreparedStatement statment = connection.prepareStatement(query)) {
            statment.setString(1, moduleName);
            int rowsAffected = statment.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mòdul eliminat: " + moduleName);
            } else {
                System.out.println("No s'ha trobat el mòdul: " + moduleName);
            }
        } catch (SQLException e) {
            System.err.println("Error eliminant el mòdul: " + e.getMessage());
        }
    }

    // Mètode per actualitzar un mòdul
    public void updateDam2(String oldModuleName, String newModuleName, Integer idProfessor,Connection connection) {
        String query = "UPDATE modulsprofessionals SET nom = ?, id_professor = ? WHERE nom = ?";
        try (PreparedStatement statment = connection.prepareStatement(query)) {
            statment.setString(1, newModuleName);
            if (idProfessor != null) {
                statment.setInt(2, idProfessor);
            } else {
                statment.setNull(2, Types.INTEGER);
            }
            statment.setString(3, oldModuleName);
            int rowsAffected = statment.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mòdul actualitzat: " + oldModuleName + " -> " + newModuleName);
            } else {
                System.out.println("No s'ha trobat el mòdul per actualitzar: " + oldModuleName);
            }
        } catch (SQLException e) {
            System.err.println("Error actualitzant el mòdul: " + e.getMessage());
        }
    }

    
};


