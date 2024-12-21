//WorkRequest.java
//IFT2255 - Équipe 15
//Classe WorkRequest
package com.ift2255.MaVille;
import java.util.Date;
/**Classe qui gère les requêtes de travail */
public class WorkRequest {
    private static int idCounter = 0;  // Compteur pour générer un ID unique pour chaque requête
    private int requestID;
    private Resident resident;
    private String title;
    private String description;
    private String workType; // Initialisé dans le constructeur
    private Date expectedStartDate;
    private WorkRequestStatusEnum status;
    private Street workRequestAddress;  // Utilisation de la classe Street pour l'adresse
    private Intervenant intervenant;
/**Constructeur pour un requête de travail
 * @param title Titre pour le requête de travail
 * @param description Description des travaux à faire 
 * @param expectedStartDate date de début prévu
 * @param workType Type de travail
 * @param workRequestAddress Rue du demandeur de travail
 */
    // Constructeur
    public WorkRequest(String title, String description, Date expectedStartDate, String workType, Street workRequestAddress) {
        this.requestID = idCounter++;  // Incrémente l'ID pour chaque nouvelle requête
        this.title = title;
        this.description = description;
        this.expectedStartDate = expectedStartDate;
        this.status = WorkRequestStatusEnum.NOT_YET_STARTED; // Valeur par défaut

        if (workType == null) {
            this.workType = "Non spécifié";  // Utilise un type par défaut si null
        } else { this.workType = workType; }
        
        if (workRequestAddress == null) {
            this.workRequestAddress = new Street(0, "Non spécifiée");  // Utilise une adresse par défaut si null
        } else { this.workRequestAddress = workRequestAddress; }
    }

    /**
     * Envoie une notification associée à cette requête de travail.
     * La notification peut informer le résident et/ou l'intervenant
     * des mises à jour ou des changements de statut dans la requête.
     */
    public void sendNotification(){
        // Function
    }

    /**
     * Returns the description of the work request.
     *
     * @return the description of the work request
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the expected start date of the work request.
     *
     * @return the expected start date of the work request
     */
    public Date getExpectedStartDate() {
        return expectedStartDate;
    }

    /**
     * Returns the Intervenant associated with this work request.
     *
     * @return the Intervenant associated with this work request
     */
    public Intervenant getIntervenant() {
        return intervenant;
    }

    /**
     * Returns the ID of the work request.
     *
     * @return the ID of the work request
     */
    public int getRequestID() {
        return requestID;
    }

    /**
     * Returns the Resident who made this work request.
     *
     * @return the Resident who made this work request
     */
    public Resident getResident() {
        return resident;
    }

    /**
     * Returns the current status of the work request.
     *
     * @return the current status of the work request as a WorkRequestStatusEnum
     */
    public WorkRequestStatusEnum getStatus() { 
        return status;
    }

    /**
     * Returns the title of the work request.
     *
     * @return the title of the work request
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the address of the work request.
     *
     * @return the address of the work request as a Street object
     */
    public Street getWorkRequestAddress() {
        return workRequestAddress;
    }

    /**
     * Returns the type of work associated with this work request.
     *
     * @return the type of work as a String
     */
    public String getWorkType() {
        return workType;
    }


    /**
     * Sets the description of this work request.
     *
     * @param description the new description for this work request
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the expected start date for the work request.
     *
     * @param expectedStartDate the date to set as the expected start date for the work request
     */
    public void setExpectedStartDate(Date expectedStartDate) {
        this.expectedStartDate = expectedStartDate;
    }

    /**
     * Sets the Intervenant associated with this work request.
     *
     * @param intervenant the Intervenant to associate with this work request
     */
    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    /**
     * Sets the ID of the work request.
     *
     * @param requestID the ID to set for the work request
     */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    /**
     * Sets the Resident associated with this work request.
     *
     * @param resident the Resident to associate with this work request
     */
    public void setResident(Resident resident) {
        this.resident = resident;
    }

    /**
     * Sets the current status of the work request.
     *
     * @param status the status to set for the work request, represented as a WorkRequestStatusEnum
     */
    public void setStatus(WorkRequestStatusEnum status) {
        this.status = status;
    }

    /**
     * Sets the title of the work request.
     *
     * @param title the title to set for the work request
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the address of the work request.
     *
     * @param workRequestAddress the address to set for the work request
     */
    public void setWorkRequestAddress(Street workRequestAddress) {
        this.workRequestAddress = workRequestAddress;
    }

    /**
     * Sets the type of work for the work request.
     *
     * @param workType the type of work to set for the work request
     */
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
