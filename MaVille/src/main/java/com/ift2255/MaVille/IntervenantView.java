//IntervenantView.java
//IFT2255 - Equipe 15
//View pour l'intervenant

package com.ift2255.MaVille;

import java.util.Scanner;
/**Classe qui gère la vue des intérvenants
 */
public class IntervenantView extends View {
    private IntervenantController intervenantController;
/**Constructeur pour la classe IntervenantController
 * @param intervenantController le controlleur d'Intervenant
 */
    public IntervenantView(IntervenantController intervenantController) {
        this.intervenantController = intervenantController;
    }
/**Montrer les options pour le menu
 */
    public void displayOptions() {
        System.out.println("\nVoici les options disponibles :");
        System.out.println("1. Voir toutes les requêtes de travail");
        System.out.println("2. Postuler à une requête de travail");
        System.out.println("3. Se déconnecter");
    
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        boolean validChoice = false;
    
        while (!validChoice) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    System.out.println("Veuillez choisir une option valide\n1. Voir toutes les requêtes de travail\n2. Postuler à une requête de travail\n3. Se déconnecter");
                } else {
                    validChoice = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez choisir une option valide\n1. Voir toutes les requêtes de travail\n2. Postuler à une requête de travail\n3. Se déconnecter");
            }
        }
    
        // Gérer le choix de l'utilisateur
        switch (choice) {
            case 1:
                // Affiche toutes les requêtes de travail
                displayWorkRequests();  
                displayOptions();
                break;
            case 2:
                // Postule à une requête de travail
                displayOptions();
                break;                
            case 3:
                // Se déconnecte ou revient à l'écran d'accueil -- A IMPLÉMENTER, présentement ça ferme le programme
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                System.exit(0); // Quitte le programme
                break;
        }
        scanner.close();
    }
    

    // Affiche toutes les requêtes de travail
    /**Afficher sur le console les requêtes de travail
     */
    public void displayWorkRequests() {
        intervenantController.viewWorkRequests(); 
    }

    // Autres méthodes pour les actions de l'intervenant
}


