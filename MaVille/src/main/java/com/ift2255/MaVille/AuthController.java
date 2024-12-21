//AuthController.java
//IFT2255 - Équipe 15
//Classe pour le controlleur d'authentication
package com.ift2255.MaVille;

import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
/** Controlleur pour le processus d'authentication*/
public class AuthController extends Controller {

    LinkedList<Resident> residents = new LinkedList<>();
    private static LinkedList<Intervenant> intervenants = new LinkedList<>();

    private SimpleDateFormat dateFormatter= new SimpleDateFormat("yyyy-MM-dd");
    
    private ResidentController residentController;
    private IntervenantController intervenantController;

    private boolean isResidentConnected = false;  // Variable pour suivre l'état de la connexion résident
    private boolean isIntervenantConnected = false;  // Variable pour suivre l'état de la connexion intervenant

    public AuthController() {}
    /**Méthode pour qu'un résident puisse se connecter. Cela accepte le courriel et le mot de passe de l'utilisateur
     * et retourne un objet Resident
     * @param email    String avec l'adresse courriel
     * @param password String qui contient le mot de passe
     * @return         Boolean qui indique le réussite ou échec de la connexion
     */
    public boolean loginResident(String email, String password) {
        for (Resident resident : residents) {
            if (resident.getEmail().equals(email) && resident.getPassword().equals(password)) {
                residentController = new ResidentController(resident); // Passer l'utilisateur dans le contrôleur
                isResidentConnected = true; //On n'utilise pas cet variable dans le code
                return true;
            }
        }
        return false;
    }
    /**Méthode qui gère la connexion pour un intérvenant. On accepte l'adresse courriel et le mot passe
     * et on retourne un boolean pour le vue si la connexion est réussi ou non. 
     * @param email    Adresse courriel 
     * @param password Mot de passe
     * @return         Boolean qui indique le réussite ou échec de la connexion
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
     * @param resident un objet resident
     */
    public void signUpResident(Resident resident){
        residents.add(resident);
	//On va utiliser quelque chose comme ça pour la date
	//birthDate = dateFormatter.parse(birthDateString);
        //Il serait probablement mieux d'accepter un tableau d'entrées puis créer l'utilisateur ici
        //au lieu de le faire dans la vue
    }

    public void signUpResident(String[] donnees){
	    
	    try{
	        String firstName = donnees[0];
	    	String lastName  = donnees[1];
	    	String SbirthDate= donnees[2];
	    	String email     = donnees[3];
	    	String motDePasse= donnees[4];
	   	String phone     = donnees[5];
	    	String address   = donnees[6];
		String postalCode= donnees[7];
	    	String city      = donnees[8];

	    	Date birthDate = dateFormatter.parse(SbirthDate);


	    Resident newResident = new Resident(firstName, lastName, birthDate, email, motDePasse, phone, address, postalCode, city);
	    residents.add(newResident);
	    } catch (ParseException e){
		    System.err.println("La date de naissaiance n'était pas bien formattée");
	    }

    } 
    /**Méthode pour qu'un intérvenant puisse s'inscrire
     * @param intervenant l'intérvenant qui est ajouté à la liste
    */
    public void signUpIntervenant(Intervenant intervenant){
        intervenants.add(intervenant);
        //Je dois aussi ajouter la logique pour Gson pour stocker les données
    }

    public void signUpIntervenant(String[] donnees){
	try{
	    String firstName = donnees[0];
	    String lastName  = donnees[1];
	    String SbirthDate= donnees[2];
	    String email     = donnees[3];
	    String motDePasse= donnees[4];
	    String phone     = donnees[5];
	    String address   = donnees[6];
	    String type      = donnees[7];
	    String matriculeS= donnees[8];

	    Date birthDate = dateFormatter.parse(SbirthDate);
	    int matricule = Integer.parseInt(matriculeS);

	    Intervenant newIntervenant = new Intervenant(firstName, lastName, birthDate, email, motDePasse, phone, address, type, matricule);
	    intervenants.add(newIntervenant);
	    
	} catch (ParseException e) {
		System.err.println("La date de naissance n'était pas bien formatté");
	}
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
     * @return boolean pour indiquer qu'un résident est connecté
     */
    public boolean isIntervenantConnected() {
        return isIntervenantConnected;
    }

    public static LinkedList<Intervenant> getAllIntervenants() {
        return intervenants; 
    }

    public LinkedList<Intervenant> getIntervenants() {
        return intervenants;
    }
}