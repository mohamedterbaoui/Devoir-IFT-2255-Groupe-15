//ResidentController.java
//IFT2255 - Équipe 15
//Controlleur qui gére les résidents

//ResidentController.java
// ResidentController.java
package com.ift2255.MaVille;

import java.util.LinkedList;
import java.util.Date;

public class ResidentController extends Controller {

    private Resident currentResident;

    public ResidentController(Resident resident) {
        this.currentResident = resident;
    }

    public Resident getCurrentResident() {
        return currentResident;
    }

    // Affiche les requêtes de travail pour le résident
    public void viewWorkRequests() {
        LinkedList<WorkRequest> workRequests = currentResident.getWorkRequests();
        if (workRequests.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            for (WorkRequest request : workRequests) {
                System.out.println("ID : " + request.getRequestID() + ", Titre : " + request.getTitle());
            }
        }
    }

    public void viewProjects() {
        // Fonction pour gérer les projets
    }

    // Ajoute une requête de travail pour le résident connecté
    public void addWorkRequest(String title, String description, String workType, Date expectedStartDate, Street workRequestAddress) {
        WorkRequest newWorkRequest = new WorkRequest(title, description, expectedStartDate, workType, workRequestAddress);
        newWorkRequest.setResident(currentResident); // Associe la requête au résident connecté
        currentResident.getWorkRequests().add(newWorkRequest); // Ajoute la requête à la liste du résident
        WorkRequestController.addWorkRequest(newWorkRequest); // Ajoute la requête à la liste globale
    }
}


