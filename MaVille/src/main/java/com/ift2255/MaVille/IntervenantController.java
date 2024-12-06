//IntervenantController.java
//IFT2255 - Équipe 15
//Controlluer pour l'Intevenant

package com.ift2255.MaVille;

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
        this.currentIntervenant = intervenant;
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
       if workRequests.isEmpty(){
	      view.display("Aucune requête de travail disponible.");
       } else {
	      for(WorkRequest wr : workRequests){
		     view.display(wr.toString);
	      } 
    }
    }
    /**Cette méthode semble être un méthode de débougage...
     */
    public List<WorkRequest> getWorkRequestsTest() {
        return WorkRequestController.getAllRequests(); // Assurez-vous que cette méthode existe et retourne une liste
    }
    /** Passer un application pour travailler pour un certain workRequest
     * @param requestId Id de la demande
    public void applyToWorkRequest(int requestId) {
        // Fonction pour postuler à une requête de travail
    }   
}
