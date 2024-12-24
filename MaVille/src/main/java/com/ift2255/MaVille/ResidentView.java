//ResidentView.java
//IFT2255 - Équipe 15
//Classe view pour les résidents
package com.ift2255.MaVille;

import java.util.Scanner;
import java.util.LinkedList;
/**Classe qui gère la vue des résidents
 */
public class ResidentView extends View {
    private ResidentController residentController;

    public ResidentView(ResidentController residentController) {
        this.residentController = residentController;
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
	    System.out.println("5. Consulter vos préférences horaires");
        System.out.println("6. Se déconnecter");

        Scanner scanner = new Scanner(System.in);
        int choice = -1; // Initialiser choice
        while (choice < 1 || choice >= 6) { // Boucle jusqu'à une entrée valide
            System.out.print("\nVeuillez entrer votre choix (1-5) : ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 6) {
                    System.out.println("Option invalide. Essayez à nouveau.");
                    System.out.println("\nVoici les options disponibles :");
                    System.out.println("1. Voir mes requêtes de travail");
                    System.out.println("2. Ajouter une requête de travail");
                    System.out.println("3. Consulter les travaux en cours ou à venir");
                    System.out.println("4. Consulter les entraves");
		            System.out.println("5. Modifier mes préférences horaire");
                    System.out.println("6. Se déconnecter");
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
		//Consulter les préférences
                this.viewPreferences();
                break;
            case 6:
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

    public void viewPreferences() {
        LinkedList<Preference> preferences = this.residentController.getPreferences();
        if (preferences == null) {
            System.out.println("1. Ajouter une préférence");
            System.out.println("2. Revenir en arrière");
            int choix = scn.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Veuillez saisir votre nouvelle préférence");
                    String preferenceString = scn.nextLine();
                    residentController.addPreference(preferenceString);
                    this.viewPreferences();
                    break;
                case 2:
                    this.displayOptions();
                    break;

                default:
                    System.out.println("Veuillez choisir une option valide");
            }
        } else {
            for (int i = 0; i < preferences.size(); i++) {
                System.out.println(i + 1 + ".  " + preferences.get(i));
            }
            System.out.println(preferences.size() + 1 + ". Ajouter un nouveau horaire");
            System.out.println(preferences.size() + 2 + ". Revenir en arrière");

            int choice = scn.nextInt();
            if (choice > 0 && choice <= preferences.size()) {
                int x = choice - 1;
                System.out.println("1. Supprimer ce préférence");
                System.out.println("2. Modifier ce préférence");
                System.out.println("3. Revenir en arrière");
                scn.next();
                choice = scn.nextInt();
                switch (choice) {
                    case 1:
                        preferences.remove(x);
                        this.viewPreferences();
                        break;
                    case 2:
                        Preference preferenceChoisi = preferences.get(x);
                        String nouveauHoraire = scn.nextLine();
                        preferenceChoisi.setSchedule(nouveauHoraire);
                        break;
                    case 3:
                        this.displayOptions();
                        break;
                    default:
                        System.out.println("Veuillez choisi une option valide");
                        this.viewPreferences();

                }


            } else {
                if (choice == preferences.size() + 1) {
                    System.out.println("Veuillez saisir votre nouvelle préférence");
                    String preferenceString = scn.nextLine();
                    residentController.addPreference(preferenceString);
                    this.viewPreferences();
                } else if (choice == preferences.size() + 2) {
                    this.viewPreferences();
                } else {
                    System.out.println("Veuillez séléctionnez une option valide");
                    this.viewPreferences();
                }
            }

        }
    }

  /*  public void modifyPreference(Preference preference){
       System.out.println("Modification de la préférence\n" + preference);
       System.out.println("Veuillez taper la nouvelle préférence : ");
       preference.setSchedule(scn.nextLine());
    }*/

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


