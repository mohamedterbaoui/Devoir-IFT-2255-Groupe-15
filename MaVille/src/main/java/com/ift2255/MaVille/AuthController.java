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

    public void signUpResident(Resident resident){
        residents.add(resident);
    }

    public void signUpIntervenant(Intervenant intervenant){
        intervenants.add(intervenant);
        //Je dois aussi ajouter la logique pour Gson pour stocker les données
    }

    public void logout(){

    }
    
}
