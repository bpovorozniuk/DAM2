package com.dam2.BDsrc;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            

            ModulProfessional modulManager = new ModulProfessional();
            Professors professorManager = new Professors();
            Scanner scanner = new Scanner(System.in);
            int choice;

            Connection connection = DBConnection.createConnection();

            do {
                
                System.out.println("\n=== MENU ===");
                System.out.println("1. Llistar professors");
                System.out.println("2. Afegir professor");
                System.out.println("3. Eliminar professor");
                System.out.println("4. Actualitzar professor");
                System.out.println("5. Llistar mòduls professionals");
                System.out.println("6. Afegir mòdul professional");
                System.out.println("7. Eliminar mòdul professional");
                System.out.println("8. Actualitzar mòdul professional");
                System.out.println("9. Sortir");
                System.out.print("Selecciona una opció: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        professorManager.readDam2(connection);
                        break;
                    case 2:
                        System.out.print("Introdueix el nom del professor: ");
                        String professorName = scanner.nextLine();
                        System.out.print("Introdueix el cognom del professor: ");
                        String professorCognom = scanner.nextLine();
                        Professors professor = new Professors(professorName,professorCognom);

                        break;
                    case 3:
                        System.out.print("Introdueix l'ID del professor a eliminar: ");
                        int deleteProfessorId = scanner.nextInt();
                        professorManager.deleteDam2(deleteProfessorId,connection);
                        break;
                    case 4:
                        System.out.print("Introdueix l'ID del professor a actualitzar: ");
                        int updateProfessorId = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Introdueix el nou nom del professor: ");
                        String newProfessorName = scanner.nextLine();
                        professorManager.updateDam2(updateProfessorId, newProfessorName, connection);
                        break;

                    case 5:

                        System.out.print("Introdueix el nom del mòdul: ");
                        String moduleName = scanner.nextLine();
                        System.out.print("Introdueix l'ID del professor (o 0 per cap): ");
                        int professorId = scanner.nextInt();
                        modulManager.addDam2(moduleName, professorId == 0 ? null : professorId,connection);
                       
                        break;
                    case 6:

                        System.out.print("Introdueix el nom del mòdul a eliminar: ");
                        String moduleToDelete = scanner.nextLine();
                        modulManager.deleteDam2(moduleToDelete,connection);

                        break;
                    case 7:

                        System.out.print("Introdueix el nom del mòdul a actualitzar: ");
                        String oldModuleName = scanner.nextLine();
                        System.out.print("Introdueix el nou nom del mòdul: ");
                        String newModuleName = scanner.nextLine();
                        System.out.print("Introdueix l'ID del nou professor (o 0 per cap): ");
                        int newProfessorId = scanner.nextInt();
                        modulManager.updateDam2(oldModuleName, newModuleName, newProfessorId == 0 ? null : newProfessorId,connection);
                        break;
                    case 8:
                        // Exit the menu
                        System.out.println("Sortint del programa...");
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torna-ho a intentar.");
                }
            } while (choice != 9);

            DBConnection.closeConnection(connection);
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
