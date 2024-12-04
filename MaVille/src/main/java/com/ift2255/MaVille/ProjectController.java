//ProjectController.java
//IFT2255 - Équipe 15
//Controlleur pour le vue de projet?

package com.ift2255.MaVille;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectController extends Controller {
    private static List<Project> projectList = new ArrayList<>();

    public static List<Project> getProjectList() {
        return projectList;
    }

    public void updateProjectStatus(int projectId, String newStatus) {
        // fonction
    }

    public void editProjectDetails(int projectId, String description, Date endDate) {
        // fonction
    }

    public void viewProjectPreferences() {
        // fonction
    }

    public static Project addProject() {
        Scanner scanner = new Scanner(System.in);
        String title = null;
        while (title == null) {
            System.out.println("Entrez le titre du nouveau projet (ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            title = input;
        }
        String projectAddress = null;
        while (projectAddress == null) {
            System.out.println("Entrez l'adresse du nouveau projet (exemple: 123, Rue abc, ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            projectAddress = input;
        }

        Date startDate = null;
        while (startDate == null) {
            System.out.println("Entrez la date de début du projet (format: yyyy-MM-dd, ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            try {
                startDate = java.sql.Date.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Format de date invalide. Veuillez réessayer.");
            }
        }

        Date endDate = null;
        while (endDate == null) {
            System.out.println("Entrez la date de fin du projet (format: yyyy-MM-dd, ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            try {
                endDate = java.sql.Date.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Format de date invalide. Veuillez réessayer.");
            }
        }

        String description = null;
        while (description == null) {
            System.out.println("Entrez la description du projet (ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            description = input;
        }

        String heureDebut = null;
        while (heureDebut == null) {
            System.out.println("Entrez l'heure de début du projet (format HH:mm, ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            if (isValidTime(input)) {
                heureDebut = input;
            } else {
                System.out.println("Format d'heure invalide. Veuillez utiliser le format HH:mm (00:00 à 23:59).");
            }
        }

        String heureFin = null;
        while (heureFin == null) {
            System.out.println("Entrez l'heure de fin du projet (format HH:mm, ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            if (isValidTime(input)) {
                heureFin = input;
            } else {
                System.out.println("Format d'heure invalide. Veuillez utiliser le format HH:mm (00:00 à 23:59).");
            }
        }

        ProjectType projectType = null;
        while (projectType == null) {
            System.out.println("Entrez le type de projet (ou tapez 'annuler' pour annuler) :");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("annuler")) {
                return null; // Annulation de la création du projet
            }
            try {
                // Afficher la liste des types de projet avec leur numéro
                System.out.println("Types de projet disponibles :");
                for (int i = 0; i < ProjectType.values().length; i++) {
                    System.out.println((i + 1) + ". " + ProjectType.values()[i]);
                }

                int choix = Integer.parseInt(input);
                if (choix > 0 && choix <= ProjectType.values().length) {
                    projectType = ProjectType.values()[choix - 1];
                } else {
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et " + ProjectType.values().length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            }
        }

        Project newProject = new Project(title, projectAddress, startDate, endDate, description, IntervenantController.getCurrentIntervenant(), heureDebut, heureFin, projectType);
        projectList.add(newProject);
        return newProject;
    }

    private static boolean isValidTime(String time) {
        try {
            String[] parts = time.split(":");
            if (parts.length != 2) {
                return false;
            }
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
