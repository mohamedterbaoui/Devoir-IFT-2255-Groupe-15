package com.ift2255.MaVille;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cette classe gère les informations relatives aux travaux et expose les données
 * pertinentes pour l'interaction avec le ResidentController.
 */
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

    /**
     * Constructeur de la classe Travaux
     *
     * @param id                ID pour ces travaux
     * @param projectId         ID du projet
     * @param permitPermitId    Le permis et son ID
     * @param contractNumber    Le numéro du contrat
     * @param boroughId         L'ID de l'arrondissement
     * @param permitCategory    Catégorie de permis
     * @param currentStatus     Statut actuel
     * @param durationStartDate Date de début des travaux
     * @param durationEndDate   Date de fin des travaux
     * @param reasonCategory    Catégorie de raison des travaux
     * @param occupancyName     Occupation concernée
     * @param submitterCategory Catégorie de l'intérvenant ayant soumis les travaux
     * @param organizationName  Nom de l'organisation effectuant les travaux
     * @param loadDate          Date de chargement des données
     * @param longitude         Coordonnée GPS de longitude
     * @param latitude          Coordonnée GPS de latitude
     */
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

    // Getters et setters pour chaque champ

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPermitPermitId() {
        return permitPermitId;
    }

    public void setPermitPermitId(String permitPermitId) {
        this.permitPermitId = permitPermitId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBoroughId() {
        return boroughId;
    }

    public void setBoroughId(String boroughId) {
        this.boroughId = boroughId;
    }

    public String getPermitCategory() {
        return permitCategory;
    }

    public void setPermitCategory(String permitCategory) {
        this.permitCategory = permitCategory;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getDurationStartDate() {
        return durationStartDate;
    }

    public void setDurationStartDate(String durationStartDate) {
        this.durationStartDate = durationStartDate;
    }

    public String getDurationEndDate() {
        return durationEndDate;
    }

    public void setDurationEndDate(String durationEndDate) {
        this.durationEndDate = durationEndDate;
    }

    public String getReasonCategory() {
        return reasonCategory;
    }

    public void setReasonCategory(String reasonCategory) {
        this.reasonCategory = reasonCategory;
    }

    public String getOccupancyName() {
        return occupancyName;
    }

    public void setOccupancyName(String occupancyName) {
        this.occupancyName = occupancyName;
    }

    public String getSubmitterCategory() {
        return submitterCategory;
    }

    public void setSubmitterCategory(String submitterCategory) {
        this.submitterCategory = submitterCategory;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Convertit une date en format String en un objet Date (facultatif pour ResidentController).
     */
    public static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

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
