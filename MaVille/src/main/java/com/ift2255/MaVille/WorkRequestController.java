//WorkRequestController.java
//IFT2255 - Equipe 15
//Controlleur pour les requêtes de travail

//WorkRequestController.java
package com.ift2255.MaVille;

import java.util.ArrayList;
import java.util.List;
/**Controller poure les requêtes de travail
 */
public class WorkRequestController extends Controller {
    private static List<WorkRequest> workRequests = new ArrayList<>();
    /**
     * Affiche toutes les requêtes de travail actuelles. Si la liste est vide,
     * affiche un message indiquant qu'il n'y a pas de requête de travail
     * disponible.
     */
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
                System.out.println("-------------------------------------\n");
            }
        }
    }

    /**
     * Affiche toutes les requêtes de travail actuelles dont le statut est
     * {@link WorkRequestStatusEnum#NOT_YET_STARTED}.
     */
    public static void printAllRequestsWithNullStatus() {
        if (workRequests.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            System.out.println("\nListe des requêtes de travail disponibles :");
            for (WorkRequest request : workRequests) {
                if (request.getStatus() == WorkRequestStatusEnum.NOT_YET_STARTED) { // Modification ici
                    System.out.println("-------------------------------------");
                    System.out.println("ID : " + request.getRequestID());
                    System.out.println("Titre : " + request.getTitle());
                    System.out.println("Description : " + request.getDescription());
                    System.out.println("Type de travaux : " + request.getWorkType());
                    System.out.println("Date prévue de début : " + request.getExpectedStartDate());
                    System.out.println("Adresse : " + request.getWorkRequestAddress());
                    System.out.println("Statut : " + request.getStatus());
                    System.out.println("-------------------------------------\n");
                }
            }
        }
    }

    /**
     * Renvoie la liste des ID des requêtes de travail qui ont un statut
     * {@link WorkRequestStatusEnum#NOT_YET_STARTED}.
     *
     * @return une liste d'entiers
     */
    public static List<Integer> iterateAllRequestsIdWithNullStatus() { 
        List<Integer> requestIds = new ArrayList<>();
        for (WorkRequest request : workRequests) {
            if (request.getStatus() == WorkRequestStatusEnum.NOT_YET_STARTED) { // Modification ici
                requestIds.add(request.getRequestID()); 
            }
        }
        return requestIds;
    }

    /**
     * Returns the total number of work requests.
     *
     * @return the total number of work requests as an integer
     */
    public static int getNumberOfRequests(){
        return workRequests.size();
    }

    /**
     * Returns the WorkRequest associated with the given ID if it exists, otherwise
     * returns null.
     *
     * @param requestId the ID of the WorkRequest to retrieve
     * @return the WorkRequest associated with the given ID, or null if not found
     */
    public static WorkRequest getWorkRequestOnId(int requestId) { 
        for (WorkRequest request : workRequests) {
            if (request.getRequestID() == requestId) { 
                return request; // Retourne la requête correspondante
            }
        }
        return null; // Retourne null si aucune requête n'est trouvée
    }

}



