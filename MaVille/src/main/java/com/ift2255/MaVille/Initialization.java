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

    /*public static void initialize(AuthController authController) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Résidents
            Resident resident1 = new Resident("Alice", "Dupont", dateFormat.parse("1998-10-23"), "alice@mail.com", Hash.hasher("password123"), "1234567890", "123 Rue A", "H4p 1z6","Montréal");
            Resident resident2 = new Resident("Bob", "Martin", dateFormat.parse("2000-12-18"), "bob@mail.com", Hash.hasher("securepass"), "1234567890", "456 Rue B", "h4p 1z6","Montréal");
            Resident resident3 = new Resident("Caroline", "Lavoie", dateFormat.parse("1956-05-03"), "caroline@mail.com", Hash.hasher("pass789"), "1234567890", "789 Rue C", "h4p 1z6","Montréal");

            authController.residents.add(resident1);
            authController.residents.add(resident2);
            authController.residents.add(resident3);

            // Intervenants
            Intervenant intervenant1 = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"), "entrepriseA@mail.com", Hash.hasher("password123"), "1234567890", "321 Rue D", "Entreprise publique", 101);
            Intervenant intervenant2 = new Intervenant("Entreprise B", "Privé", dateFormat.parse("1965-09-16"), "entrepriseB@mail.com", Hash.hasher("securepass"), "1234567890", "654 Rue E", "Entrepreneur privé", 102);
            Intervenant intervenant3 = new Intervenant("Entreprise C", "Particulier", dateFormat.parse("1999-07-17"), "entrepriseC@mail.com", Hash.hasher("pass789"), "1234567890", "987 Rue F", "Particulier", 103);

            AuthController.intervenants.add(intervenant1);
            AuthController.intervenants.add(intervenant2);
            AuthController.intervenants.add(intervenant3);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private static final String PROJECTS_FILE = "src/main/java/com/ift2255/MaVille/projects.txt";
    private static final String WORK_REQUESTS_FILE = "src/main/java/com/ift2255/MaVille/workRequests.txt";

    private static final String INTERVENANT_FILE ="src/main/java/com/ift2255/MaVille/intervenants.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //private static List<Intervenant> intervenants = new LinkedList<>();


    public static void initialize(AuthController authController) {
        initializeIntervenants();
        loadProjects();
        System.out.println(ProjectController.getProjectList());
        loadWorkRequests();
    }

    private static void loadProjects() {
        try (BufferedReader br = new BufferedReader(new FileReader(PROJECTS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming a comma-separated format: id,title,projectAddress,startDate,endDate,description,intervenantCityId,heureDebut,heureFin,projectType
                String[] parts = line.split(",");
                if (parts.length >= 10) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    Quartiers projectAddress = Quartiers.valueOf(parts[2]);
                    Date startDate = dateFormat.parse(parts[3]);
                    Date endDate = dateFormat.parse(parts[4]);
                    String description = parts[5];
                    int intervenantCityId = Integer.parseInt(parts[6]); 
                    String heureDebut = parts[7];
                    String heureFin = parts[8];
                    ProjectType projectType = ProjectType.valueOf(parts[9]);

                    // Supposons que vous ayez une méthode pour obtenir tous les intervenants
                    //List<Intervenant> intervenants = AuthController.getAllIntervenants();

                    Intervenant intervenant = null;
                    for (Intervenant i : AuthController.getAllIntervenants()) {
                        if (i.getCityId() == intervenantCityId) { // Assurez-vous que getId() retourne l'ID correct
                            intervenant = i;
                            break;
                        }
                    }

                    if (intervenant != null) {
                        Project project = new Project(id, title, projectAddress, startDate, endDate, description, intervenant, heureDebut, heureFin, projectType);
                        ProjectController.addProject(project);
                    } else {
                        System.err.println("Intervenant avec l'ID " + intervenantCityId + " non trouvé.");
                    }
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

    public static void initializeIntervenants() {
        // Lire le fichier texte
        try (BufferedReader br = new BufferedReader(new FileReader(INTERVENANT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Diviser la ligne en fonction des virgules
                String[] data = line.split(",");
                // S'assurer qu'il y a suffisamment de données
                if (data.length == 9) {
                    try {
                        // Extraire les données de la ligne
                        String firstName = data[0].trim();
                        String lastName = data[1].trim();
                        Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(data[2].trim()); // Assurez-vous que le format de la date est correct
                        String email = data[3].trim();
                        String password = data[4].trim();
                        String phone = data[5].trim();
                        String userAddress = data[6].trim();
                        String typeIntervenant = data[7].trim();
                        int cityId = Integer.parseInt(data[8].trim());

                        // Créer un nouvel intervenant avec les données extraites
                        Intervenant intervenant = new Intervenant(firstName, lastName, birthDate, email, password, phone, userAddress, typeIntervenant, cityId);

                        // Ajouter l'intervenant à la liste
                        AuthController.intervenants.add(intervenant);

                    } catch (Exception e) {
                        System.err.println("Erreur lors de la lecture d'une ligne du fichier : " + e.getMessage());
                    }
                } else {
                    System.err.println("Ligne mal formatée dans le fichier intervenants.txt : " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public static void saveData() {
        FileOps.saveToFile(ProjectController.getProjectList(), FileOps.PROJECTS_FILE);
        FileOps.saveToFile(WorkRequestController.getAllRequests(), FileOps.WORK_REQUESTS_FILE);
        //FileOps.saveToFile(AuthController.getAllIntervenants(), FileOps.INTERVENANT_FILE);
    }
}
