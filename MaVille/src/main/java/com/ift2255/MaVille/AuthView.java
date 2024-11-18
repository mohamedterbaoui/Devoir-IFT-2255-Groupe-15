package com.ift2255.MaVille;

public class AuthView extends View{
    private String emailField;
    private String passwordField;
    private Boolean intervenant = false;

    
    public void displayWelcomePage(){
	    afficherLogo();
	    System.out.println("Bienvenue à l'Application MaVille");
	    System.out.println("Vous-êtes: ");
	    System.out.println("1. Résident\n2. Intervenant");
	    int choix = scn.nextInt();
	    switch (choix) {
		    case 1: this.displayLoginPage();
			    break;
	 	    case 2: this.intervenant = true;
			    this.displayLoginPage();
	    }

	    
    } 
    /**Montre à l'utilisatuer la page pour ce connecter
     * Cette methode va, par la suite communiquer avec
     * le controller pour trouver le compte utilisatuer
     */
    public void displayLoginPage(){
        
    }
    /**Montre à l'utilisateur la page pour s'inscrire.
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
    

