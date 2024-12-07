//Notificatoin.java
//IFT2255 - Équipe 15
//Classe Notification


package com.ift2255.MaVille;
import java.util.Date;
/**Classe qui gère les notifications
 */
public class Notification {
    int notificationId;
    String message;
    Date sendingDate;
/**Constructeur pour les notifications
 * @param id l'id pour les notifications
 * @param message la message de notification
 * @param date La date de notification
 */
    public Notification(int id, String message, Date date){
        this.notificationId = id;
        this.message = message;
        this.sendingDate = date;
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
    
}
