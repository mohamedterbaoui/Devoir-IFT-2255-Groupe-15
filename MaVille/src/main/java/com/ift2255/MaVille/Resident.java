//Resident.java
//IFT2255 - Équipe 15
//La classe pour les résidents
package com.ift2255.MaVille;

import java.util.LinkedList;
import java.util.Date;
/**Classe qui gère les attributes et méthodes pour un résident
 */
public class Resident extends User{
    private String city;
    private LinkedList<String> preferredProjectTimes;
    private LinkedList<Project> subscriptions;
    private LinkedList<WorkRequest> workRequests;
    private Notifications notifications;
/**Constructeur de la classe resident
 * @param firstName prénom du résident
 * @param lastName nom du résident
 * @param birthDate date de naissaiance du résident
 * @param email Adresse courriel du résident
 * @param password SHA-256 hash du mot de passe
 * @param phone Numéro de téléphone pour le résident
 * @param userAddress adresse du résident
 * @param city Ville où habite le résident
 */
    public Resident(String firstName, String lastName,Date birthDate, String email, String password, String phone, String userAddress, String city){
        super(firstName, lastName, birthDate, email, password, phone, userAddress);
        this.city = city;
        this.workRequests = new LinkedList<>(); // Initialisation de la liste
	this.notifications = new Notifications();
    }
/**ajouter un subscripton à un projet
 * @param projet le projet auquel le resident veut s'abonner
 */
    public void subscribeToProject(Project project){
        subscriptions.add(project);
    }

    public void unsubscribeFromProject(Project project){
        // fonction
    }
/**Demander des travaux d'un intérvenant
 * @param residentController le controlleur de Resident ???????
 * @param title Le titre de la demande
 * @param workType le type de travail
 * @param expectedStartDate la date prévue de debut
 * @param workRequestAddress l'adresse où le travail est démandé
 */
    public void addWorkRequest(ResidentController residentController, String title, String description, String workType, Date expectedStartDate, Street workRequestAddress) {
        residentController.addWorkRequest(title, description, workType, expectedStartDate, workRequestAddress);
    }

    public Project searchProject(){
      return null;
    }

    //getters
    /**Retourne la ville du résident
     * @return la ville
     */
    public String getCity() {
        return city;
    }
/**
 * Afficher les heures préféree pour des projets
 * @return les préférences du résident
 */
    public LinkedList<String> getPreferredProjectTimes(){
        return preferredProjectTimes;
    }
/** Afficher les abaonnements pour le résident
 *@return les projets abanonné par le résident
 */
    public LinkedList<Project> getSubscriptions() {
        return subscriptions;
    }
/** Afficher les requêtes de travail pour ce résident
 * @return une liste chaînée avec les requêtes de travail
 */
    public LinkedList<WorkRequest> getWorkRequests() {
        return workRequests;
    }

    //setters
    /**changer la ville d'un résident
     * @param city la nouvelle ville du résident
     */
    public void setCity(String city) {
        this.city = city;
    }
/**changer les préférences pour les heures des taravaux
 * @param preferredProjectTimes les nouveux heures préférees
 */
    public void setPreferredProjectTimes(LinkedList<String> preferredProjectTimes) {
        this.preferredProjectTimes = preferredProjectTimes;
    }
/**Changer les abaonnements du résident
 * @param subscriptions les abaonnements pour ce résident
 */
    public void setSubscriptions(LinkedList<Project> subscriptions) {
        this.subscriptions = subscriptions;
    }
  /**Changer la liste des requêtes de travail avec une nouvelle liste
   * @param workRequests les nouveaux requêtes de travail
   */  
    public void setWorkRequests(LinkedList<WorkRequest> workRequests) {
        this.workRequests = workRequests;
    }
    /**Ajoute un notification pour cette résident
     * @param notification La nouvelle notification
     */ 
    public void addNotification(Notification notification){
	    this.notifications.addNotification(notification);
    }
    public void getNotifications(){
    	//On devrait pouvoir faire view.display()... mais pour le moment, on peut pas
	System.out.println(this.notifications);
    }

    public void getNewNotifications(){
	    System.out.println(this.notifications.getNewNotificatsion());
    }

    public void editPreferences(){}
    
}
