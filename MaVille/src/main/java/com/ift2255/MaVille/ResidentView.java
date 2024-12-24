//ResidentView.java
//IFT2255 - Équipe 15
//Classe view pour les résidents
package com.ift2255.MaVille;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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
        System.out.println("7. Consulter mes préférences horaires");
        System.out.println("8. Se déconnecter");

        Scanner scanner = new Scanner(System.in);
        int choice = -1; // Initialiser choice
        while (choice < 1 || choice > 8) { // Boucle jusqu'à une entrée valide
            System.out.print("\nVeuillez entrer votre choix (1-8) : ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 8) {
                    System.out.println("Option invalide. Essayez à nouveau.");
                    System.out.println("\nVoici les options disponibles :");
                    System.out.println("1. Voir mes requêtes de travail");
                    System.out.println("2. Ajouter une requête de travail");
                    System.out.println("3. Consulter les travaux en cours ou à venir");
                    System.out.println("4. Consulter les travaux à venir dans les 3 prochains mois");
                    System.out.println("5. Consulter les entraves");
                    System.out.println("6. Consulter les entraves engendrées par un travail");
                    System.out.println("7. Consulter mes préférences horaires");
                    System.out.println("8. Se déconnecter");
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
                addWorkRequest();
                displayOptions();
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
                // Consulter mes preferences
                this.viewPreferences();
                displayOptions();
                break;
            case 8:
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                logoutResident();
            default:
                System.out.println("Option invalide. Essayez à nouveau.");
                displayOptions();
        }
        scanner.close();
    }

    /**Afficher et imprimer les requêtes de travail
     */
    public void viewWorkRequestsResident() {
        System.out.println("\nVoici vos requêtes de travail :");
        residentController.viewWorkRequests(); 
    }

    /**
     * Ajouter une requete de travail
     */
    public void addWorkRequest() {
        // Demander les informations à l'utilisateur
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer l'identifiant de la demande de travaux : ");
        int workRequestId = Integer.parseInt(scanner.nextLine());

        System.out.println("Veuillez entrer le titre de la demande de travaux : ");
        String title = scanner.nextLine();

        System.out.println("Veuillez entrer la description des travaux : ");
        String description = scanner.nextLine();

        System.out.println("Veuillez entrer la date de début prévue (format: yyyy-MM-dd) : ");
        String dateInput = scanner.nextLine();
        Date expectedStartDate = null;
        try {
            expectedStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Format de date invalide. Veuillez entrer une date valide.");
            return;
        }

        System.out.println("Veuillez entrer le type de travaux (ex: Construction, Réparation, etc.) : ");
        String workType = scanner.nextLine();

        System.out.println("Veuillez entrer l'adresse du lieu des travaux : ");
        System.out.println("Numéro de rue : ");
        int streetNumber = scanner.nextInt();
        scanner.nextLine();  // Consommer la nouvelle ligne
        System.out.println("Nom de la rue : ");
        String streetName = scanner.nextLine();

        // Créer une nouvelle rue avec les informations fournies
        Street workRequestAddress = new Street(streetNumber, streetName);

        // Créer la nouvelle requête de travail avec les informations saisies
        WorkRequest newRequest = new WorkRequest(workRequestId, title, description, expectedStartDate, workType, workRequestAddress);

        // associer cette requete avec l'utilisateur actif
        this.residentController.getCurrentResident().linkWorkRequest(newRequest);

        // Ajouter la requête à la liste de demandes de travaux
        // (Cela pourrait être une méthode dans un contrôleur qui gère les demandes)
        WorkRequestController.addWorkRequest(newRequest);

        System.out.println("La requête de travail a été ajoutée avec succès !");
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
        scan.nextLine();

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
     * Affiche et gère les préférences d'un résident.
     *
     * Cette méthode permet au résident de :
     * <ul>
     *   <li>Visualiser ses préférences actuelles.</li>
     *   <li>Ajouter une nouvelle préférence.</li>
     *   <li>Supprimer ou modifier une préférence existante.</li>
     *   <li>Revenir au menu précédent.</li>
     * </ul>
     *
     * La méthode s'exécute dans une boucle infinie et interagit avec l'utilisateur
     * pour obtenir des choix via la console. Elle repose sur la méthode
     * {@link #getUserChoice(int, int)} pour valider les entrées utilisateur et
     * utilise {@link #handlePreferenceAction(LinkedList, int)} pour gérer les
     * actions spécifiques sur une préférence.
     *
     * @throws NumberFormatException si l'utilisateur saisit un choix invalide lors de l'interaction.
     * @see #getUserChoice(int, int)
     * @see #handlePreferenceAction(LinkedList, int)
     */
    public void viewPreferences() {
        while (true) {
            LinkedList<Preference> preferences = this.residentController.getPreferences();
            if (preferences == null || preferences.isEmpty()) {
                System.out.println("1. Ajouter une préférence");
                System.out.println("2. Revenir en arrière");

                int choix = getUserChoice(1, 2);
                switch (choix) {
                    case 1:
                        System.out.println("Veuillez saisir votre nouvelle préférence :");
                        String preferenceString = scn.nextLine();
                        residentController.addPreference(preferenceString);
                        break; // Rafraîchir après ajout
                    case 2:
                        return; // Quitter la méthode
                }
            } else {
                System.out.println("Préférences actuelles :");
                for (int i = 0; i < preferences.size(); i++) {
                    System.out.println((i + 1) + ". " + preferences.get(i));
                }
                System.out.println((preferences.size() + 1) + ". Ajouter une nouvelle préférence");
                System.out.println((preferences.size() + 2) + ". Revenir en arrière");

                int choice = getUserChoice(1, preferences.size() + 2);
                if (choice > 0 && choice <= preferences.size()) {
                    handlePreferenceAction(preferences, choice - 1);
                } else if (choice == preferences.size() + 1) {
                    System.out.println("Veuillez saisir votre nouvelle préférence :");
                    String preferenceString = scn.nextLine();
                    residentController.addPreference(preferenceString);
                } else if (choice == preferences.size() + 2) {
                    return; // Quitter la méthode
                }
            }
        }
    }

    /**
     * Gère les actions associées à une préférence spécifique.
     *
     * Cette méthode permet à l'utilisateur de :
     * <ul>
     *   <li>Supprimer une préférence existante.</li>
     *   <li>Modifier une préférence existante.</li>
     *   <li>Revenir au menu précédent.</li>
     * </ul>
     *
     * Elle affiche un sous-menu avec les options disponibles pour la préférence
     * sélectionnée, puis exécute l'action choisie.
     *
     * @param preferences la liste des préférences associées au résident.
     * @param index l'indice de la préférence sélectionnée dans la liste.
     * @throws IndexOutOfBoundsException si l'indice fourni est invalide.
     * @see #viewPreferences()
     */
    private void handlePreferenceAction(LinkedList<Preference> preferences, int index) {
        Preference selectedPreference = preferences.get(index);
        System.out.println("1. Supprimer cette préférence");
        System.out.println("2. Modifier cette préférence");
        System.out.println("3. Revenir en arrière");

        int choice = getUserChoice(1, 3);
        switch (choice) {
            case 1:
                preferences.remove(index);
                System.out.println("Préférence supprimée.");
                break;
            case 2:
                System.out.println("Saisissez le nouveau horaire pour cette préférence :");
                String nouveauHoraire = scn.nextLine();
                selectedPreference.setSchedule(nouveauHoraire);
                System.out.println("Préférence mise à jour.");
                break;
            case 3:
                // Ne rien faire, revenir à l'affichage principal
                break;
        }
    }
    /**
     * Demande à l'utilisateur de faire un choix dans une plage spécifiée.
     *
     * Cette méthode s'assure que l'utilisateur saisit un entier valide
     * compris entre les valeurs minimales et maximales fournies.
     *
     * @param min la valeur minimale acceptable pour le choix.
     * @param max la valeur maximale acceptable pour le choix.
     * @return le choix de l'utilisateur, un entier compris entre min et max.
     * @throws IllegalArgumentException si min est supérieur à max.
     */
    private int getUserChoice(int min, int max) {
        int choice = -1;
        while (true) {
            try {
                System.out.print("Votre choix : ");
                choice = Integer.parseInt(scn.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Veuillez entrer un nombre entre " + min + " et " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
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


