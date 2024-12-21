//Initialization.java
//IFT2255 - Équipe 15
//Classe d'initialisation
package com.ift2255.MaVille;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Initialization {
    /*
     * 
     * public static void initialize(AuthController authController) {
     * try {
     * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     * 
     * // Résidents
     * Resident resident1 = new Resident("Alice", "Dupont",
     * dateFormat.parse("1998-10-23"), "alice@mail.com", "password123",
     * "1234567890", "123 Rue A", "Montréal");
     * Resident resident2 = new Resident("Bob", "Martin",
     * dateFormat.parse("2000-12-18"), "bob@mail.com", "securepass", "1234567890",
     * "456 Rue B", "Montréal");
     * Resident resident3 = new Resident("Caroline", "Lavoie",
     * dateFormat.parse("1956-05-03"), "caroline@mail.com", "pass789", "1234567890",
     * "789 Rue C", "Montréal");
     * 
     * authController.residents.add(resident1);
     * authController.residents.add(resident2);
     * authController.residents.add(resident3);
     * 
     * // Intervenants
     * Intervenant intervenant1 = new Intervenant("Entreprise A", "Public",
     * dateFormat.parse("1981-08-15"), "entrepriseA@mail.com", "password123",
     * "1234567890", "321 Rue D", "Entreprise publique", 101);
     * Intervenant intervenant2 = new Intervenant("Entreprise B", "Privé",
     * dateFormat.parse("1965-09-16"), "entrepriseB@mail.com", "securepass",
     * "1234567890", "654 Rue E", "Entrepreneur privé", 102);
     * Intervenant intervenant3 = new Intervenant("Entreprise C", "Particulier",
     * dateFormat.parse("1999-07-17"), "entrepriseC@mail.com", "pass789",
     * "1234567890", "987 Rue F", "Particulier", 103);
     * 
     * authController.intervenants.add(intervenant1);
     * authController.intervenants.add(intervenant2);
     * authController.intervenants.add(intervenant3);
     * 
     * // Requêtes de travail
     * ResidentController residentController1 = new ResidentController(resident1);
     * ResidentController residentController2 = new ResidentController(resident2);
     * 
     * // Requêtes de travail associées aux résidents
     * resident1.addWorkRequest(residentController1, "Réparation route",
     * "Réparer les nids-de-poule sur la rue principale.", "Travaux routiers",
     * dateFormat.parse("2024-10-30"), new Street(1, "912 Rue F"));
     * 
     * resident1.addWorkRequest(residentController1, "Panneau stop à ajouter",
     * "Installer un nouveau panneau stop sur la rue", "Travaux de signalisation",
     * dateFormat.parse("2024-11-15"), new Street(2, "345 Rue T"));
     * 
     * resident2.addWorkRequest(residentController2, "Entretien paysager",
     * "Tailler les arbres et nettoyer les espaces verts.", "Entretien paysager",
     * dateFormat.parse("2024-11-20"), new Street(3, "567 Rue Y"));
     * 
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     */
    private static final String PROJECTS_FILE = "projects.txt";
    private static final String WORK_REQUESTS_FILE = "workRequests.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void initialize(AuthController authController) {
        loadProjects();
        loadWorkRequests();  
    }

    private static void loadProjects() {
        try (BufferedReader br = new BufferedReader(new FileReader(PROJECTS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming a comma-separated format: id,title,projectAddress,startDate,endDate,description,intervenantId,heureDebut,heureFin,projectType
                String[] parts = line.split(",");
                if (parts.length >= 10) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String projectAddress = parts[2];
                    Date startDate = dateFormat.parse(parts[3]);
                    Date endDate = dateFormat.parse(parts[4]);
                    String description = parts[5];
                    int intervenantId = Integer.parseInt(parts[6]); // Assumant un ID pour l'intervenant
                    String heureDebut = parts[7];
                    String heureFin = parts[8];
                    ProjectType projectType = ProjectType.valueOf(parts[9]);

                    Project project = new Project(id, title, projectAddress, startDate, endDate, description, intervenant, heureDebut, heureFin, projectType);
                    ProjectController.addProject(project);
                } else {
                    System.err.println("Ligne invalide dans projects.txt : " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier projects.txt : " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Erreur lors de l'analyse de la date dans projects.txt : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format de nombre dans projects.txt : " + e.getMessage());
        }
    }

    private static void loadWorkRequests() {
        try (BufferedReader br = new BufferedReader(new FileReader(WORK_REQUESTS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming a comma-separated format: id,title,description,expectedStartDate,workType,streetId,streetName
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String description = parts[2];
                    Date expectedStartDate = dateFormat.parse(parts[3]);
                    String workType = parts[4];
                    int streetId = Integer.parseInt(parts[5]);
                    String streetName = parts[6];

                    Street workRequestAddress = new Street(streetId, streetName);
                    WorkRequest workRequest = new WorkRequest(id, title, description, expectedStartDate, workType, workRequestAddress);
                    WorkRequestController.addWorkRequest(workRequest);
                } else {
                    System.err.println("Ligne invalide dans workRequests.txt : " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier workRequests.txt : " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Erreur lors de l'analyse de la date dans workRequests.txt : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format de nombre dans workRequests.txt : " + e.getMessage());
        }
    }

    public static void saveData(List<Project> projectList, List<WorkRequest> workRequests) {
        FileOps.saveToFile(projectList, FileOps.PROJECTS_FILE);
        FileOps.saveToFile(workRequests, FileOps.WORK_REQUESTS_FILE);
    }
}
