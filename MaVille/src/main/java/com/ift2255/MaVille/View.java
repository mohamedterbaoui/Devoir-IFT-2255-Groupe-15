//View.java
//IFT2255 - Équipe 15
//Classe abstrait pour le vue

package com.ift2255.MaVille;

public abstract class View {
    Controller controller;
    User user;
    Menu menu;
    String title;

    public void display(){}

    public String getUserInput(){}

    public void updateView(){}

    public void displayError(String error) {}

    public Controller getController() {
        return controller;
    }
    public Menu getMenu() {
        return menu;
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

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
