//IntervenantView.java
//IFT2255 - Equipe 15
//View pour l'intervenant

package com.ift2255.MaVille;

import java.util.Scanner;

public class IntervenantView extends View {
    private IntervenantController intervenantController;
    Scanner scanner = new Scanner(System.in);

    public IntervenantView(IntervenantController intervenantController) {
        this.intervenantController = intervenantController;
    }

    public void displayOptions() {
        int choice = -1;
        boolean validChoice = false;
        System.gc(); //Garbage Collector
        do {
            try {
                System.out.println("\nVoici les options disponibles :");
                System.out.println("1. Voir toutes les requêtes de travail");
                System.out.println("2. Appliquer à une requête de travail");
                System.out.println("3. Retirer sa candidature"); 
                System.out.println("4. Soumettre un projet");
                System.out.println("5. Modifier le statut d'un projet");
                System.out.println("6. Faire le suivi d'une candidature");
                System.out.println("7. Se déconnecter"); 
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 7) {
                    System.out.println("Veuillez choisir une option valide");
                } else {
                    validChoice = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrez un nombre valide");
            }
        } while (!validChoice);
    
        // Gérer le choix de l'utilisateur
        switch (choice) {
            case 1:
                // Affiche toutes les requêtes de travail
                displayWorkRequests();
                displayOptions();
                break;
            case 2:
                // Postule à une requête de travail
                intervenantController.applyToWorkRequest(); 
                displayOptions();
                break;
            case 3:
                intervenantController.withdrawApplication(); 
                displayOptions();
                break;
            case 4:
                IntervenantController.addProject();
                displayOptions();
                break;
            case 5:
                IntervenantController.updateProjectStatus();
                displayOptions();
                break;
            case 6:
                IntervenantController.trackApplicationStatus();
                displayOptions();
                break;
            case 7:
                // Se déconnecte ou revient à l'écran d'accueil -- A IMPLÉMENTER, présentement ça ferme le programme
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                logoutIntervenant();
        }
    
    }
    

    // Affiche toutes les requêtes de travail
    public void displayWorkRequests() {
        intervenantController.viewWorkRequests(); 
    }

    public void logoutIntervenant() {
        this.intervenantController = null; 
        AuthController authController = new AuthController();
        Initialization.initialize(authController);
        AuthView authView = new AuthView(authController); 
    }
}


