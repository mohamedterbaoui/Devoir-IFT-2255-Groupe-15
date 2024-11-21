//IntervenantController.java
//IFT2255 - Équipe 15
//Controlluer pour l'Intevenant

package com.ift2255.MaVille;

import java.util.LinkedList;

public class IntervenantController extends Controller {
    private Intervenant currentIntervenant;

    public IntervenantController(Intervenant intervenant) {
        this.currentIntervenant = intervenant;
    }

    public Intervenant getCurrentIntervenant() {
        return currentIntervenant;
    }

    public void submitProject(Project project) {
        // Fonction pour soumettre un projet
    }

    // Afficher toutes les requêtes de travail
    public void viewWorkRequests() {
        if (AuthController.workRequests.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            System.out.println("Liste des requêtes de travail disponibles :");
            for (WorkRequest request : AuthController.workRequests) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + request.getRequestID());
                System.out.println("Titre : " + request.getTitle());
                System.out.println("Description : " + request.getDescription());
                System.out.println("Type de travaux : " + request.getWorkType());
                System.out.println("Date prévue de début : " + request.getExpectedStartDate());
                System.out.println("Adresse : " + request.getWorkRequestAddress());
                System.out.println("Statut : " + request.getStatus());
            }
        }
    }    

    public void applyToWorkRequest(int requestId) {
        // Fonction pour postuler à une requête de travail
    }   
}
