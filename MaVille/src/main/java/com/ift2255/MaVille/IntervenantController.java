//IntervenantController.java
//IFT2255 - Équipe 15
//Controlluer pour l'Intevenant

package com.ift2255.MaVille;

import java.util.ArrayList;
import java.util.List;
/**Controlleur pour les fonctions d'intérvenant
 */
public class IntervenantController extends Controller {
    /**l'intervenant actuel
     */
    private Intervenant currentIntervenant;
/**Constructeur pour cette classe
 * @param intervenant L'intérvenant actuel
 */
    public IntervenantController(Intervenant intervenant) {
        currentIntervenant = intervenant;
    }
/**Retourne l'intervenant actuel
 * @return intervenant actuel
 */
    public Intervenant getCurrentIntervenant() {
        return currentIntervenant;
    }
/**Soumission d'un projet
 * @param project le nouveau projet
 */
    public void submitProject(Project project) {
        // Fonction pour soumettre un projet
    }

    /**Affichage des requêtes des travail et les envoyer vers le view pour affichage
     */
    public void viewWorkRequests() {
       List<WorkRequest> workRequests = WorkRequestController.getAllRequests();
       if (workRequests.isEmpty()){
	      view.display("Aucune requête de travail disponible.");
       } else {
	      for(WorkRequest wr : workRequests){
		     view.display(wr.toString());
	      } 
    }
    }
    
=======

    /**
     * Sets the current Intervenant in the IntervenantController.
     *
     * @param intervenant the Intervenant to be set as current
     */
    public static void setCurrentIntervenant(Intervenant intervenant) {
        currentIntervenant = intervenant;
    }

    /**
     * Returns the current Intervenant in the IntervenantController.
     *
     * @return the current Intervenant
     */
    public static Intervenant getCurrentIntervenant() {
        return currentIntervenant;
    }

    /**
     * Submits a new project.
     * 
     * Invokes the method to add a project via the ProjectController.
     */
    public static void addProject() { // Soumettre un projet - RESTE à Envoyer une notification aux résidents du quartier
        ProjectController.addProject();
    }

    /**
     * Affiche toutes les requêtes de travail.
     * 
     * Appele la méthode printAllRequests() du contrôleur de requête de travail pour
     * afficher la liste des requêtes de travail.
     */
    public void viewWorkRequests() { // Afficher toutes les requêtes de travail
        WorkRequestController.printAllRequests();
    }

    /**
     * Retrieves all current work requests.
     *
     * @return a list of all work requests

     */
    public List<WorkRequest> getWorkRequestsTest() {
        return WorkRequestController.getAllRequests();
    }

    /**
     * Applies to a work request.
     * 
     * This method is for an Intervenant to apply to a work request. The method
     * will show all current work requests and ask the Intervenant to enter the
     * ID of the work request they want to apply to. If the Intervenant enters
     * '-1', the method will exit. If the Intervenant enters a valid ID, the
     * method will update the status of the work request to IN_PROGRESS and
     * assign the work request to the current Intervenant.
     */
    public static void applyToWorkRequest() { // Fonction pour postuler à une requête de travail
        boolean validChoice = false;
        do {
            try {
                System.out.println("Veuillez entrer le ID de la requête à laquelle vous souhaitez appliquer\n si Vous désirez sortir de l'application, entrer '-1'");
                WorkRequestController.printAllRequestsWithNullStatus(); 
                Scanner scanner = new Scanner(System.in);
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == -1) { // Pour quitter
                    validChoice = true;
                    System.gc(); // Garbage Collector
                } else if (WorkRequestController.iterateAllRequestsIdWithNullStatus().contains(choice)) { 
                    validChoice = true; // Sort de la loop
                    WorkRequest currentRequest = WorkRequestController.getWorkRequestOnId(choice);
                    if (currentRequest != null) { // Vérifie si la requête existe (déjà vérifié, mais au cas où)
                        currentRequest.setStatus(WorkRequestStatusEnum.IN_PROGRESS); 
                        currentRequest.setIntervenant(currentIntervenant);
                        System.out.println("Status correctement modifié. Vous avez correctement appliqué à cette requête de travail");
                    }
                } else { // Si l'Id n'est pas dans la liste des requêtes.
                    System.out.println("Veuillez choisir une option valide");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrez un nombre");

            }
        } while (!validChoice);
    }

    /**
     * Modifie le statut d'un projet et envoie des notifications aux résidents affectés.
     * L'utilisateur est invité à choisir un projet parmi la liste des projets de l'intervenant connecté,
     * puis à choisir un statut parmi la liste des statuts possibles.
     * Si l'entrée est invalide, l'utilisateur est invité à réessayer.
     * @return le projet modifié, ou null si l'utilisateur a annulé
     */
    public static void updateProjectStatus() { // Fonction pour Modifier le statut d'un projet - RESTE À Envoyer une notification aux résidents du quartier                               
        ProjectController.updateProjectStatus();
    }

