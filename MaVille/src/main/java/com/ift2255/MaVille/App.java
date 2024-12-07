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

        // Page de bienvenue et login via AuthView
        AuthView authView = new AuthView(authController); 

    }
}
