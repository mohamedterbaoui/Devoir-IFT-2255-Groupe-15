//AuthController.java
//IFT2255 - Équipe 15
//Classe pour le controlleur d'authentication
package com.ift2255.MaVille;

import java.util.LinkedList;
/** Controlleur pour le processus d'authentication*/
public class AuthController extends Controller {

    LinkedList<Resident> residents = new LinkedList<>();
    LinkedList<Intervenant> intervenants = new LinkedList<>();

    private ResidentController residentController;
    private IntervenantController intervenantController;

    private boolean isResidentConnected = false;  // Variable pour suivre l'état de la connexion résident
    private boolean isIntervenantConnected = false;  // Variable pour suivre l'état de la connexion intervenant

    public AuthController() {}
    /**Méthode pour qu'un résident puisse se connecter. Cela accepte le courriel et le mot de passe de l'utilisateur
     * et retourne un objet Resident
     * @param email : String avec l'adresse courriel
     * @param password: String qui contient le mot de passe
     * @return boolean pour dire au vue que la connexion a réussi
     */
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
    /**Méthode qui gère la connexion pour un intérvenant. On accepte l'adresse courriel et le mot passe
     * et on retourne un boolean pour le vue si la connexion est réussi ou non. 
     * @param email : String avec l'adresse courriel
     * @param password: String qui contient le mot de passe
     * @return Boolean qui indique que la connexion a réussi
     */
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
    /**Méthode pour ajouter un nouveau résident.
     * Cela ajoute le résident dans la liste des résidents
     * @param resident: un objet resident
     */
    public void signUpResident(Resident resident){
        residents.add(resident);
        //Il serait probablement mieux d'accepter un tableau d'entrées puis créer l'utilisateur ici
        //au lieu de le faire dans la vue
    }
    /**Méthode pour qu'un intérvenant puisse s'inscrire
     * @param intervenant: l'intérvenant qui est ajouté à la liste
    */
    public void signUpIntervenant(Intervenant intervenant){
        intervenants.add(intervenant);
        //Je dois aussi ajouter la logique pour Gson pour stocker les données
    }

    public void logout(){

    }
    
    // Pour pouvoir faire référence au résident connecté
    /**
     * Getter qui retourne le controlleur pour le résident
     * @return Le résident controlleur associé à cette classe
     */
    public ResidentController getResidentController() {
        return residentController;
    }

    // Pour pouvoir faire référence à l'intervenant connecté
    /**
     * Getter qui retourne le controlleur pour l'intérvenant
     * @return intervenantController 
     */
    public IntervenantController getIntervenantController() {
        return intervenantController;
    }

    // Méthodes pour vérifier si un résident ou un intervenant est connecté
    /**
     * Getter qui retourne un boolean si le résident est connecté
     * @return boolean indiquant qu'un résident est connecté
     */
    public boolean isResidentConnected() {
        return isResidentConnected;
    }
    /**
     * Méthode pour demander si l'utilisateur connecté est un intervenant
     * @return boolean pour indiquer que l'utilisateur qui est connecté est un intervenant
     */
    public boolean isIntervenantConnected() {
        return isIntervenantConnected;
    }
}
