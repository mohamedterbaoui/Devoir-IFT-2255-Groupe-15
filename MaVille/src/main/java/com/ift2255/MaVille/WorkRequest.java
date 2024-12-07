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
    private String status;
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
/**Afficher le déscription de la requête
 * @return le déscription de la requête
 */
    public String getDescription() {
        return description;
    }
/**Afficher la date de début
 * @return la date prévu de début
 */
    public Date getExpectedStartDate() {
        return expectedStartDate;
    }
/**Afficher l'intervenant
 * @return l'intérvenant
 */
    public Intervenant getIntervenant() {
        return intervenant;
    }
/**Afficher l'ID de la requête
 * @return id de la requête
 */
    public int getRequestID() {
        return requestID;
    }
/**Afficher le résident qui a fait la demande
 * @return le resident qui a fait la demande
 */
    public Resident getResident() {
        return resident;
    }
/**Afficher le statut de la requête
 * @return Le statut de la requête
 */
    public String getStatus() {
        return status;
    }
/**Afficher le titre 
 * @return le titre
 */
    public String getTitle() {
        return title;
    }
/**Afficher l'adresse de la requête
 * @return l'adresse
 */
    public Street getWorkRequestAddress() {
        return workRequestAddress;
    }
/**Afficher le type de travail
 * @return le type de travail
 */
    public String getWorkType() {
        return workType;
    }
/**Changer le déscription de la requête
 * @param description le nouveau déscription
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**Changer la date de début prévu
 * @param expectedStartDate la nouvelle date de début
 */
    public void setExpectedStartDate(Date expectedStartDate) {
        this.expectedStartDate = expectedStartDate;
    }
/**Changer l'intérvenant
 * @param intervenant Le nouveau intérvenant
 */
    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }
/**Changer l'ID de la requête
 * @param requestID La nouvelle Id de ce requête
 */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }
/**Changer le résident demandeur
 * @param resident le nouveau resident
 */
    public void setResident(Resident resident) {
        this.resident = resident;
    }
/**Changer le statut de la requête
 * @param status nouveau statut
 */
    public void setStatus(String status) {
        this.status = status;
    }
/**Changer le titre pour la requête
 * @param title nouveau titre
 */
    public void setTitle(String title) {
        this.title = title;
    }
/**Changer l'adresse de la requête de travail
 * @param workRequestAddress la nouvelle adresse
 */
    public void setWorkRequestAddress(Street workRequestAddress) {
        this.workRequestAddress = workRequestAddress;
    }
/**Changer le type de requête
 * @param workType le nouveau type de travail
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
