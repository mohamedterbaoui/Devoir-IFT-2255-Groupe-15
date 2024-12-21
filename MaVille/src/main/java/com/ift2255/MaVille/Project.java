//Project.java
//IFT2255 - Équipe 15
//Classe project

/**Classe qui gère la classe projet
 */
package com.ift2255.MaVille;
import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Project implements Serializable  {
    private int projectId;
    private String title;
    private String description;
    private Quartiers projectAddress;
    private Date startDate;
    private Date endDate;
    private ProjectStatusEnum status;
    private Intervenant intervenant;
    private LinkedList<Entrave> entraves;
    private LinkedList<Resident> affectedResidents;
    private String heureDebut;
    private String heureFin;
    private ProjectType projectType;
    private Boolean completed;

/**Le constructeur pour la classe
 * @param projectId l'ID du projet
 * @param title le titre du projet
 * @param projetAddress l'adresse du projet
 * @param startDate la date de début
 * @param endDate la date de fin
 * @param description le déscription du projet
 * @param intervenant l'intérvenant assigné
 * @param heureDebut l'heure de début
 * @param heureFin L'heure de fin
 * @param projectType le type du projet
 */

    public Project(int id, String title, Quartiers projectAddress, Date startDate, Date endDate, String description, Intervenant intervenant, String heureDebut, String heureFin, ProjectType projectType){
        if (id == 0) {
            Random random = new Random();
            this.projectId = random.nextInt(10000) + 1; // Génère un nombre aléatoire entre 1 et 1000
        }
        else {
            this.projectId = id;
        }
        this.title = title;
        this.projectAddress = projectAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.status = ProjectStatusEnum.NOT_YET_STARTED; // Valeur par défaut
        this.intervenant = intervenant; 
        this.heureDebut = heureDebut;
        this.heureFin = heureFin; 
        this.projectType = projectType; 
        this.completed = false; // Not completed par défaut
    }

    /**
     * Checks if the project is completed.
     *
     * @return true if the project is completed, false otherwise
     */
    public Boolean isCompleted(){
        return this.completed;
    }
  
    //getters
/**Affiche les residents affecté
 * @return les résidents affectés
 */
    public LinkedList<Resident> getAffectedResidents() {
        return affectedResidents;
    }

    /**
     * Returns the description of the project.
     *
     * @return the description of the project
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the end date of the project.
     *
     * @return the end date of the project
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Returns the list of Entraves associated with this project.
     *
     * @return the list of Entraves
     */
    public LinkedList<Entrave> getEntraves() {
        return entraves;
    }


    /**
     * Returns the Intervenant associated with this project.
     *
     * @return the Intervenant associated with this project
     */
    public Intervenant getIntervenant() {
        return intervenant;
    }
    /**
     * Returns the address of the project.
     *
     * @return the address of the project
     */

    /**
     * Returns the address of the project.
     *
     * @return the address of the project
     */
    public Quartiers getProjectAddress() {
        return projectAddress;
    }

    /**
     * Returns the ID of the project.
     *
     * @return the ID of the project
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Returns the start time of the project.
     *
     * @return the start time of the project
     */
    public String getHeureDebut() {
        return heureDebut;
    }

    /**
     * Returns the end time of the project.
     *
     * @return the end time of the project
     */
    public String getHeureFin() {
        return heureFin;
    }

    /**
     * Returns the type of the project.
     *
     * @return the type of the project
     */
    public ProjectType getProjectType() {
        return projectType;
    }

    /**
     * Returns the start date of the project.
     *
     * @return the start date of the project
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Returns the current status of the project.
     *
     * @return the current status of the project as a ProjectStatusEnum
     */
    public ProjectStatusEnum getStatus() {
        return status;
    }

    /**
     * Returns the title of the project.
     *
     * @return the title of the project
     */
    public String getTitle() {
        return title;
    }
    //setters

    /**
     * Sets the list of residents affected by the project.
     *
     * @param affectedResidents the list of affected residents
     */
    public void setAffectedResidents(LinkedList<Resident> affectedResidents) {
        this.affectedResidents = affectedResidents;
    }

    /**
     * Sets the description of the project.
     *
     * @param description the description of the project
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the end date of the project.
     *
     * @param endDate the end date of the project
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Sets the list of entraves associated with the project.
     *
     * @param entraves the list of entraves associated with the project
     */
    public void setEntraves(LinkedList<Entrave> entraves) {
        this.entraves = entraves;
    }

    /**
     * Sets the Intervenant associated with this project.
     *
     * @param intervenant the Intervenant associated with this project
     */
    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    /**
     * Sets the address of the project.
     *
     * @param projectAddress the address to set for the project
     */
    public void setProjectAddress(Quartiers projectAddress) {
        this.projectAddress = projectAddress;
    }

    /**
     * Sets the ID of the project.
     *
     * @param projectId the ID to set for the project
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * Sets the start time of the project.
     *
     * @param heureDebut the start time to set for the project
     */
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    /**
     * Sets the end time of the project.
     *
     * @param heureFin the end time to set for the project
     */
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    /**
     * Sets the type of the project.
     *
     * @param projectType the type to set for the project
     */
    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    /**
     * Sets the start date of the project.
     *
     * @param startDate the start date to set for the project
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets the current status of the project.
     *
     * @param status the status to set for the project, represented as a ProjectStatusEnum
     */
    public void setStatus(ProjectStatusEnum status) {
        this.status = status;
    }

    /**
     * Sets the title of the project.
     *
     * @param title the title to set for the project
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
