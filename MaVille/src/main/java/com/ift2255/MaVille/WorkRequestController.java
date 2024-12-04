//WorkRequestController.java
//IFT2255 - Equipe 15
//Controlleur pour les requêtes de travail

//WorkRequestController.java
package com.ift2255.MaVille;

import java.util.ArrayList;
import java.util.List;

public class WorkRequestController extends Controller {
    private static List<WorkRequest> workRequests = new ArrayList<>();

    public static void addWorkRequest(WorkRequest request) {
        workRequests.add(request);
    }

    public static List<WorkRequest> getAllRequests() {
        return workRequests;
    }

    public static void printAllRequests() {
        if (workRequests.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            System.out.println("\nListe des requêtes de travail disponibles :");
            for (WorkRequest request : workRequests) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + request.getRequestID());
                System.out.println("Titre : " + request.getTitle());
                System.out.println("Description : " + request.getDescription());
                System.out.println("Type de travaux : " + request.getWorkType());
                System.out.println("Date prévue de début : " + request.getExpectedStartDate());
                System.out.println("Adresse : " + request.getWorkRequestAddress());
                System.out.println("Statut : " + request.getStatus());
                System.out.println("Résident affecté : " + request.getResident().getFirstName() + " " + request.getResident().getLastName());
                System.out.println("-------------------------------------\n");
            }
        }
    }

    public static void printAllRequestsWithNullStatus() {
        if (workRequests.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            System.out.println("\nListe des requêtes de travail disponibles :");
            for (WorkRequest request : workRequests) {
                if (request.getStatus() == "Pas encore commencé") {
                    System.out.println("-------------------------------------");
                    System.out.println("ID : " + request.getRequestID());
                    System.out.println("Titre : " + request.getTitle());
                    System.out.println("Description : " + request.getDescription());
                    System.out.println("Type de travaux : " + request.getWorkType());
                    System.out.println("Date prévue de début : " + request.getExpectedStartDate());
                    System.out.println("Adresse : " + request.getWorkRequestAddress());
                    System.out.println("Statut : " + request.getStatus());
                    System.out.println("Résident affecté : " + request.getResident().getFirstName() + " " + request.getResident().getLastName());
                    System.out.println("-------------------------------------\n");
                }
            }
        }
    }

    public static int getNumberOfRequests(){
        return workRequests.size();
    }

    public static List<Integer> iterateAllRequestsIdWithNullStatus() { 
        List<Integer> requestIds = new ArrayList<>();
        for (WorkRequest request : workRequests) {
            if (request.getStatus() == "Pas encore commencé") {
                requestIds.add(request.getRequestID()); 
            }
        }
        return requestIds;
    }

    public static WorkRequest getWorkRequestOnId(int requestId) { 
        for (WorkRequest request : workRequests) {
            if (request.getRequestID() == requestId) { 
                return request; // Retourne la requête correspondante
            }
        }
        return null; // Retourne null si aucune requête n'est trouvée
    }
}


