//App.java
//IFT2255 - Équipe 15
//Classe App
package com.ift2255.MaVille;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        AuthController authController = new AuthController();

        // Initialisation des données
        Initialization.initialize(authController);

        // Page de bienvenue et login via AuthView
        AuthView authView = new AuthView(authController); 
   
        // Pour le résident 
        if (authController.isResidentConnected()) { 
            ResidentController residentController = authController.getResidentController();
            ResidentView residentView = new ResidentView(residentController);
            residentView.displayOptions();

        // Pour l'intervenant
        } else {
            IntervenantController intervenantController = authController.getIntervenantController();
            IntervenantView intervenantView = new IntervenantView(intervenantController);
            intervenantView.displayOptions();
        }
    }
}
