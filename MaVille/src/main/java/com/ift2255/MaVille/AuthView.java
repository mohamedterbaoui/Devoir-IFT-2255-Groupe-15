//AuthView.java
//IFT2255 - Équipe 15
//Classe AuthView
package com.ift2255.MaVille;

public class AuthView extends View{
    private String emailField;
    private String passwordField;

    private AuthController authController;

    public AuthView(AuthController controller){
        this.authController = controller;
        this.displayWelcomePage();
    }
    public AuthView(){
        this.authController = new AuthController();
        this.displayWelcomePage();
    }
    public void displayWelcomePage(){
        afficherLogo();
        System.out.println("Bienvenue à l'Application MaVille");
        System.out.println("Vous-êtes: ");
        System.out.println("1. Résident\n2. Intervenant\n3. Quitter");
        int choix = -1;
        boolean validChoice = false;
    
        while (!validChoice) {
            try {
                choix = Integer.parseInt(scn.nextLine());
                if (choix < 1 || choix > 3) {
                    System.out.println("Veuillez choisir une option valide\n1. Résident\n2. Intervenant\n3. Quitter");
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
            case 3: 
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                System.exit(0); // Quitte le programme
                break;
        }
    }

    /**Fonction qui gère le logique pour qu'un résident puisse se connecter
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
    
    private void displayLoginPageIntervenant() {
        String[] loginDetails;
        boolean success = false;
        while (!success) {
            loginDetails = this.displayLoginPage();
            success = authController.loginIntervenant(loginDetails[0], loginDetails[1]);
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
	System.out.println("Adresse courriel : ");
    input[0] = scn.nextLine().trim(); // Suppression des espaces
	System.out.println("Mot de Passe");
    input[1] = scn.nextLine().trim(); // Suppression des espaces
	return input;
    }

    /*Montre à l'utilisateur la page pour s'inscrire.
     * Cette methode va, par la suite, communiquer avec
     * le controlleur pour créer un compte utilisateur
     */
    public void displayRegistrationPage(){
        
        //fonction
    }

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


    

