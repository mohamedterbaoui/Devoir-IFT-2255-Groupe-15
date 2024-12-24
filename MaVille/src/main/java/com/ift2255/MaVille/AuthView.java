//AuthView.java
//IFT2255 - Équipe 15
//Classe AuthView
package com.ift2255.MaVille;
/** Gère la vue pour l'authentication et l'inscription d'un utilisateur
 */
public class AuthView extends View{
    private String emailField;
    private String passwordField;

    private AuthController authController;
    /**Constructeur pour la classe AuthView
     * @param controller Un auth controller
     */
    public AuthView(AuthController controller){
        this.authController = controller;
        this.displayWelcomePage();
    }
    /**Constructeur pour la classe AuthController
     */
    public AuthView(){
        this.authController = new AuthController();
        this.displayWelcomePage();
    }
    /**Montre à l'utilisateur la page d'accueil
     */
    public void displayWelcomePage(){
        afficherLogo();
        System.out.println("Bienvenue à l'Application MaVille");
	    this.mainMenu();
    }

    /**
     * Affiche le menu principal de l'application et permet à l'utilisateur de choisir une option.
     * Le menu offre quatre choix : se connecter en tant que résident, se connecter en tant qu'intervenant,
     * s'inscrire, ou quitter l'application. L'utilisateur doit entrer une option valide pour continuer.
     *
     * Si l'utilisateur entre une valeur non valide, un message d'erreur est affiché et il lui est demandé de
     * refaire son choix jusqu'à ce qu'une option valide soit sélectionnée.
     */
    public void mainMenu(){
        System.out.println("Vous-êtes: ");
        System.out.println("1. Résident\n2. Intervenant\n3. S'inscrire\n4. Quitter");
        int choix = -1;
        boolean validChoice = false;
    
        while (!validChoice) {
            try {
                choix = Integer.parseInt(scn.nextLine());
                if (choix < 1 || choix > 4) {
                    System.out.println("Veuillez choisir une option valide\n1. Résident\n2. Intervenant\n3. S'inscrire\n4. Quitter");
                } else {
                    validChoice = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez choisir une option valide\n1. Résident\n2. Intervenant\n3. Quitter");
            }
        }
    
        switch (choix) {
            case 1: this.displayLoginPageResident();
                break;
            case 2: this.displayLoginPageIntervenant();
                break;
	    case 3: this.displayRegistrationPage();
		break;
            case 4:
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                System.exit(0); // Quitte le programme
                break;
        }
    }

    /**Gère le logique pour qu'un résident puisse se connecter
     */
    private void displayLoginPageResident() {
        String[] loginDetails;
        boolean success = false;
        while (!success) {
            loginDetails = this.displayLoginPage();
            success = authController.loginResident(loginDetails[0], loginDetails[1]);
            if (!success) {
                System.out.println("Identifiants incorrects. Veuillez réessayer.");
            }
        }
    }
   /**Gère les entrées pour qu'un intérvenant puisse se connecter
    */ 
    private void displayLoginPageIntervenant() {
        String[] loginDetails;
        boolean success = false;
        while (!success) {
            loginDetails = this.displayLoginPage();
            success = authController.loginIntervenant(loginDetails[0],loginDetails[1]);
            if (!success) {
                System.out.println("Identifiants incorrects. Veuillez réessayer.");
            }
        }
    }

    /**Montre à l'utilisatuer la page pour ce connecter.
     * Il va le renvoyer vers le methode parent qui va le
     * dériger vers le bon controlleur
     * @return [courriel, motDePasse];
     */
    public String[] displayLoginPage(){
	String input[] = new String[2];
	System.out.println("Adresse courriel (Si vous souhaitez revenir au menu principal, écrivez annuler) : ");
    input[0] = scn.nextLine().trim(); // Suppression des espaces
    if(input[0].equals("annuler")){
	    this.displayWelcomePage();
    }
	System.out.println("Mot de Passe (Si vous souhaitez revenir au menu principal, écrivez annuler) : ");
    input[1] = scn.nextLine().trim();
    if(input[1].equals("annuler")){
	   this.displayWelcomePage();
    }
    try{
	    input[1] = Hash.hasher(input[1]); 
    } catch (Exception e){
	    e.printStackTrace();
    }
	return input;
    }

    /**Montre à l'utilisateur la page pour s'inscrire.
     * Cette methode va, par la suite, communiquer avec
     * le controlleur pour créer un compte utilisateur
     */
    public void displayRegistrationPage(){
    	System.out.println("S'inscrire comme : ");
	System.out.println("1. Resident\n2. Intervenant\n3. Menu principal");
	try {
		int choix = Integer.parseInt(scn.nextLine());
		switch (choix) {
			case 1 : displayRegistrationPageResident();
				 break;
			case 2 : displayRegistrationPageIntervenant();
				 break;
			case 3 : this.mainMenu();
				 break;
			default : System.out.println("Veuillez séléctionner une option valide"); 
				break;
		}
    } catch (Exception e){
	    System.out.println("Veuillez séléctionner une option valide");
    }
    }
    /**
     * Affiche la page d'enregistrement générique et recueille les informations nécessaires pour l'inscription d'un utilisateur.
     * Cette méthode demande à l'utilisateur de saisir son prénom, nom, date de naissance, email, mot de passe, numéro de téléphone (optionnel) et adresse.
     * Les informations sont validées et récupérées à l'aide de méthodes spécifiques telles que `verifierNonVide` et `verifierMotDePasse`.
     *
     * @return un tableau de chaînes de caractères contenant les informations saisies par l'utilisateur :
     *         [0] : prénom, [1] : nom, [2] : date de naissance, [3] : email, [4] : mot de passe, [5] : téléphone (optionnel), [6] : adresse.
     */

    public String[] displayRegistrationPageGeneric(){
	    System.out.println("Veuillez saisir les informations suivents");
	    String firstName = this.verifierNonVide("Prénom :");
	    String lastName = this.verifierNonVide("Nom de famille : ");
	    String birthday = this.verifierNonVide("Date de naissaiance (yyyy-MM-dd):");
	    String email = this.verifierNonVide("Adresse courriel :");
	    String motDePasse = this.verifierMotDePasse();
	    //Le numéro de téléphone est optionnel: c'est traité ailleurs
	    System.out.println("Numéro de téléphone : ");
	    String phone = scn.nextLine();
	    //fin de numéro de téléphone
	    String address = this.verifierNonVide("Adresse ");
	    String[] responses = {firstName, lastName,birthday,email,motDePasse,phone,address};
	    return responses;
    }
    /**
     * Affiche la page d'enregistrement pour un résident et recueille les informations nécessaires à son inscription.
     * Cette méthode appelle `displayRegistrationPageGeneric` pour récupérer les informations de base (prénom, nom, etc.),
     * puis demande des informations supplémentaires spécifiques au résident, telles que le code postal et la ville.
     * Enfin, elle enregistre le résident en appelant la méthode `signUpResident` du contrôleur d'authentification
     * et affiche le menu principal après l'inscription.
     *
     * @see #displayRegistrationPageGeneric()
     */

    public void displayRegistrationPageResident(){
	    String[] responses = displayRegistrationPageGeneric();
	    String codePostal = this.verifierNonVide("Code Postal : ");
	    String city = this.verifierNonVide("Ville : ");
	    String[] residentResponses = {responses[0],responses[1],responses[2],
		    responses[3],responses[4],responses[5],responses[6], codePostal, city};

	    authController.signUpResident(residentResponses);
	    this.mainMenu();
    }
    /**
     * Affiche la page d'enregistrement pour un intervenant et recueille les informations nécessaires à son inscription.
     * Cette méthode appelle `displayRegistrationPageGeneric` pour récupérer les informations de base (prénom, nom, etc.),
     * puis demande des informations supplémentaires spécifiques à l'intervenant, telles que le type d'intervenant et le matricule de la ville.
     * Enfin, elle enregistre l'intervenant en appelant la méthode `signUpIntervenant` du contrôleur d'authentification
     * et affiche le menu principal après l'inscription.
     *
     * @see #displayRegistrationPageGeneric()
     */

    public void displayRegistrationPageIntervenant(){
	    String[] responses = displayRegistrationPageGeneric();
	    String type = verifierNonVide("Type d'intérvenant : ");
	    String idVille = verifierNonVide("Matricule de la ville :");

	    String[] intervenantResponses = {responses[0],responses[1],responses[2],
		    responses[3],responses[4],responses[5],responses[6], type, idVille};

	    authController.signUpIntervenant(intervenantResponses);
	    this.mainMenu();
    }
    /**
     * Vérifie la validité du mot de passe en demandant à l'utilisateur de saisir et confirmer son mot de passe.
     * Si les deux mots de passe saisis correspondent, le mot de passe est haché à l'aide de la méthode `Hash.hasher` et retourné.
     * Si les mots de passe ne correspondent pas, la méthode redemande la saisie du mot de passe jusqu'à ce qu'une correspondance soit trouvée.
     *
     * @return le mot de passe haché si la confirmation est correcte, sinon une nouvelle demande de mot de passe est effectuée.
     */

    private String verifierMotDePasse(){
	    System.out.println("Mot de passe : ");
	    String motDePasse = scn.nextLine().trim();
	    System.out.println("Confirmez votre mot de passe : ");
	    String motDePasse2 = scn.nextLine().trim();

	    if (motDePasse.equals(motDePasse2)){
		    try {
			    return Hash.hasher(motDePasse);
		    } catch (Exception e) {
			    e.printStackTrace();
			    return "";
		    }
	    } else {
		    return verifierMotDePasse();
	    }
    }
    /**
     * Demande à l'utilisateur de saisir une réponse et vérifie qu'elle n'est pas vide.
     * Si la réponse est vide, un message d'erreur est affiché et l'utilisateur est invité à entrer une réponse valide.
     * La méthode continue à demander une réponse jusqu'à ce qu'une entrée non vide soit fournie.
     *
     * @param prompt le message à afficher avant que l'utilisateur saisisse sa réponse.
     * @return la réponse saisie par l'utilisateur, garantie non vide.
     */

    private String verifierNonVide(String prompt){
	    System.out.println(prompt);
	    String response = scn.nextLine();
	    if (response.isEmpty()){
		    System.out.println("La réponse ne peut pas être vide");
		    return verifierNonVide(prompt);
	    } else {
		    return response;
	    }
    }


  //  String phone, String userAddress, String city){
    /**
     * Affichage de logo de MaVille pour l'ouverture de l'application
     */
    public void afficherLogo(){
        String[] hashtag = {
            "  #   #   ",
            " #######  ",
            "  #   #   ",
            " #######  ",
            "  #   #   "
        };

        String[] M = {
            "|\\       /|",
            "| \\     / |",
            "|  \\   /  |",
            "|   \\ /   |",
            "|    V    |"
        };

        String[] A = {
            "    /\\    ",
            "   /  \\   ",
            "  /----\\  ",
            " /      \\ ",
            "/        \\"
        };

        String[] V = {
            "\\        /",
            " \\      / ",
            "  \\    /  ",
            "   \\  /   ",
            "    \\/    "
        };

        String[] I = {
            "  -----   ",
            "    |     ",
            "    |     ",
            "    |     ",
            "  -----   "
        };

        String[] L = {
            "|         ",
            "|         ",
            "|         ",
            "|         ",
            "|_______  "
        };

        String[] E = {
            " _______  ",
            "|         ",
            "|______   ",
            "|         ",
            "|_______  "
        };

        System.out.println("---------------------------------------------------------------------------------------");
        // combiner toutes les lettres
        for (int i = 0; i < M.length; i++) {
            System.out.println(hashtag[i] + "  " + M[i] + "  " + A[i] + "  " + V[i] + "  " + I[i]
                    + "  " + L[i] + "  " + L[i] + "  " + E[i]);
        }
    }
}


    
