//Controller.java
//IFT2255 - Équipe 15
//Classe abstrait pour le controlleur
package com.ift2255.MaVille;
/**
 * Classe abstrait pour les controlleurs
 */
abstract class Controller{
    /**Le view actuel
     */
    protected View view;
    /**L'utilisateur qui est actuellement connecté */
    protected User user;
    /**L'action fait par le controlleur */
    protected String action;
    /**Méthode qui font l'opération du controlleur */
    public void operation(){};
    public void initialize(){};
    /**Mettre à jour le vue */
    public void updateView(){};
    /**Recoive les requêtes de la vue */
    public void handleInput(){};

    //getters
    /**Retourne le vue actuel 
     * @return Le vue 
    */
    public View getView(){
        return this.view;
    }
    /** Retourne l'utilisateur actuel
     * @return L'utilisateur
    public User getUser(){
        return this.user;
    }
}
