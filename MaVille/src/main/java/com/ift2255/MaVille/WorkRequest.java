//WorkRequest.java
//IFT2255 - Équipe 15
//Classe WorkRequest
package com.ift2255.MaVille;
import java.util.Date;

public class WorkRequest {
    private static int idCounter = 0;  // Compteur pour générer un ID unique pour chaque requête
    private int requestID;
    private Resident resident;
    private String title;
    private String description;
    private String workType; // Initialisé dans le constructeur
    private Date expectedStartDate;
    private String status;
    private Street workRequestAddress;  // Utilisation de la classe Street pour l'adresse
    private Intervenant intervenant;

    // Constructeur
    public WorkRequest(String title, String description, Date expectedStartDate, String workType, Street workRequestAddress) {
        this.requestID = idCounter++;  // Incrémenter l'ID pour chaque nouvelle requête
        this.title = title;
        this.description = description;
        this.expectedStartDate = expectedStartDate;
        this.status = "Pas encore commencé";  // Valeur par défaut pour le statut

        if (workType == null) {
            this.workType = "Non spécifié";  // Utilise un type par défaut si null
        } else { this.workType = workType; }
        
        if (workRequestAddress == null) {
            this.workRequestAddress = new Street(0, "Non spécifiée");  // Utilise une adresse par défaut si null
        } else { this.workRequestAddress = workRequestAddress; }
    }

    public void sendNotification(){
        // Function
    }

    public String getDescription() {
        return description;
    }

    public Date getExpectedStartDate() {
        return expectedStartDate;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public int getRequestID() {
        return requestID;
    }

    public Resident getResident() {
        return resident;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public Street getWorkRequestAddress() {
        return workRequestAddress;
    }

    public String getWorkType() {
        return workType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpectedStartDate(Date expectedStartDate) {
        this.expectedStartDate = expectedStartDate;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWorkRequestAddress(Street workRequestAddress) {
        this.workRequestAddress = workRequestAddress;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
    
   public String toString(){
	StringBuilder sb = new StringBuilder();
	   
        sb.append("-------------------------------------\n");
        sb.append("ID : " + this.getRequestID()+"\n");
        sb.append("Titre : " + getTitle() + "\n");
        sb.append("Description : " + getDescription()+ "\n");
        sb.append("Type de travaux : " + getWorkType()+"\n");
        sb.append("Date prévue de début : " + getExpectedStartDate()+"\n");
        sb.append("Adresse : " + getWorkRequestAddress()+"\n");
        sb.append("Statut : " + getStatus()+"\n");
        sb.append("Résident affecté : " + getResident().getFirstName() + " " + getResident().getLastName()+"\n");
        sb.append("-------------------------------------\n");
	return sb.toString();
   }
}
