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

        Initialization.initialize(authController);

        //Page de bienvenue et login via AuthView
        AuthView authView = new AuthView(authController);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving data before exiting...");
            //Initialization.saveData(); // Save data of intervenants, work requests and projects (need to add for residents)
        }));
    }
}
