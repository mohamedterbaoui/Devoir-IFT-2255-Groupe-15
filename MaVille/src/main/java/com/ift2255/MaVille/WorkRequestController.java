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
/**Ajouter une requête de travail
 * @param request La nouvelle requête de travail
 */
    public static void addWorkRequest(WorkRequest request) {
        workRequests.add(request);
    }
/**Afficher les requêtes de travail
 * @return une liste chaînée des travaux
 */
    public static List<WorkRequest> getAllRequests() {
        return workRequests;
    }
/**@deprecated Une méthode qui imprime les requêtes sur le console...
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
                System.out.println("Résident affecté : " + request.getResident().getFirstName() + " " + request.getResident().getLastName());
                System.out.println("-------------------------------------\n");
            }
        }
    }
}


