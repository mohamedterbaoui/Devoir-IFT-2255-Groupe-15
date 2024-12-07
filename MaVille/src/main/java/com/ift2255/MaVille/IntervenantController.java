//IntervenantController.java
//IFT2255 - Équipe 15
//Controlluer pour l'Intevenant

package com.ift2255.MaVille;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntervenantController extends Controller {
    private static Intervenant currentIntervenant;

    public IntervenantController(Intervenant intervenant) {
        currentIntervenant = intervenant;
    }

    public static void setCurrentIntervenant(Intervenant intervenant) {
        currentIntervenant = intervenant;
    }

    public static Intervenant getCurrentIntervenant() {
        return currentIntervenant;
    }

    public static void addProject() { // Soumettre un projet - RESTE à Envoyer une notification aux résidents du quartier
        ProjectController.addProject();
    }

    public void viewWorkRequests() { // Afficher toutes les requêtes de travail
        WorkRequestController.printAllRequests();
    }

    public List<WorkRequest> getWorkRequestsTest() {
        return WorkRequestController.getAllRequests();
    }

    public void applyToWorkRequest() { // Fonction pour postuler à une requête de travail
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
                    if (currentRequest != null) { // Vérifier si la requête existe (déjà vérifié, mais au cas où)
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

    public static void updateProjectStatus() { // Fonction pour Modifier le statut d'un projet - RESTE À Envoyer une notification aux résidents du quartier                               
        ProjectController.updateProjectStatus();
    }

    public static void trackApplicationStatus() { // Fonction pour faire le suivi de sa candidature/* */
        List<WorkRequest> appliedRequests = new ArrayList<>(); // Liste pour stocker les demandes auxquelles l'intervenant a appliqué
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

    public void withdrawApplication() {
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
