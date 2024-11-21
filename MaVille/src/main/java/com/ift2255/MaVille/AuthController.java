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
    LinkedList<Resident> residents = new LinkedList<>();
    LinkedList<Intervenant> intervenants = new LinkedList<>();

    private ResidentController residentController;
    private IntervenantController intervenantController;

    private boolean isResidentConnected = false;  // Variable pour suivre l'état de la connexion résident
    private boolean isIntervenantConnected = false;  // Variable pour suivre l'état de la connexion intervenant

    public AuthController() {}

    public boolean loginResident(String email, String password) {
        for (Resident resident : residents) {
            if (resident.getEmail().equals(email) && resident.getPassword().equals(password)) {
                residentController = new ResidentController(resident); // Passer l'utilisateur dans le contrôleur
                isResidentConnected = true;
                return true;
            }
        }
        return false;
    }

    public boolean loginIntervenant(String email, String password) {
        for (Intervenant intervenant : intervenants) {
            if (intervenant.getEmail().equals(email) && intervenant.getPassword().equals(password)) {
                intervenantController = new IntervenantController(intervenant); // Passer l'utilisateur dans le contrôleur
                isIntervenantConnected = true;
                return true;
            }
        }
        return false;
    }

    public void signUpResident(Resident resident){
        residents.add(resident);
    }

    public void signUpIntervenant(Intervenant intervenant){
        intervenants.add(intervenant);
        //Je dois aussi ajouter la logique pour Gson pour stocker les données
    }

    public void logout(){

    }
    
    // Pour pouvoir faire référence au résident connecté
    public ResidentController getResidentController() {
        return residentController;
    }

    // Pour pouvoir faire référence à l'intervenant connecté
    public IntervenantController getIntervenantController() {
        return intervenantController;
    }

    // Méthodes pour vérifier si un résident ou un intervenant est connecté
    public boolean isResidentConnected() {
        return isResidentConnected;
    }

    public boolean isIntervenantConnected() {
        return isIntervenantConnected;
    }
}
