//Entrave.java
//IFT2255 - Équipe 15
// Classe Entrave
package com.ift2255.MaVille;

public class Entrave {
    private int id; // "_id"
    private String idRequest; // "id_request"
    private String streetName; // "name"
    private String impactWidth; // "streetimpactwidth"
    private String impactType; // "streetimpacttype"
    private int freeParkingPlaces; // "nbfreeparkingplace"
    private String sidewalkBlocked; // "sidewalk_blockedtype"
    private String bikePathBlocked; // "bikepath_blockedtype"
    private String fromName; // "fromname"
    private String toName; // "toname"
    private double length; // "length"

    // Constructor
    public Entrave(int id, String idRequest, String streetName, String impactWidth, String impactType,
                   int freeParkingPlaces, String sidewalkBlocked, String bikePathBlocked,
                   String fromName, String toName, double length) {
        this.id = id;
        this.idRequest = idRequest;
        this.streetName = streetName;
        this.impactWidth = impactWidth;
        this.impactType = impactType;
        this.freeParkingPlaces = freeParkingPlaces;
        this.sidewalkBlocked = sidewalkBlocked;
        this.bikePathBlocked = bikePathBlocked;
        this.fromName = fromName;
        this.toName = toName;
        this.length = length;
    }

    // toString method for display
    @Override
    public String toString() {
        return "Entrave{" +
                "ID=" + id +
                ", Street='" + streetName + '\'' +
                ", Impact Width='" + impactWidth + '\'' +
                ", Impact Type='" + impactType + '\'' +
                ", From='" + fromName + '\'' +
                ", To='" + toName + '\'' +
                ", Length=" + length + " meters" +
                '}';
    }
}
