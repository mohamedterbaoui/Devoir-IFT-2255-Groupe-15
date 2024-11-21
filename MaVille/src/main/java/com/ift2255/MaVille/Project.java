//Project.java
//IFT2255 - Équipe 15
//Classe project

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

    public Boolean isCompleted(){
        return this.completed;
    }

    public void removeEntrave(Entrave entrave){

    }

    
    
    //getters
    public LinkedList<Resident> getAffectedResidents() {
        return affectedResidents;
    }

    public String getDescription() {
        return description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public LinkedList<Entrave> getEntraves() {
        return entraves;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectSchedule() {
        return projectSchedule;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
    //setters

    public void setAffectedResidents(LinkedList<Resident> affectedResidents) {
        this.affectedResidents = affectedResidents;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEntraves(LinkedList<Entrave> entraves) {
        this.entraves = entraves;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectSchedule(String projectSchedule) {
        this.projectSchedule = projectSchedule;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
