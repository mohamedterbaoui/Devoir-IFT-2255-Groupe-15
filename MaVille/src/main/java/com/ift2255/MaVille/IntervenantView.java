//IntervenantView.java
//IFT2255 - Equipe 15
//View pour l'intervenant

package com.ift2255.MaVille;

import java.util.Scanner;

public class IntervenantView extends View {
    private IntervenantController intervenantController;

    public IntervenantView(IntervenantController intervenantController) {
        this.intervenantController = intervenantController;
    }

    public void displayOptions() {
        System.out.println("Bienvenue, " + intervenantController.getCurrentIntervenant().getFirstName() + " " + intervenantController.getCurrentIntervenant().getLastName() + " !");
        System.out.println("Voici les options disponibles :");
        System.out.println("1. Voir toutes les requêtes de travail");
        System.out.println("2. Postuler à une requête de travail");
        System.out.println("3. Se déconnecter");

        // Récupérer l'option choisie par l'utilisateur
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Gérer le choix de l'utilisateur
        switch (choice) {
            case 1:
                // Affiche toutes les requêtes de travail
                displayWorkRequests();  
                break;
            case 2:
                // Postule à une requête de travail
                break;
            case 3:
                // Se déconnecte ou revenir à l'écran d'accueil
                break;
            default:
                System.out.println("Option invalide. Essayez à nouveau.");
        }
        scanner.close();
    }

    // Affiche toutes les requêtes de travail
    public void displayWorkRequests() {
        intervenantController.viewWorkRequests(); 
    }

    // Autres méthodes pour les actions de l'intervenant
}


