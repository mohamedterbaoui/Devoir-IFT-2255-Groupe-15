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
    public void loginResident(String email, String password){
        for(Resident resident: residents)
            if (resident.getEmail().equals(email) && resident.getPassword().equals(password)) {
                ResidentController residentController = new ResidentController();
            }
    }

    public void loginIntervenant(String email, String password){
       for(Intervenant intervenant : intervenants){
           if (intervenant.getEmail().equals(email) && intervenant.getPassword().equals(password)){
               IntervenantController intCont = new IntervenantController();
           }
       }
    }

    public void signUp(User user){
        //fonction
    }

    public void logout(){
        //fonction
    }
    
}
