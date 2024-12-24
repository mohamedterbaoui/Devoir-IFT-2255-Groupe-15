//ResidentView.java
//IFT2255 - Équipe 15
//Classe view pour les résidents
package com.ift2255.MaVille;

import java.util.Scanner;
/**Classe qui gère la vue des résidents
 */
public class ResidentView extends View {
    private ResidentController residentController;

    public ResidentView(ResidentController residentController) {
        this.residentController = residentController;
	    displayOptions();
    }
/**Affiche les options pour l'utilisateur
 */

    /**
     * Affiche le menu principal pour les résidents.
     * Le résident peut choisir de voir ses requêtes de travail, d'ajouter une requête de travail, de consulter les travaux en cours ou à venir, de consulter les entraves ou de se déconnecter.
     */
    public void displayOptions() {
        System.out.println("\nVoici les options disponibles :");
        System.out.println("1. Voir mes requêtes de travail");
        System.out.println("2. Ajouter une requête de travail");
        System.out.println("3. Consulter les travaux en cours ou à venir");
        System.out.println("4. Consulter les travaux à venir dans les 3 prochains mois");
        System.out.println("5. Consulter les entraves");
        System.out.println("6. Consulter les entraves engendrées par un travail");
        System.out.println("7. Se déconnecter");

        Scanner scanner = new Scanner(System.in);
        int choice = -1; // Initialiser choice
        while (choice < 1 || choice > 7) { // Boucle jusqu'à une entrée valide
            System.out.print("\nVeuillez entrer votre choix (1-7) : ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 7) {
                    System.out.println("Option invalide. Essayez à nouveau.");
                    System.out.println("\nVoici les options disponibles :");
                    System.out.println("1. Voir mes requêtes de travail");
                    System.out.println("2. Ajouter une requête de travail");
                    System.out.println("3. Consulter les travaux en cours ou à venir");
                    System.out.println("4. Consulter les travaux à venir dans les 3 prochains mois");
                    System.out.println("5. Consulter les entraves");
                    System.out.println("6. Consulter les entraves engendrées par un travail");
                    System.out.println("7. Se déconnecter");
                }
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                scanner.next(); // Consomme l'entrée invalide
            }
        }

        switch (choice) {
            case 1:
                // Affiche toutes les requêtes de travail associées au résident
                viewWorkRequestsResident();
                displayOptions();
                break;
            case 2:
                // Appel la méthode pour ajouter une requête de travail
                break;
            case 3:
                // Consulter la liste des travaux avec option de recherche
                viewProjectsfromApi();
                displayOptions();
                break;
            case 4:
                // Consulter la liste des travaux des 3 prochains mois
                viewUpcomingProjects();
                displayOptions();
                break;
            case 5:
                // Consulter les entraves
                viewEntravesfromApi();
                displayOptions();
                break;
            case 6:
                // Consulter les entraves engendrées par un travail
                viewEntravesfromProject();
                displayOptions();
                break;
            case 7:
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                logoutResident();
            default:
                System.out.println("Option invalide. Essayez à nouveau.");
                displayOptions();
        }
        scanner.close();
    }

    // Affiche touts les projets associés au résident
    /**Afficher et imprimer les requêtes de travail
     */
    public void viewWorkRequestsResident() {
        System.out.println("\nVoici vos requêtes de travail :");
        residentController.viewWorkRequests(); 
    }

    /**
     * Affiche la liste des travaux en cours ou à venir.
     * 
     * Appele la méthode viewAllProjects() du contrôleur de résident pour obtenir la liste des travaux.
     * Affiche ensuite cette liste.
     */
    public void viewProjectsfromApi(){
        System.out.println("\nEntrer le nom du quartier pour filtrer l'affichage, sinon 0 pour tout afficher");
        Scanner scan = new Scanner(System.in);
        String borough = scan.nextLine();
        residentController.filterWorkByBorough(borough);
    }
    /**
     * Affiche la liste des travaux à venir dans les 3 prochains mois.
     * Cette méthode appelle la méthode {@link ResidentController#viewUpcomingProjects()}
     * pour afficher les projets à venir.
     */

    public void viewUpcomingProjects(){
        System.out.println("\nVoici la liste des travaux à venir dans 3 mois:");
        residentController.viewUpcomingProjects();
    }

    /**
     * Affiche la liste des entraves actuelles.
     * 
     * Cette méthode appelle la fonction viewAllEntraves() du contrôleur de résident
     * pour récupérer et afficher la liste des entraves.
     */
    public void viewEntravesfromApi(){
        System.out.println("\nEntrer le nom de la rue pour filtrer l'affichage, sinon 0 pour tout afficher");
        Scanner scan = new Scanner(System.in);
        String street = scan.nextLine();
        residentController.filterEntraveByRue(street);
    }

    /**
     * Permet à l'utilisateur de saisir l'ID d'un projet pour afficher les entraves associées à ce projet.
     * Si le projet existe et qu'il a des entraves, elles seront affichées.
     * Sinon, un message d'erreur sera affiché si le projet n'existe pas ou s'il n'a pas d'entraves.
     */

    public void viewEntravesfromProject(){
        System.out.println("Entrer l'ID du Projet pour voir les entraves conséquentes :");
        Scanner scan = new Scanner(System.in);
        int projectID = scan.nextInt();

        // trouver le projet et afficher sa liste d'entrave
        for (Project p : ProjectController.getProjectList()){
            if (p.getProjectId() == projectID){
                if (p.getEntraves() != null){
                    System.out.println(p.getEntraves());break;
                } else { System.out.println("Aucune entrave associée avec ce projet");break;}
            }else {
                System.out.println("Aucun projet avec ID:" + projectID + " n'existe");
            }
        }
    }

    /**
     * Déconnecte le résident en réinitialisant le ResidentController,
     * en initialisant un nouveau AuthController et en affichant la page
     * d'authentification.
     */
    public void logoutResident() {
        this.residentController = null;
        AuthController authController = new AuthController();
        Initialization.initialize(authController);
        AuthView authView = new AuthView(authController); 
    }
}


