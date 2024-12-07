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
	residentController.setView(this);
	System.out.println("ResidentController");
    }
/**Affiche les options pour l'utilisateur
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
                System.exit(0); // Quitte le programme
                break;
            default:
                System.out.println("Option invalide. Essayez à nouveau.");
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
/**Afficher et imprime des travaux à partir de l'API
 */
    public void viewProjectsfromApi(){
        System.out.println("\nVoici la liste des travaux en cours ou à venir:");
        residentController.viewAllProjects();
    }
/**Affiche et montre au résident les entraves de l'API
 */
    public void viewEntravesfromApi(){
        System.out.println("\nVoici la liste des Entraves:");
        residentController.viewAllEntraves();
    }

    // Autres méthodes pour les actions du résident
}


