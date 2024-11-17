package com.dam2.BDsrc;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            ModulProfessional modulManager = new ModulProfessional();
            Professors professorManager = new Professors();
            Scanner scanner = new Scanner(System.in);
            int first;
            int second;

            Connection connection = DBConnection.createConnection();

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Gestionar professors");
                System.out.println("2. Gestionar mòduls professionals");
                System.out.println("3. Sortir");
                System.out.print("Selecciona una opció: ");
                first = Integer.parseInt(scanner.nextLine());
                

                switch (first) {
                    case 1: 
                        do {
                            System.out.println("\n=== GESTIONAR PROFESSORS ===");
                            System.out.println("1. Alta");
                            System.out.println("2. Llistar");
                            System.out.println("3. Actualitzar");
                            System.out.println("4. Eliminar");
                            System.out.println("5. Tornar al menú principal");
                            System.out.print("Selecciona una opció: ");
                            second = Integer.parseInt(scanner.nextLine());

                            switch (second) {
                                case 1: 
                                    System.out.print("Introdueix el nom del professor: ");
                                    String professorName = scanner.nextLine();
                                    System.out.print("Introdueix el cognom del professor: ");
                                    String professorCognom = scanner.nextLine();
                                    Professors professor = new Professors(professorName, professorCognom);
                                    professorManager.addDam2(professor, connection);
                                    System.out.println("Professor afegit: " + professorName + " " + professorCognom);
                                    break;
                                case 2: 
                                    professorManager.readDam2(connection);
                                    break;
                                case 3: 
                                    System.out.print("Introdueix l'ID del professor a actualitzar: ");
                                    int updateProfessorId = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Introdueix el nou nom del professor: ");
                                    String newProfessorName = scanner.nextLine();
                                    professorManager.updateDam2(updateProfessorId, newProfessorName, connection);
                                    break;
                                case 4: 
                                    System.out.print("Introdueix l'ID del professor a eliminar: ");
                                    int deleteProfessorId = Integer.parseInt(scanner.nextLine());
                                    professorManager.deleteDam2(deleteProfessorId, connection);
                                    break;
                                case 5: 
                                    System.out.println("Tornant al menú principal...");
                                    break;
                                default:
                                    System.out.println("Opció no vàlida. Torna-ho a intentar.");
                            }
                        } while (second != 5);
                        break;

                    case 2: 
                        do {
                            System.out.println("\n=== GESTIONAR MÒDULS PROFESSIONALS ===");
                            System.out.println("1. Alta");
                            System.out.println("2. Llistar");
                            System.out.println("3. Actualitzar");
                            System.out.println("4. Eliminar");
                            System.out.println("5. Tornar al menú principal");
                            System.out.print("Selecciona una opció: ");
                            second = Integer.parseInt(scanner.nextLine());

                            switch (second) {
                                case 1: 
                                    System.out.print("Introdueix el nom del mòdul: ");
                                    String moduleName = scanner.nextLine();
                                    System.out.print("Introdueix l'ID del professor (o 0 per cap): ");
                                    int professorId = Integer.parseInt(scanner.nextLine());
                                    modulManager.addDam2(moduleName, professorId, connection);
                                    break;
                                case 2: 
                                    modulManager.readDam2(connection);
                                    break;
                                case 3: 
                                    System.out.print("Introdueix el nom del mòdul a actualitzar: ");
                                    String oldModuleName = scanner.nextLine();
                                    System.out.print("Introdueix el nou nom del mòdul: ");
                                    String newModuleName = scanner.nextLine();
                                    System.out.print("Introdueix l'ID del nou professor (o 0 per cap): ");
                                    int newProfessorId = Integer.parseInt(scanner.nextLine());
                                    modulManager.updateDam2(oldModuleName, newModuleName,
                                            newProfessorId, connection);
                                    break;
                                case 4: 
                                    System.out.print("Introdueix el nom del mòdul a eliminar: ");
                                    String moduleToDelete = scanner.nextLine();
                                    modulManager.deleteDam2(moduleToDelete, connection);
                                    break;
                                case 5: 
                                    System.out.println("Tornant al menú principal...");
                                    break;
                                default:
                                    System.out.println("Opció no vàlida. Torna-ho a intentar.");
                            }
                        } while (second != 5);
                        break;

                    case 3: 
                        System.out.println("Sortint del programa...");
                        break;

                    default:
                        System.out.println("Opció no vàlida. Torna-ho a intentar.");
                }
            } while (first != 3);

            DBConnection.closeConnection(connection);
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
