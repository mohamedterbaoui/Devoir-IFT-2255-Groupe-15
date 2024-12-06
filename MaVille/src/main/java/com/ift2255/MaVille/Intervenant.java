//Intervenant.java
//IFT2255 - Équipe 15
//Fichier pour la classe Intervenant
package com.ift2255.MaVille;

import java.util.LinkedList;
import java.util.Date;
public class Intervenant extends User{
    private String typeIntervenant;
    private int cityId;
    private LinkedList<WorkRequest> workRequests;
    private LinkedList<Project> projects;

    public Intervenant(String firstName, String lastName, Date birthDate, String email, String password, String phone, String userAddress, String typeIntervenant, int cityId) {
        super(firstName, lastName, birthDate, email, password, phone, userAddress);
        this.typeIntervenant = typeIntervenant; 
        // Vérification si cityId est valide
        if (cityId <= 0) {
            throw new IllegalArgumentException("cityId doit être supérieur à 0");
        }
        this.cityId = cityId; 
        this.workRequests = new LinkedList<>();
    }

    public void applyToWorkRequest() { // Fonction qui appelle applyToWorkRequest() de IntervenantController
        IntervenantController intervenantController = new IntervenantController(this); // Créez une instance avec l'intervenant actuel
        intervenantController.applyToWorkRequest(); // Appelez la méthode d'instance
    }

    public String getName() {
        return firstName;
    }

    public String getType() {
        return typeIntervenant;
    }

    public void addNewProject(){ //fonction qui appelle submitProject(Project project) de IntervenantController
        
    }

    public LinkedList<String> viewResidentPreferences(Resident resident){
       return(resident.getPreferredProjectTimes());
    }

    public void modifyProjectStatus(Project project, String newStatus){ //fonction qui appelle modifyProjectStatus(Project project, String newStatus) de IntervenantController
        
    }

    public void trackApplicationStatus() { // Fonction qui appelle trackApplicationStatus(int requestID) de IntervenantController
        
    }


    //getters
    public String getTypeIntervenant() {
        return typeIntervenant;
    }

    public int getCityId() {
        return cityId;
    }

    public LinkedList<Project> getProjects() {
        return projects;
    }

    public LinkedList<WorkRequest> getWorkRequests() {
        return workRequests;
    }

    // setters
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setProjects(LinkedList<Project> projects) {
        this.projects = projects;
    }
    
    public void setTypeIntervenant(String typeIntervenant) {
        this.typeIntervenant = typeIntervenant;
    }

    public void setWorkRequests(LinkedList<WorkRequest> workRequests) {
        this.workRequests = workRequests;
    }
    
}
