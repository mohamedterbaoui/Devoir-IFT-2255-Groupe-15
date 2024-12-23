// Entrave.java
// IFT2255 - Équipe 15
// Classe Entrave
package com.ift2255.MaVille;

public class Entrave {
    private int id; // "_id"
    private String idRequest; // "id_request"
    private String streetName; // "name"
    private String shortName; // "shortname"
    private String impactWidth; // "streetimpactwidth"
    private String impactType; // "streetimpacttype"
    private int freeParkingPlaces; // "nbfreeparkingplace"
    private String sidewalkBlocked; // "sidewalk_blockedtype"
    private String bikePathBlocked; // "bikepath_blockedtype"
    private String fromName; // "fromname"
    private String toName; // "toname"
    private double length; // "length"
    private boolean isArterial; // "isarterial"

    // Constructeur
    public Entrave(int id, String idRequest, String streetName, String shortName, String impactWidth, String impactType,
                   int freeParkingPlaces, String sidewalkBlocked, String bikePathBlocked, String fromName,
                   String toName, double length, boolean isArterial) {
        this.id = id;
        this.idRequest = idRequest;
        this.streetName = streetName;
        this.shortName = shortName;
        this.impactWidth = impactWidth;
        this.impactType = impactType;
        this.freeParkingPlaces = freeParkingPlaces;
        this.sidewalkBlocked = sidewalkBlocked;
        this.bikePathBlocked = bikePathBlocked;
        this.fromName = fromName;
        this.toName = toName;
        this.length = length;
        this.isArterial = isArterial;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getImpactWidth() {
        return impactWidth;
    }

    public void setImpactWidth(String impactWidth) {
        this.impactWidth = impactWidth;
    }

    public String getImpactType() {
        return impactType;
    }

    public void setImpactType(String impactType) {
        this.impactType = impactType;
    }

    public int getFreeParkingPlaces() {
        return freeParkingPlaces;
    }

    public void setFreeParkingPlaces(int freeParkingPlaces) {
        this.freeParkingPlaces = freeParkingPlaces;
    }

    public String getSidewalkBlocked() {
        return sidewalkBlocked;
    }

    public void setSidewalkBlocked(String sidewalkBlocked) {
        this.sidewalkBlocked = sidewalkBlocked;
    }

    public String getBikePathBlocked() {
        return bikePathBlocked;
    }

    public void setBikePathBlocked(String bikePathBlocked) {
        this.bikePathBlocked = bikePathBlocked;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isArterial() {
        return isArterial;
    }

    public void setArterial(boolean arterial) {
        isArterial = arterial;
    }

    // Méthode toString pour affichage
    @Override
    public String toString() {
        return  "---------------------------------------------\n" +
                "ID=" + id + "\n" +
                "Street Name= " + streetName + "\n" +
                "Short Name= " + shortName + "\n" +
                "Impact Width= " + impactWidth + "\n" +
                "Impact Type= " + impactType + "\n" +
                "From= " + fromName + "\n" +
                "To= " + toName + "\n" +
                "Length= " + length + " meters" + "\n" +
                "---------------------------------------------\n";
    }
}
