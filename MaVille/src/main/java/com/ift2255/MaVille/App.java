//App.java
//IFT2255 - Équipe 15
//Classe App
package com.ift2255.MaVille;

/**
 * Classe principale de l'application, qui lance l'exécution du programme.
 * Elle initialise le contrôleur d'authentification, configure la vue d'authentification,
 * et enregistre un hook pour sauvegarder les données avant la fermeture de l'application.
 */

public class App {
    /**
     * Point d'entrée principal de l'application. Cette méthode initialise le contrôleur
     * d'authentification, la vue d'authentification et configure un mécanisme de sauvegarde
     * des données avant la fermeture de l'application.
     *
     * @param args les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {

        // Création du contrôleur d'authentification
        AuthController authController = new AuthController();

        // Initialisation du contrôleur avec des configurations nécessaires
        Initialization.initialize(authController);

        //Page de bienvenue et login via AuthView
        AuthView authView = new AuthView(authController);

        // Enregistrement d'un hook de fermeture pour sauvegarder les données avant l'arrêt de l'application
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving data before exiting...");
            //Initialization.saveData(); // Save data of intervenants, work requests and projects (need to add for residents)
        }));
    }
}
