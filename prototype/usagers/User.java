//User.java
//IFT2255 - Équipe 15
//Objet qui stock les parametres d'un résident
package usagers;

public class User{
	private String prenom;
	private String nom;
	private String adresse;
        private String telephone;
	private String courriel;
	private String motDePasse;
	private String type; //Cela serait mieux comme Enum au lieu de String

	public User(String prenom, String nom, String adresse, String courriel, String motDePasse){
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.courriel = courriel;
		this.motDePasse = motDePasse;
	}

	public boolean verifierMotDePasse(String mot){
		return(mot.equals(this.motDePasse));
	} 

	//getters
	public String getPrenom(){
		return this.prenom;
	}

	public String getNom(){
		return this.nom;
	}

	public String getAdresse(){
		return this.adresse;
	}

	public String getTelephone(){
		return this.telephone;
	}

	public String getCourriel(){
		return this.courriel;
	}

	//cela n'est probablement pas une bonne idée
	public String getMotDePasse(){
		return this.motDePasse;
	}

	//setters
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

	public void setAdresse(String adresse){
		this.adresse= adresse;
	}

	public void setTelephone(String telephone){
		this.telephone = telephone;
	}

	public void setCourriel(String courriel){
		this.courriel = courriel;
	}

	public void setMotDePasse(String motDePasse){
		this.motDePasse = motDePasse;
	}
}

