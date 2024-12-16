//Notificatoin.java
//IFT2255 - Équipe 15
//Classe Notification


package com.ift2255.MaVille;
import java.util.Date;
/**Classe qui gère les notifications
 */
public class Notification {
    int notificationId;
    private String title;
    private String message;
    private Date sendingDate;
    private boolean read;

/**Constructeur pour les notifications
 * @param id l'id pour les notifications
 * @param message la message de notification
 * @param date La date de notification
 */
    public Notification(int id, String message, Date date){
        this.notificationId = id;
        this.message = message;
        this.sendingDate = date;
	this.read = false;
    }

    
/**Affiche la message
 * @return la message de notification
 */
    public String getMessage() {
        return message;
    }
  /**Affiche l'ID de notification
   * @return l'ID de notification
   */  
    public int getNotificationId() {
        return notificationId;
    }
/**afficher la date d'envoie pour la notification
 * @return la date où la notificaton a été envoyé
 */
    public Date getSendingDate() {
        return sendingDate;
    }
/**Afficher le titre de la notification
 * @return le titre
 */
    public String getTitle(){
	    return this.title;
    }

/**Changer la message pour le notification
 * @param message la nouvelle message
    public void setMessage(String message) {
        this.message = message;
    }
/**Changer l'ID pour le notification
 * @param notificationId Le nouveau Id
 */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
/**Changer la date d'envoie pour un notification
 * @param sendingDate la nouvelle date d'envoie
 */
    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public boolean getRead(){
	    return read;
    }

    /**Changer le statut de la message pour indiqué que c'est lu
     */
    public void setRead(){
	    this.read = true;
    }
    /**Changer le statut de la message pour indiquer s'il est lu ou non
     * @param read le nouveau statut de lecture
     */
    public void setRead(boolean read){
	    this.read = read;
    }

    /**Fonction pour créer unString qui comprend le contenu de cette notification
     * @return le contenu en forme de String
     */

    public String toString(){
	    StringBuilder sb = new StringBuilder();
	    sb.append(this.title);
	    sb.append("\n");
	    sb.append(this.sendingDate.toString());
	    sb.append("\n \n");
	    sb.append(this.message);
	    return sb.toString();
    } 
}