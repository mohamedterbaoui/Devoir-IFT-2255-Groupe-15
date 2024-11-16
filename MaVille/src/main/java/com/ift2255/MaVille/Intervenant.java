//Intervenant.java
//IFT2255 - Équipe 15
//Fichier pour la classe Intervenant
package com.ift2255.MaVille;

import java.util.LinkedList;

public class Intervenant extends User{
    private Type typeIntervenant;
    private int cityId;
    private LinkedList<WorkRequest> workRequests;
    private LinkedList<Projects> projects;

    public Intervenant(String fullName,Date birthDate, String email, String password, int phone, String userAddress, Type typeIntervenant, int cityId){
        Super(fullName, birthDate, email,password, phone, userAddress);
        this.typeIntervenant = typeIntervenant;
        this.cityId = cityId;
    }

    public void applyToWorkRequest(){
        //fonction
    }

    public void addNewProject(){
        //fonction
    }

    public LinkedList<String> viewResidentPreferences(){
        //fonction
    }

    public editProjectDetails(Project project){
        //fonction
    }


    //getters
    public Type getTypeIntervenant() {
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

    public void setProjects(LinkedList<Projects> projects) {
        this.projects = projects;
    }
    
    public void setTypeIntervenant(Type typeIntervenant) {
        this.typeIntervenant = typeIntervenant;
    }

    public void setWorkRequests(LinkedList<WorkRequest> workRequests) {
        this.workRequests = workRequests;
    }
    
}
