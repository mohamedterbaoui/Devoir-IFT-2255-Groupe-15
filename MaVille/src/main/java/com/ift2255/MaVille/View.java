//View.java
//IFT2255 - Équipe 15
//Classe abstrait pour le vue

package com.ift2255.MaVille;

import java.util.Scanner;

public abstract class View {
    protected Controller controller;
    protected User user;
    protected String title;
    protected Scanner scn = new Scanner(System.in);

    public void display(){}

    /**Classe pour encapsuler la logique de Scanner.nextLine()
     * @return l'Input d'utilisateur
     */
    public String getUserInput(){
    	return scn.nextLine();
    }

    public void updateView(){}

    public void displayError(String error) {}

    public Controller getController() {
        return controller;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
