//ResidentController.java
//IFT2255 - Équipe 15
//Controlleur qui gére les résidents

package com.ift2255.MaVille;

public class ResidentController extends Controller{
    
    private Resident currentResident;

    public ResidentController(Resident resident) {
        this.currentResident = resident;
    }

    public Resident getCurrentResident() {
        return currentResident;
    }
    
    public void viewProjects(){
        //fonction
    }

    public void addWorkRequest(WorkRequest request){
        //fonction
    }
    
}
