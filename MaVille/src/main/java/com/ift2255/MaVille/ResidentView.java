//ResidentView.java
//IFT2255 - Équipe 15
//Classe view pour les résidents
package com.ift2255.MaVille;

import java.util.Scanner;

public class ResidentView extends View {
    private ResidentController residentController;

    public ResidentView(ResidentController residentController) {
        this.residentController = residentController;
    }

    public void displayOptions() {
        System.out.println("Bienvenue, " + residentController.getCurrentResident().getFirstName() + " " + residentController.getCurrentResident().getLastName() + " !");
        System.out.println("Voici les options disponibles :");
        System.out.println("1. Voir mes requêtes de travail");
        System.out.println("2. Ajouter une requête de travail");
        System.out.println("3. Se déconnecter");
        // Les autres options pourront être ajoutées ici avec le switch plus bas

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Affiche toutes les requêtes de travail associées au résident
                viewWorkRequestsResident();
                break;
            case 2:
                // Appel la méthode pour ajouter une requête de travail
                break;
            case 3:
                // Se déconnecte ou revient à l'écran d'accueil
                break;
            default:
                System.out.println("Option invalide. Essayez à nouveau.");
        }
        scanner.close();
    }

    // Affiche toutes les projets associés au résident
    public void viewWorkRequestsResident() {
        System.out.println("Voici vos requêtes de travail :");
        residentController.viewWorkRequests(); 
    }

    // Autres méthodes pour les actions du résident
}


