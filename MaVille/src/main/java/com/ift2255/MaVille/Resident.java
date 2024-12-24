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
    private LinkedList<Preference> preferences;
    private LinkedList<Project> subscriptions;
    private LinkedList<WorkRequest> workRequests;
    private Notifications notifications;
    private String postalCode;
    private Quartiers quartier;
/**Constructeur de la classe resident
 * @param firstName prénom du résident
 * @param lastName nom du résident
 * @param birthDate date de naissaiance du résident
 * @param email Adresse courriel du résident
 * @param password SHA-256 hash du mot de passe
 * @param phone Numéro de téléphone pour le résident
 * @param userAddress adresse du résident
 * @param postalCode code postal du résident
 * @param city Ville où habite le résident
 */
    public Resident(String firstName, String lastName,Date birthDate, String email, String password, String phone, String userAddress, String postalCode, String city){
        super(firstName, lastName, birthDate, email, password, phone, userAddress);
	this.postalCode = postalCode;
        this.city = city;
        this.workRequests = new LinkedList<>(); // Initialisation de la liste
	this.notifications = new Notifications();
	this.quartier = PostalCodes.valueOf(this.postalCode.split(" ")[0].toUpperCase()).getQuartier();
    }
    /**Ajouter un subscripton à un projet
     * @param project le projet auquel le resident veut s'abonner
     */
    public void subscribeToProject(Project project){
        subscriptions.add(project);
    }
    /**
     * Permet à un résident de se désinscrire d'un projet.
     * Cette méthode retire le résident de la liste des résidents affectés par le projet et peut inclure d'autres logiques
     * spécifiques à la désinscription, comme l'envoi d'une notification de désinscription ou la mise à jour de l'état du projet.
     *
     * @param project le projet duquel le résident souhaite se désinscrire.
     */

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

    /**
     * Fonction pour associer une requete de travail a un resident
     * @return
     */
    public void linkWorkRequest(WorkRequest workRequest){
        this.workRequests.add(workRequest);
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

    public Quartiers getQuartier(){
	    return this.quartier;
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
	    System.out.println(this.notifications.getNewNotifications());
    }

    /**
     * Permet de modifier les préférences associées à un utilisateur ou à un objet.
     * Cette méthode est un point d'entrée pour les modifications des préférences,
     * mais elle ne contient pas encore de logique spécifique.
     */
    public void editPreferences() { }

    /**
     * Ajoute une préférence à la liste des préférences existantes.
     * Si la liste des préférences est nulle, elle est initialisée.
     *
     * @param preference La préférence à ajouter à la liste.
     */
    public void addPreference(Preference preference) {
        if (this.preferences == null) {
            preferences = new LinkedList<Preference>();
        }
        preferences.add(preference);
    }

    /**
     * Supprime une préférence de la liste en fonction de son index.
     *
     * @param index L'index de la préférence à supprimer dans la liste.
     * @throws IndexOutOfBoundsException si l'index est invalide (en dehors des limites de la liste).
     */
    public void removePreference(int index) {
        this.preferences.remove(index);
    }

    /**
     * Retourne la liste des préférences associées à un utilisateur ou un objet.
     *
     * @return Une liste de préférences (LinkedList<Preference>), ou null si aucune préférence n'est définie.
     */
    public LinkedList<Preference> getPreferences() {
        return preferences;
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet, incluant le prénom, l'email et le mot de passe de l'utilisateur.
     * Cette méthode est utilisée pour obtenir une vue textuelle de l'utilisateur.
     *
     * @return une chaîne de caractères représentant les informations principales de l'utilisateur (prénom, email, mot de passe).
     */

    @Override
    public String toString(){
        String message = firstName + ": " + email + "\n" + password + "\n";
        return message;
    }
    
}
