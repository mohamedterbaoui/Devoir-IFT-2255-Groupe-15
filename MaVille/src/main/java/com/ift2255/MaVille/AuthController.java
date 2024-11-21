//AuthController.java
//IFT2255 - Équipe 15
//Classe pour le controlleur d'authentication
package com.ift2255.MaVille;

import java.util.LinkedList;

public class AuthController extends Controller {
    /**Fonction pour effectuer la connexion au logiciel
     * @param email : String avec l'adresse courriel
     * @param password: String qui contient le mot de passe
     */
    LinkedList<Resident> residents = new LinkedList<Resident>();
    LinkedList<Intervenant> intervenants = new LinkedList<Intervenant>();

    private ResidentController residentController; // Contrôleur pour les résidents
    private IntervenantController intervenantController; // Contrôleur pour les intervenants
    public static LinkedList<WorkRequest> workRequests = new LinkedList<WorkRequest>(); // Liste globale des requêtes de travail
    
    public void loginResident(String email, String password) {
        for (Resident resident : residents) {
            if (resident.getEmail().equals(email) && resident.getPassword().equals(password)) {
                residentController = new ResidentController(resident); // Passe le résident connecté
                System.out.println("Connexion réussie en tant que résident : " + email);
                return;
            }
        }
        System.out.println("Échec de la connexion : email ou mot de passe invalide.");
    }

    public void loginIntervenant(String email, String password) {
        for (Intervenant intervenant : intervenants) {
            if (intervenant.getEmail().equals(email) && intervenant.getPassword().equals(password)) {
                intervenantController = new IntervenantController(intervenant); // Passe l'intervenant connecté
                System.out.println("Connexion réussie en tant qu'intervenant : " + email);
                return;
            }
        }
        System.out.println("Échec de la connexion : email ou mot de passe invalide.");
    }

    public void signUp(User user){
        //fonction
    }

    public void logout(){
        //fonction
    }
    
    // Pour pouvoir faire référence au résident connecté
    public ResidentController getResidentController() {
        return residentController;
    }

    // Pour pouvoir faire référence à l'intervenant connecté
    public IntervenantController getIntervenantController() {
        return intervenantController;
    }

}
