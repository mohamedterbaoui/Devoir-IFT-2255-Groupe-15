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

    /**
     * Renvoie la liste des projets.
     * @return la liste des projets
     */
    public static List<Project> getProjectList() {
        return projectList;
    }

    /**
     * Modifie le statut d'un projet et envoie des notifications aux résidents affectés.
     * L'utilisateur est invité à choisir un projet parmi la liste des projets de l'intervenant connecté,
     * puis à choisir un statut parmi la liste des statuts possibles.
     * Si l'entrée est invalide, l'utilisateur est invité à réessayer.
     * @return le projet modifié, ou null si l'utilisateur a annulé
     */
    public static Project updateProjectStatus() { // Reste à ajouter notif
        Scanner scanner = new Scanner(System.in);
        Project project = null;
    
        while (project == null) {
            System.out.println("Choisissez le projet que vous voulez modifier le statut (ou tapez '-1' pour annuler) :");
            displayProjectsOfCurrentIntervenant(); // affiche seulement les projets de l'intervenant connecté
            int input = scanner.nextInt();
            scanner.nextLine(); // Consomme le caractère de nouvelle ligne
            if (input == -1) {
                return null;
            }
    
            project = findProjectById(input - 1); // '-1' car sinon ça commence à 0 au lieu de 1 (ça montre 1 dans le display)
    
            if (project == null) {
                System.out.println("Projet introuvable. Veuillez réessayer.");
            }
        }
    
        // Affichage des statuts possibles
        System.out.println("Statuts possibles :");
        for (int i = 0; i < ProjectStatusEnum.values().length; i++) {
            System.out.println((i + 1) + ". " + ProjectStatusEnum.values()[i]);
        }
    
        int statusChoice;
        do {
            System.out.println("Choisissez un statut (entrez le numéro) :");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre :");
                scanner.next();
            }
            statusChoice = scanner.nextInt();
            scanner.nextLine(); // Consomme le caractère de nouvelle ligne
        } while (statusChoice < 1 || statusChoice > ProjectStatusEnum.values().length);
    
        project.setStatus(ProjectStatusEnum.values()[statusChoice - 1]);

        // Ajout de l'envoi des notifications aux résidents affectés
    
        return project;
    }
    
    /**
     * Affiche les projets de l'intervenant connecté.
     * 
     * Si la liste des projets est vide, affiche un message d'erreur.
     * Si l'intervenant n'a pas de projet, affiche un message d'erreur.
     * Sinon, affiche la liste des projets de l'intervenant avec leur statut.
     */
    public static void displayProjectsOfCurrentIntervenant() {
        if (projectList.isEmpty()) {
            System.out.println("Aucun projet trouvé.");
            return;
        }
    
        // Filtre pour afficher uniquement les projets de l'intervenant connecté
        List<Project> filteredProjects = projectList.stream()
                .filter(p -> p.getIntervenant().equals(IntervenantController.getCurrentIntervenant()))
                .toList();
    
        if (filteredProjects.isEmpty()) {
            System.out.println("Aucun projet trouvé pour cet intervenant.");
            return;
        }
    
        for (int i = 0; i < filteredProjects.size(); i++) {
            Project project = filteredProjects.get(i);
            System.out.println((i + 1) + ". " + project.getTitle() + " - Statut : " + project.getStatus());
        }
    }

    /**
     * Affiche la liste de tous les projets.
     * 
     * Si la liste des projets est vide, affiche un message d'erreur.
     * Sinon, affiche la liste des projets avec leur ID.
     */
    public static void displayProjects() { // Afiche toutes les projets
        if (projectList.isEmpty()) {
            System.out.println("Aucun projet trouvé.");
            return;
        }
        for (int i = 0; i < projectList.size(); i++) {
            System.out.println((i + 1) + ". " + projectList.get(i).getTitle());
        }
    }

    /**
     * Cherche un projet par son ID.
     * 
     * Si l'ID est trouvé, renvoie le projet correspondant.
     * Sinon, renvoie null.
     * 
     * @param input l'ID du projet à chercher
     * @return le projet correspondant, ou null si l'ID n'est pas trouvé
     */
    private static Project findProjectById(int input) {
        try {
            for (Project project : projectList) {
                if (project.getProjectId() == input) {
                    return project;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            return null;
        }
        return null;
    }

    /**
     * Ajoute un nouveau projet.
     * 
     * Demande à l'utilisateur de saisir le titre, l'adresse, la date de début, la date de fin, la description, l'heure de début, l'heure de fin et le type de projet.
     * Si l'utilisateur entre "annuler" à n'importe quelle étape, la fonction renvoie null.
     * 
     * Ajoute le projet à la liste des projets et renvoie le projet créé.
     * 
     * @return le projet créé, ou null si l'utilisateur a annulé la création du projet
     */
    public static Project addProject() { // Reste à ajouter notif
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
            try {
                
                // Afficher la liste des types de projet avec leur numéro
                System.out.println("Types de projet disponibles :");
                for (int i = 0; i < ProjectType.values().length; i++) {
                    System.out.println((i + 1) + ". " + ProjectType.values()[i]);
                }

                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("annuler")) {
                    return null; // Annulation de la création du projet
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
        System.out.println("Le projet a bien été ajouté.");

        // Ajout de l'envoi des notifications aux résidents affectés
        

        return newProject;
    }

    /**
     * Vérifie si une chaîne de caractères est une heure valide (format HH:mm, de 00:00 à 23:59).
     * @param time la chaîne de caractères à vérifier
     * @return true si la chaîne est une heure valide, false sinon
     */
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
