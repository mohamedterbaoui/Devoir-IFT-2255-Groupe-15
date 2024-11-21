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

        // Initialisation des données - nouvelle instance
        Initialization.initialize(authController);

        // Affiche les résidents initialisés (DEBUG)
        System.out.println("\nRésidents initialisés :");
        for (Resident resident : authController.residents) {
            System.out.println("Email : " + resident.getEmail() + ", Mot de passe : " + resident.getPassword());
        }

        // Affiche les intervenants initialisés (DEBUG)
        System.out.println("\nIntervenants initialisés :");
        for (Intervenant intervenant : authController.intervenants) {
            System.out.println("Email : " + intervenant.getEmail() + ", Mot de passe : " + intervenant.getPassword());
        }
        
        AuthView view = new AuthView(authController); // Initialiser avec authController pour les tests (ça doit être dans la même instance)

        // Affiche les requêtes de travail (DEBUG)
        IntervenantController intervenantController = authController.getIntervenantController();
        intervenantController.viewWorkRequests();        
        System.out.println();
    }
}
