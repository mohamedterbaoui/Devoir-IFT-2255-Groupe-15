//IntervenantController.java
//IFT2255 - Équipe 15
//Controlluer pour l'Intevenant

package com.ift2255.MaVille;

import java.util.List;
import java.util.Scanner;

public class IntervenantController extends Controller {
    private static Intervenant currentIntervenant;

    public IntervenantController(Intervenant intervenant) {
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
                WorkRequestController.printAllRequestsWithNullStatus(); // Affiche que si Statut == "Pas encore commencé"
                Scanner scanner = new Scanner(System.in);
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == -1) { // Pour quitter
                    validChoice = true;
                    System.gc(); // Garbage Collector
                }
                else if (WorkRequestController.iterateAllRequestsIdWithNullStatus().contains(choice)) { // ID dans la liste
                    validChoice = true; // Sort de la loop
                    WorkRequest currentRequest = WorkRequestController.getWorkRequestOnId(choice);
                    if (currentRequest != null) { // Vérifier si la requête existe (déjà vérifié, mais au cas où)
                        currentRequest.setStatus(currentIntervenant.getFirstName() + " a appliqué à ce projet");
                        System.out.println("Status correctement modifié. Vous avez correctement appliqué à cette requête de travail");

                        // Pour DEBUG
                        System.out.println("Requête de travail modifiée avec son FirstName :");
                        System.out.println("-------------------------------------");
                        System.out.println("ID : " + currentRequest.getRequestID());
                        System.out.println("Titre : " + currentRequest.getTitle());
                        System.out.println("Description : " + currentRequest.getDescription());
                        System.out.println("Type de travaux : " + currentRequest.getWorkType());
                        System.out.println("Date prévue de début : " + currentRequest.getExpectedStartDate());
                        System.out.println("Adresse : " + currentRequest.getWorkRequestAddress());
                        System.out.println("Statut : " + currentRequest.getStatus());
                        System.out.println("Résident affecté : " + currentRequest.getResident().getFirstName() + " " + currentRequest.getResident().getLastName());
                        System.out.println("-------------------------------------\n");
                    } 
                }
                else { // Si l'Id n'est pas dans la liste des requêtes.
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

    public void trackApplicationStatus(int requestID) { // Fonction pour faire le suivi de sa candidature
        
    }
}
