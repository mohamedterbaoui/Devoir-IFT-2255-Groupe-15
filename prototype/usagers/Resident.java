//Resident.java
//IFT2255 - Équipe 15
//Objet qui stock les parametres d'un résident

class Resident {
	private String prenom;
	private String nom;
	private String adresse;
	private String courriel;
	private String motDePasse;

	public Resident(String prenom, String nom, String adresse, String courriel, String motDePasse){
		//Constructeur	
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

	public String getCourriel(){
		return this.courriel;
	}

	//cela n'est probablement pas une bonne idée
	public String getMotDePasse(){
		return this.motDePasse();
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

	public void setCourriel(String courriel){
		this.courriel = courriel;
	}

	public void setMotDePasse(String motDePasse){
		this.motDePasse = motDePasse);
	}

