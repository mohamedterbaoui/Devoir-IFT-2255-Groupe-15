//Project.java
//IFT2255 - Équipe 15
//Classe project

/**Classe qui gère la classe projet
 */
package com.ift2255.MaVille;
import java.util.LinkedList;
import java.util.Date;

public class Project {
    private int projectId;
    private String title;
    private String description;
    private String projectAddress;
    private Date startDate;
    private Date endDate;
    private String status;
    private Intervenant intervenant;
    private LinkedList<Entrave> entraves;
    private LinkedList<Resident> affectedResidents;
    private String projectSchedule;
    private ProjectType projectType;
    private Boolean completed;
/**Le constructeur pour la classe
 * @param projectId l'ID du projet
 * @param title le titre du projet
 * @param projetAddress l'adresse du projet
 * @param startDate la date de début
 * @param la date de fin
 */
    public Project(int projectId, String title, String projectAddress, Date startDate, Date endDate){
        this.projectId = projectId;
        this.title = title;
        this.projectAddress = projectAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = false;
    }
    public void addEntrave(){

    }

    public String getProjectDetails(){
        //fonction
        return("NON!!!!!!!!");
    }
/**Retourne un boolean si je projet est complété
 * @return Vrai si elle est complété
 */
    public Boolean isCompleted(){
        return this.completed;
    }

    public void removeEntrave(Entrave entrave){

    }

    
    
    //getters
/**Affiche les residents affecté
 * @return les résidents affectés
 */
    public LinkedList<Resident> getAffectedResidents() {
        return affectedResidents;
    }
/**Affiche le déscription
 * @return le déscription 
 */
    public String getDescription() {
        return description;
    }
/**Afficher la date de fin
 * @ returns la date de fin
 */
    public Date getEndDate() {
        return endDate;
    }
/**Affiche la liste des entraves
 * @return les éntraves
 */
    public LinkedList<Entrave> getEntraves() {
        return entraves;
    }
/**Afficher l'intérvenant
 * @ return l'intérvenant
 */
    public Intervenant getIntervenant() {
        return intervenant;
    }
/**Affiche l'adresse du projet
 * @return l'adresse du projet
 */
    public String getProjectAddress() {
        return projectAddress;
    }
/**Affice l'ID du projet
 * @return l'ID du projet
 */
    public int getProjectId() {
        return projectId;
    }
/**Affiche l'horaire du projet
 * @return Affice l'ID du projet
 */
    public String getProjectSchedule() {
        return projectSchedule;
    }
/** Affiche le type du projet
 * @return le type du projet
 */
    public ProjectType getProjectType() {
        return projectType;
    }
/** Affiche la date de début
 * @return la date de début
 */
    public Date getStartDate() {
        return startDate;
    }
/**Affiche le statut du projet
 * @return le statut du projet
 */
    public String getStatus() {
        return status;
    }
/**Affiche le titre du projet
 * @return le titre du projet
 */
    public String getTitle() {
        return title;
    }
    //setters
/**Changer les résidents affectés
 * @param affectedResidents les résidents touché par ce projet
 */
    public void setAffectedResidents(LinkedList<Resident> affectedResidents) {
        this.affectedResidents = affectedResidents;
    }
/**Changer le description du projet
 * @param description le nouveau description
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**Changer la date de fin
 * @param  endDate
 */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
/**Changer les éntraves
 * @param entraves échanger les éntraves
 */
    public void setEntraves(LinkedList<Entrave> entraves) {
        this.entraves = entraves;
    }
/**Changer l'intérvenant
 * @param intervenant le nouveau intérvenant
 */
    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }
/**Changer l'adresse du projet
 * @param projectAddress le nouveau adresse
 */
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }
/**Changer l'ID du projet
 * @param projectId le nouveau ID du projet
 */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
/**Changer l'horaire du projet
 * @param projectSchedule la nouvelle horaire
 */
    public void setProjectSchedule(String projectSchedule) {
        this.projectSchedule = projectSchedule;
    }
/**Changer le type du projet
 * @param projectType le nouveau type du projet
 */
    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
/**Changer la date de debut du projet
 * @param startDate la nouvelle date de début
 */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
/**Changer le statut du projet
 * @param status le nouveau statut
 */
    public void setStatus(String status) {
        this.status = status;
    }
/**Changer le titre du projet
 * @param title le nouveau titre
 */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
