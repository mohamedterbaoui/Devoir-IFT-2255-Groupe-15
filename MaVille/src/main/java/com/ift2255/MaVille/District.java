//District.java
//IFT2255 - Équipe 15
//Classe district

package com.ift2255.MaVille;

public class District {
    int districtId;
    String districtName;

    public District(int id, String name){
        this.districtId = id;
        this.districtName = name;
    }

    public int getDistrictId() {
        return districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}
