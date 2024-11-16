//WorkRequest.java
//IFT2255 - Équipe 15
//Classe WorkRequest
package com.ift2255.MaVille;

public class WorkRequest {
    int requestID;
    Resident resident;
    String title;
    String description;
    String workType;
    Date expectedStartDate;
    String status;
    String workRequestAddress;
    Intervenant intervenant;

    WorkRequest(int id, String title, String description, String address){
        this.requestID = id;
        this.title = title;
        this.description = description;
        this.workRequestAddress = address;
    }

    public void sendNotification(){

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

    public String getWorkRequestAddress() {
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

    public void setWorkRequestAddress(String workRequestAddress) {
        this.workRequestAddress = workRequestAddress;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
    
    
}
