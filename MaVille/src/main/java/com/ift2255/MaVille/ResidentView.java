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
	//residentController.setView(this);
	//System.out.println("ResidentController");
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
        System.out.println("4. Consulter les entraves");
        System.out.println("5. Se déconnecter");

        Scanner scanner = new Scanner(System.in);
        int choice = -1; // Initialiser choice
        while (choice < 1 || choice > 5) { // Boucle jusqu'à une entrée valide
            System.out.print("\nVeuillez entrer votre choix (1-5) : ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Option invalide. Essayez à nouveau.");
                    System.out.println("\nVoici les options disponibles :");
                    System.out.println("1. Voir mes requêtes de travail");
                    System.out.println("2. Ajouter une requête de travail");
                    System.out.println("3. Consulter les travaux en cours ou à venir");
                    System.out.println("4. Consulter les entraves");
                    System.out.println("5. Se déconnecter");
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
                // Consulter la listes des travaux
                viewProjectsfromApi();
                displayOptions();
                break;
            case 4:
                // Consulter les entraves
                viewEntravesfromApi();
                displayOptions();
                break;
            case 5:
                // Se déconnecte ou revient à l'écran d'accueil -- A IMPLÉMENTER, présentement ça ferme le programme
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                logoutResident();
            default:
                System.out.println("Option invalide. Essayez à nouveau.");
                displayOptions();
        }
        scanner.close();
    }

    // Affiche toutes les projets associés au résident
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
        System.out.println("\nVoici la liste des travaux en cours ou à venir:");
        residentController.viewAllProjects();
    }

    /**
     * Affiche la liste des entraves actuelles.
     * 
     * Cette méthode appelle la fonction viewAllEntraves() du contrôleur de résident
     * pour récupérer et afficher la liste des entraves.
     */
    public void viewEntravesfromApi(){
        System.out.println("\nVoici la liste des Entraves:");
        residentController.viewAllEntraves();
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


