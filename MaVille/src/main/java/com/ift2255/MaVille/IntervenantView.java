//IntervenantView.java
//IFT2255 - Equipe 15
//View pour l'intervenant

package com.ift2255.MaVille;

import java.util.Scanner;
/**Classe qui gère la vue des intérvenants
 */
public class IntervenantView extends View {
    private IntervenantController intervenantController;
    Scanner scanner = new Scanner(System.in);

    public IntervenantView(IntervenantController intervenantController) {
        this.intervenantController = intervenantController;
    }

    /**
     * Affiche les options disponibles pour l'intervenant.
     * <p>
     * Les options sont :
     * <ul>
     * <li>1. Voir toutes les requêtes de travail</li>
     * <li>2. Appliquer à une requête de travail</li>
     * <li>3. Retirer sa candidature</li>
     * <li>4. Soumettre un projet</li>
     * <li>5. Modifier le statut d'un projet</li>
     * <li>6. Faire le suivi d'une candidature</li>
     * <li>7. Se déconnecter</li>
     * </ul>
     * <p>
     * Une fois l'utilisateur a choisi une option, la fonction traite le choix correspondant.
     * Si l'utilisateur entre une option invalide, la fonction affiche un message d'erreur
     * et redemande une option.
     */
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
    

   
    /**
     * Affiche toutes les requêtes de travail.
     * 
     * Appele la méthode viewWorkRequests() du contrôleur d'intervenant pour
     * afficher la liste des requêtes de travail.
     */
    public void displayWorkRequests() {
        intervenantController.viewWorkRequests(); 
    }

    /**
     * Déconnecte l'intervenant en réinitialisant le IntervenantController,
     * en initialisant un nouveau AuthController et en affichant la page
     * d'authentification.
     */
    public void logoutIntervenant() {
        this.intervenantController = null; 
        AuthController authController = new AuthController();
        Initialization.initialize(authController);
        AuthView authView = new AuthView(authController); 
    }
}


