//Resident.java
//IFT2255 - Équipe 15
//La classe pour les résidents
package com.ift2255.MaVille;

import java.util.LinkedList;
import java.util.Date;

public class Resident extends User{
    private String city;
    private LinkedList<String> preferredProjectTimes;
    private LinkedList<Project> subscriptions;
    private LinkedList<WorkRequest> workRequests;

    public Resident(String firstName, String lastName,Date birthDate, String email, String password, String phone, String userAddress, String city){
        super(firstName, lastName, birthDate, email, password, phone, userAddress);
        this.city = city;
    }

    public void subscribeToProject(Project project){
        subscriptions.add(project);
    }

    public void unsubscribeFromProject(Project project){
        // fonction
    }

    public void addWorkRequest(String title, String workType, Date expectedStartDate){
        WorkRequest newWorkRequest = new WorkRequest(title, workType, expectedStartDate);
        newWorkRequest.setResident(this);
        newWorkRequest.setWorkRequestAddress(this.userAddress);
        workRequests.add(newWorkRequest);
    }

    public Project searchProject(){
      return null;
    }

    //getters
    public String getCity() {
        return city;
    }

    public LinkedList<String> getPreferredProjectTimes(){
        return preferredProjectTimes;
    }

    public LinkedList<Project> getSubscriptions() {
        return subscriptions;
    }

    public LinkedList<WorkRequest> getWorkRequests() {
        return workRequests;
    }

    //setters
    public void setCity(String city) {
        this.city = city;
    }

    public void setPreferredProjectTimes(LinkedList<String> preferredProjectTimes) {
        this.preferredProjectTimes = preferredProjectTimes;
    }

    public void setSubscriptions(LinkedList<Project> subscriptions) {
        this.subscriptions = subscriptions;
    }
    
    public void setWorkRequests(LinkedList<WorkRequest> workRequests) {
        this.workRequests = workRequests;
    }

    public void getNotifications(){}

    public void editPreferences(){}
    
}
