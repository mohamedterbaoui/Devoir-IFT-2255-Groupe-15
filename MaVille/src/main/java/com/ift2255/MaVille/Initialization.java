/**
 * Classe d'initialisation permettant de charger et sauvegarder les données
 * nécessaires à l'application MaVille.
 *
 * @author Équipe 15
 */
package com.ift2255.MaVille;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Initialization {

    /**
     * Chemin vers le fichier contenant les projets.
     */
    private static final String PROJECTS_FILE = "src/main/java/com/ift2255/MaVille/projects.txt";

    /**
     * Chemin vers le fichier contenant les requêtes de travaux.
     */
    private static final String WORK_REQUESTS_FILE = "src/main/java/com/ift2255/MaVille/workRequests.txt";

    /**
     * Chemin vers le fichier contenant les intervenants.
     */
    private static final String INTERVENANT_FILE = "src/main/java/com/ift2255/MaVille/intervenants.txt";

    /**
     * Chemin vers le fichier contenant les résidents.
     */
    private static final String RESIDENT_FILE = "src/main/java/com/ift2255/MaVille/residents.txt";

    /**
     * Format de date utilisé pour lire et écrire les dates dans les fichiers.
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Initialise toutes les données nécessaires au fonctionnement de l'application.
     *
     * @param authController le contrôleur d'authentification pour gérer les utilisateurs
     */
    public static void initialize(AuthController authController) {
        initializeResidents();
        initializeIntervenants();
        loadProjects();
        loadWorkRequests();

        Entrave entrave1 = new Entrave(1, "REQ123", "Boulevard Gouin", "BG", "3m", "Travaux de drainage", 5, "Partiellement bloqué", "Non bloqué", "Rue des Sources", "Rue Notre-Dame", 500, true);
        Entrave entrave2 = new Entrave(2, "REQ124", "Rue Notre-Dame", "ND", "5m", "Réfection de la chaussée", 2, "Complètement bloqué", "Partiellement bloqué", "Boulevard Gouin", "Avenue Papineau", 1000, false);

        // ajouter 2 entraves au premier projet
        ProjectController.getProjectList().get(0).getEntraves().add(entrave1);
        ProjectController.getProjectList().get(0).getEntraves().add(entrave2);

        // ajouter 2 requetes au premier resident
        AuthController.residents.getFirst().getWorkRequests().add(WorkRequestController.getWorkRequestOnId(1));
        AuthController.residents.getFirst().getWorkRequests().add(WorkRequestController.getWorkRequestOnId(2));
    }
    /**
     * Charge les projets depuis le fichier texte spécifié.
     */
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

    /**
     * Charge les requêtes de travaux depuis le fichier texte spécifié.
     */
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

    /**
     * Initialise les intervenants depuis le fichier texte.
     */
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

                        String hashedPassword = Hash.hasher(password);

                        // Créer un nouvel intervenant avec les données extraites
                        Intervenant intervenant = new Intervenant(firstName, lastName, birthDate, email, hashedPassword, phone, userAddress, typeIntervenant, cityId);

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

    /**
     * Initialise les résidents depuis le fichier texte.
     */
    public static void initializeResidents() {
        // Lire le fichier texte
        try (BufferedReader br = new BufferedReader(new FileReader(RESIDENT_FILE))) {
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
                        String city = data[8].trim();

                        // hasher les mots de passe avant de les stockers
                        String hashedPassword = Hash.hasher(password);

                        // Créer un nouvel intervenant avec les données extraites
                        Resident resident = new Resident(firstName, lastName, birthDate, email, hashedPassword, phone, userAddress, typeIntervenant, city);

                        // Ajouter l'intervenant à la liste
                        AuthController.residents.add(resident);

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

    /**
     * Sauvegarde les données actuelles dans les fichiers correspondants.
     */
    public static void saveData() {
        FileOps.saveToFile(ProjectController.getProjectList(), FileOps.PROJECTS_FILE);
        FileOps.saveToFile(WorkRequestController.getAllRequests(), FileOps.WORK_REQUESTS_FILE);
        //FileOps.saveToFile(AuthController.getAllIntervenants(), FileOps.INTERVENANT_FILE);
    }
}
