//IntervenantController.java
//IFT2255 - Équipe 15
//Controlluer pour l'Intevenant

package com.ift2255.MaVille;

import java.util.List;

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
        WorkRequestController.printAllRequests();
    }

    public List<WorkRequest> getWorkRequestsTest() {
        return WorkRequestController.getAllRequests(); // Assurez-vous que cette méthode existe et retourne une liste
    }

    public void applyToWorkRequest(int requestId) {
        // Fonction pour postuler à une requête de travail
    }   
}
