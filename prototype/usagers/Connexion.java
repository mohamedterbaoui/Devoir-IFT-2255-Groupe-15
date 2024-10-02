//Connexion.java
//IFT2255 - Équipe 15
//Interface pour se connecter à l'application et s'inscrire à l'application
package usagers;


public class Connexion{
	Usagers u;
	//Retourner l'utilisateur s'il est trouvé, sinon on retourne null
	public Connexion(){
		Usagers u = new Usagers();
	}
	
	public Resident Authentication(String courriel, String motDePasse){
	
	Resident usager = u.chercherResident(courriel);
	if(usager.verifierMotDePasse(motDePasse)){
		return usager;
	} else {
		return null;
	}
	}
	
	//Il serait bon de surcharger ce fonction pour avoir aussi un no de 
	//téléphone mais pour le moment, ça va.
	public void sInscrire(String prenom, String nom, String adresse, 
			String courriel, String motDePasse){
		u.ajouterResident(prenom,nom,adresse,courriel,motDePasse);
	}

}


		
	
		
