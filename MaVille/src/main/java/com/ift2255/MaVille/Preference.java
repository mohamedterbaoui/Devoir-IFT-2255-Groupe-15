//Preference.java
//IFT2255 - Équipe 15
//Classe pour les préférences 
package com.ift2255.MaVille;

public class Preference {
    int preferenceId;
    String schedule;
    
    public Preference(int id, String schedule){
        this.preferenceId = id;
        this.schedule = schedule;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
