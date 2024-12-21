//View.java
//IFT2255 - Équipe 15
//Classe abstrait pour le vue

package com.ift2255.MaVille;

import java.util.Scanner;
/**
 * Classe abstrait pour les vues
 * pour montrer les les informations à l'utilisateur
 */
public abstract class View {
    protected Controller controller;
    protected User user;
    protected String title;
    protected Scanner scn = new Scanner(System.in);
    
    /**
     * Montre les informations à l'utilisateur de la part du controlleur
     * @param input la message à montrer à l'utilisateur
     */ 
    public void display(String input){
        System.out.println(input);
    }

    /**Classe pour encapsuler la logique de Scanner.nextLine()
     * @return l'Input d'utilisateur
     */
    public String getUserInput(){
    	return scn.nextLine();
    }
    /**
     * Methode qui met a jour le view
     */
    public void updateView(){}
    
    /**Methode qui imprime dans <code> System.err</code>
     * @param Error message d'erreur
     */
    public void displayError(String error) {
        System.err.println(error);
    }
    /**
     * return le controlleur associé à la vue actuel
     * @return le controlleur actuel
     */
    public Controller getController() {
        return controller;
    }
    /** Retourne le titre de la vue actuel
     * @return Un String qui est le nom de la vue
     */
    public String getTitle() {
        return title;
    }
    /**Retourne l'utilisateur actuel
     * @return l'Utilisateur
     */
    public User getUser() {
        return user;
    }
    
    /**Mise en place d'un nouveau controlleur qui une autre partie du logiciel
     * @param controlleur Le nouveau controlleur
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }
    /**
     * Changer le titre de la vue
     * @param title Le nouveau titre e la vue
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Définir l'utilisateur connecté
     * @param utilisateur L'utilisateur qui vient de se connecter
     */
    public void setUser(User user) {
        this.user = user;
    }


}
