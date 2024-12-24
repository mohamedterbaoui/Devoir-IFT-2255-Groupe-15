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

    /**
     * Constructeur de la classe Entrave, permettant d'initialiser les attributs de l'objet avec les valeurs spécifiées.
     *
     * @param id l'identifiant unique de l'entrave.
     * @param idRequest l'identifiant de la demande liée à l'entrave.
     * @param streetName le nom de la rue où l'entrave a lieu.
     * @param shortName un nom court pour la rue.
     * @param impactWidth la largeur de l'impact de l'entrave.
     * @param impactType le type d'impact (par exemple, sur la circulation, le stationnement, etc.).
     * @param freeParkingPlaces le nombre de places de stationnement libres.
     * @param sidewalkBlocked indique si le trottoir est bloqué.
     * @param bikePathBlocked indique si la piste cyclable est bloquée.
     * @param fromName le nom du point de départ de l'entrave.
     * @param toName le nom du point de fin de l'entrave.
     * @param length la longueur de l'entrave en mètres.
     * @param isArterial indique si l'entrave se trouve sur une artère principale.
     */

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

    /**
     * Retourne une représentation sous forme de chaîne de caractères des détails d'un objet, incluant ses attributs clés.
     * La méthode retourne une chaîne structurée affichant l'ID, le nom de rue, le nom court, la largeur d'impact,
     * le type d'impact, les noms de début et de fin, ainsi que la longueur de l'impact en mètres.
     *
     * @return une chaîne formatée représentant les informations de l'objet.
     */

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
