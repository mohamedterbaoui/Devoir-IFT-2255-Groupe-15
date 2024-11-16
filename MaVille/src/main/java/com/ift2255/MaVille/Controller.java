//Controller.java
//IFT2255 - Équipe 15
//Classe abstrait pour le controlleur
package com.ift2255.MaVille;

abstract class Controller{
    protected View view;
    protected User user;
    protected String action;

    public abstract void operation();
    public abstract void initialize();
    public abstract void updateView();
    public abstract void handleInput();

    //getters
    public View getView(){
        return this.view;
    }

    public User getUser(){
        return this.user;
    }
}