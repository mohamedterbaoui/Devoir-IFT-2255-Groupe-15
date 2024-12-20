package com.ift2255.MaVille;

public class Travaux {
    private int id; // "_id"
    private String projectId; // "id"
    private String permitPermitId; // "permit_permit_id"
    private String contractNumber; // "contractnumber"
    private String boroughId; // "boroughid"
    private String permitCategory; // "permitcategory"
    private String currentStatus; // "currentstatus"
    private String durationStartDate; // "duration_start_date"
    private String durationEndDate; // "duration_end_date"
    private String reasonCategory; // "reason_category"
    private String occupancyName; // "occupancy_name"
    private String submitterCategory; // "submittercategory"
    private String organizationName; // "organizationname"
    private String loadDate; // "load_date"
    private double longitude; // "longitude"
    private double latitude; // "latitude"

    // Constructor
    public Travaux(int id, String projectId, String permitPermitId, String contractNumber, String boroughId,
                   String permitCategory, String currentStatus, String durationStartDate, String durationEndDate,
                   String reasonCategory, String occupancyName, String submitterCategory, String organizationName,
                   String loadDate, double longitude, double latitude) {
        this.id = id;
        this.projectId = projectId;
        this.permitPermitId = permitPermitId;
        this.contractNumber = contractNumber;
        this.boroughId = boroughId;
        this.permitCategory = permitCategory;
        this.currentStatus = currentStatus;
        this.durationStartDate = durationStartDate;
        this.durationEndDate = durationEndDate;
        this.reasonCategory = reasonCategory;
        this.occupancyName = occupancyName;
        this.submitterCategory = submitterCategory;
        this.organizationName = organizationName;
        this.loadDate = loadDate;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // toString method
    @Override
    public String toString() {
        return "Travaux{" +
                "ID=" + id +
                ", Borough='" + boroughId + '\'' +
                ", Permit Category='" + permitCategory + '\'' +
                ", Current Status='" + currentStatus + '\'' +
                ", Start Date='" + durationStartDate + '\'' +
                ", End Date='" + durationEndDate + '\'' +
                ", Coordinates=(" + latitude + ", " + longitude + ")" +
                '}';
    }
}