    /**
     * Fait le suivi de sa candidature.
     * 
     * Affiche les requêtes de travail auxquelles l'intervenant a postulé, et invite l'utilisateur à entrer le numéro de la requête pour afficher les détails.
     * Si l'entrée est invalide, l'utilisateur est invité à réessayer.
     * 
     * Si l'intervenant a annulé, la fonction renvoie null.
     */
    public static void trackApplicationStatus() { // Fonction pour faire le suivi de sa candidature/* */
List<WorkRequest> appliedRequests = new ArrayList<>(); 
        for (WorkRequest request : WorkRequestController.getAllRequests()) {
            if (request.getIntervenant() != null && request.getIntervenant().equals(currentIntervenant)) {
                appliedRequests.add(request);
            }
        }

        if (appliedRequests.isEmpty()) {
            System.out.println("Vous n'avez pas encore postulé à des requêtes de travail.");
            return;
        }

        System.out.println("Requêtes de travail auxquelles vous avez postulé:");
        for (int i = 0; i < appliedRequests.size(); i++) {
            WorkRequest request = appliedRequests.get(i);
            System.out.println((i + 1) + ". ID: " + request.getRequestID() + ", Titre: " + request.getTitle() + ", Adresse: " + request.getWorkRequestAddress());
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Veuillez entrer le numéro de la requête pour afficher les détails (ou 0 pour revenir au menu):");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Retour au menu principal. \n");
                break;
            }
            else if (choice > 0 && choice <= appliedRequests.size()) {
                WorkRequest selectedRequest = appliedRequests.get(choice - 1);
                System.out.println("\nDétails de la requête:");
                System.out.println("ID: " + selectedRequest.getRequestID());
                System.out.println("Titre: " + selectedRequest.getTitle());
                System.out.println("Description: " + selectedRequest.getDescription());
                System.out.println("Type de travaux: " + selectedRequest.getWorkType());
                System.out.println("Date prévue de début: " + selectedRequest.getExpectedStartDate());
                System.out.println("Adresse: " + selectedRequest.getWorkRequestAddress());
                System.out.println("Statut: " + selectedRequest.getStatus());
                break; 
            } else {
                System.out.println("Choix invalide.");
            }
        } while (choice != 0);
    }

    /**
     * Retire la candidature d'un intervenant à une requête de travail.
     * 
     * Cette méthode affiche les requêtes de travail auxquelles l'intervenant
     * actuel a postulé. L'utilisateur est invité à entrer le numéro de la
     * requête pour laquelle il souhaite retirer sa candidature. 
     * 
     * Si l'utilisateur confirme le retrait, la candidature est retirée et
     * le statut de la requête est réinitialisé à NOT_YET_STARTED. 
     * Si l'utilisateur annule, le retrait de candidature est annulé.
     * 
     * Si aucune requête n'est trouvée, un message informant qu'il n'y a
     * pas de candidature est affiché.
     */
    public static void withdrawApplication() {
        List<WorkRequest> appliedRequests = new ArrayList<>();
        for (WorkRequest request : WorkRequestController.getAllRequests()) {
            if (request.getIntervenant() != null && request.getIntervenant().equals(currentIntervenant)) {
                appliedRequests.add(request);
            }
        }

        if (appliedRequests.isEmpty()) {
            System.out.println("Vous n'avez pas encore postulé à des requêtes de travail.");
            return;
        }

        System.out.println("Requêtes de travail auxquelles vous avez postulé :");
        for (int i = 0; i < appliedRequests.size(); i++) {
            WorkRequest request = appliedRequests.get(i);
            System.out.println((i + 1) + ". ID : " + request.getRequestID() + ", Titre : " + request.getTitle() + ", Adresse : " + request.getWorkRequestAddress());
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Veuillez entrer le numéro de la requête pour retirer votre candidature (ou 0 pour revenir au menu) :");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next();
            }
            // Modification: Ajout de parseInt pour gérer les exceptions
            choice = Integer.parseInt(scanner.nextLine()); 
            if (choice == 0) {
                System.out.println("Retour au menu principal. \n");
                break;
            } else if (choice > 0 && choice <= appliedRequests.size()) {
                WorkRequest selectedRequest = appliedRequests.get(choice - 1);
                System.out.println("\nÊtes-vous sûr de vouloir retirer votre candidature de la requête : " + selectedRequest.getTitle() + " ?");
                System.out.println("1. Oui");
                System.out.println("2. Non");
                int confirmation = Integer.parseInt(scanner.nextLine()); 
                if (confirmation == 1) {
                    selectedRequest.setIntervenant(null);
                    selectedRequest.setStatus(WorkRequestStatusEnum.NOT_YET_STARTED);
                    System.out.println("Votre candidature a été retirée avec succès.");
                } else {
                    System.out.println("Retrait de candidature annulé.");
                }
                break;
            } else {
                System.out.println("Choix invalide.");
            }
        } while (choice != 0);
    }
}
