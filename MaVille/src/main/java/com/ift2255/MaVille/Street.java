package com.ift2255.MaVille;

public class Street {
    int streetID;
    String streetName;

    public Street(int id, String name){
        this.streetID = id;
        this.streetName = name;
    }

    public int getStreetID() {
        return streetID;
    }
    public String getStreetName() {
        return streetName;
    }

    public void setStreetID(int streetID) {
        this.streetID = streetID;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    // Pour affichage 
    @Override
    public String toString() {
        return streetName; 
    }
}
