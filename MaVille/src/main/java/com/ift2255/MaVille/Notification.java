//Notificatoin.java
//IFT2255 - Équipe 15
//Classe Notification


package com.ift2255.MaVille;
import java.util.Date;

public class Notification {
    int notificationId;
    String message;
    Date sendingDate;

    public Notification(int id, String message, Date date){
        this.notificationId = id;
        this.message = message;
        this.sendingDate = date;
    }

    public String getMessage() {
        return message;
    }
    
    public int getNotificationId() {
        return notificationId;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }
    
}
