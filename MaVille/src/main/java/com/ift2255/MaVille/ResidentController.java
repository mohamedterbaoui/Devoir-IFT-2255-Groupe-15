//ResidentController.java
//IFT2255 - Équipe 15
//Controlleur qui gére les résidents

//ResidentController.java
// ResidentController.java
package com.ift2255.MaVille;

import java.util.ArrayList;
import java.util.LinkedList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Date;

public class ResidentController extends Controller {

    private Resident currentResident;

    public ResidentController(Resident resident) {
        this.currentResident = resident;
    }

    public Resident getCurrentResident() {
        return currentResident;
    }

    // Affiche les requêtes de travail pour le résident
    public void viewWorkRequests() {
        LinkedList<WorkRequest> workRequests = currentResident.getWorkRequests();
        if (workRequests.isEmpty()) {
            System.out.println("Aucune requête de travail disponible.");
        } else {
            for (WorkRequest request : workRequests) {
                System.out.println("ID : " + request.getRequestID() + ", Titre : " + request.getTitle());
            }
        }
    }

    public void viewProjects() {
        // Fonction pour gérer les projets
    }

    // Ajoute une requête de travail pour le résident connecté
    public void addWorkRequest(String title, String description, String workType, Date expectedStartDate, Street workRequestAddress) {
        WorkRequest newWorkRequest = new WorkRequest(title, description, expectedStartDate, workType, workRequestAddress);
        newWorkRequest.setResident(currentResident); // Associe la requête au résident connecté
        currentResident.getWorkRequests().add(newWorkRequest); // Ajoute la requête à la liste du résident
        WorkRequestController.addWorkRequest(newWorkRequest); // Ajoute la requête à la liste globale
    }

    public void viewAllProjects(){
        ArrayList<Travaux> travauxList = new ArrayList<>();

        HttpClientApi api = new HttpClientApi();

        String resourceIdTravaux = "cc41b532-f12d-40fb-9f55-eb58c9a2b12b"; // ID for Travaux

        ApiResponse responseTravaux = api.getData(resourceIdTravaux);

        if (responseTravaux != null && responseTravaux.getStatusCode() == 200) {
            try {

                // Parse Json using Gson library
                JsonArray records = jsonParsing(responseTravaux);

                // Loop through each record
                for (int i = 0; i < records.size(); i++) {

                    JsonObject record = records.get(i).getAsJsonObject();

                    // Extract fields
                    int id = record.get("_id").getAsInt();
                    String projectId = record.get("id").getAsString();
                    String permitPermitId = record.get("permit_permit_id").isJsonNull() ? null : record.get("permit_permit_id").getAsString();
                    String contractNumber = record.get("contractnumber").isJsonNull() ? null : record.get("contractnumber").getAsString();
                    String boroughId = record.get("boroughid").isJsonNull() ? null : record.get("boroughid").getAsString();
                    String permitCategory = record.get("permitcategory").isJsonNull() ? null : record.get("permitcategory").getAsString();
                    String currentStatus = record.get("currentstatus").isJsonNull() ? null : record.get("currentstatus").getAsString();
                    String durationStartDate = record.get("duration_start_date").isJsonNull() ? null : record.get("duration_start_date").getAsString();
                    String durationEndDate = record.get("duration_end_date").isJsonNull() ? null : record.get("duration_end_date").getAsString();
                    String reasonCategory = record.get("reason_category").isJsonNull() ? null : record.get("reason_category").getAsString();
                    String occupancyName = record.get("occupancy_name").isJsonNull() ? null : record.get("occupancy_name").getAsString();
                    String submitterCategory = record.get("submittercategory").isJsonNull() ? null : record.get("submittercategory").getAsString();
                    String organizationName = record.get("organizationname").isJsonNull() ? null : record.get("organizationname").getAsString();
                    String loadDate = record.get("load_date").isJsonNull() ? null : record.get("load_date").getAsString();
                    double longitude = record.has("longitude") && !record.get("longitude").isJsonNull() ? record.get("longitude").getAsDouble() : 0.0;
                    double latitude = record.has("latitude") && !record.get("latitude").isJsonNull() ? record.get("latitude").getAsDouble() : 0.0;

                    // Create and add Travaux object to the list
                    Travaux travaux = new Travaux(id, projectId, permitPermitId, contractNumber, boroughId,
                            permitCategory, currentStatus, durationStartDate, durationEndDate, reasonCategory,
                            occupancyName, submitterCategory, organizationName, loadDate, longitude, latitude);
                    travauxList.add(travaux);
                }

                // Display all Travaux objects
                for (Travaux travaux : travauxList) {
                    System.out.println(travaux);
                }

            } catch (Exception e) {
                System.err.println("Error parsing JSON: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to retrieve data");
        }
    }

    public void viewAllEntraves(){
        ArrayList<Entrave> entraves = new ArrayList<>();

        HttpClientApi api = new HttpClientApi();

        String resourceIdEntraves = "a2bc8014-488c-495d-941b-e7ae1999d1bd"; // id entraves

        ApiResponse responseEntrave = api.getData(resourceIdEntraves);

        if (responseEntrave != null && responseEntrave.getStatusCode() == 200) {
            try {

                // Parse JSON using Gson library
                JsonArray records = jsonParsing(responseEntrave);


                // Loop through each record
                for (int i = 0; i < records.size(); i++) {
                    JsonObject record = records.get(i).getAsJsonObject();

                    int id = record.get("_id").getAsInt();
                    String idRequest = record.get("id_request").getAsString();
                    String streetName = record.get("name").getAsString();
                    String impactWidth = record.get("streetimpactwidth").getAsString();
                    String impactType = record.get("streetimpacttype").getAsString();
                    int freeParkingPlaces = record.has("nbfreeparkingplace") && !record.get("nbfreeparkingplace").isJsonNull()
                            ? Integer.parseInt(record.get("nbfreeparkingplace").getAsString())
                            : 0;
                    String sidewalkBlocked = record.get("sidewalk_blockedtype").getAsString();
                    String bikePathBlocked = record.get("bikepath_blockedtype").getAsString();
                    String fromName = record.get("fromname").getAsString();
                    String toName = record.get("toname").getAsString();
                    double length = Double.parseDouble(record.get("length").getAsString());

                    // Create and add Entrave object to the list
                    Entrave entrave = new Entrave(id, idRequest, streetName, impactWidth, impactType, freeParkingPlaces,
                            sidewalkBlocked, bikePathBlocked, fromName, toName, length);
                    entraves.add(entrave);
                }

                // Display all Entrave objects
                for (Entrave entrave : entraves) {
                    System.out.println(entrave);
                }

            } catch (Exception e) {
                System.out.println("Error parsing JSON: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to retrieve data: " + (responseEntrave != null ? responseEntrave.getMessage() : "No responseEntrave"));
        }
    }

    public JsonArray jsonParsing(ApiResponse responseEntrave){
        JsonObject rootObject = JsonParser.parseString(responseEntrave.getBody()).getAsJsonObject();
        JsonObject result = rootObject.getAsJsonObject("result");
        return result.getAsJsonArray("records");
    }
}


