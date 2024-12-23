//ResidentController.java
//IFT2255 - Équipe 15
//Controlleur qui gére les résidents

//ResidentController.java
// ResidentController.java
package com.ift2255.MaVille;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Date;
/**La classe qui gère les activités des résidents
 */
public class ResidentController extends Controller {
    private static List<Resident> residents = new ArrayList<>(); // Liste statique pour stocker les résidents
    private Resident currentResident;

    public ResidentController(Resident resident) {
        this.currentResident = resident;
    }

    public Resident getCurrentResident() {
        return currentResident;
    }

    // Affiche les requêtes de travail pour le résident
    /**Affiche les demandes de travail
     * @return Une liste chaînée avec les requêtes de travail
     */
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
/**Faire une demande de travaux 
* @param title Le titre de la demande
* @param description la demande
* @param workType le type de travail
* @param expectedStartDate la date de début attendé
* @param workRequestAddress l'adresse pour la demande
*/
    public void addWorkRequest(String title, String description, String workType, Date expectedStartDate, Street workRequestAddress) {
        int id = 0; // id mit à 0 par défaut pour que ça génère un id random dans le constructeur de la classe WorkRequest
        WorkRequest newWorkRequest = new WorkRequest(id, title, description, expectedStartDate, workType, workRequestAddress);
        newWorkRequest.setResident(currentResident); // Associe la requête au résident connecté
        currentResident.getWorkRequests().add(newWorkRequest); // Ajoute la requête à la liste du résident
        WorkRequestController.addWorkRequest(newWorkRequest); // Ajoute la requête à la liste globale
    }

    private ArrayList<Travaux> fetchAllTravaux() {
        ArrayList<Travaux> travauxList = new ArrayList<>();
        HttpClientApi api = new HttpClientApi();
        String resourceIdTravaux = "cc41b532-f12d-40fb-9f55-eb58c9a2b12b"; // ID des travaux

        ApiResponse responseTravaux = api.getData(resourceIdTravaux);

        if (responseTravaux != null && responseTravaux.getStatusCode() == 200) {
            try {
                JsonArray records = jsonParsing(responseTravaux);
                for (int i = 0; i < records.size(); i++) {
                    JsonObject record = records.get(i).getAsJsonObject();

                    // Extraction des champs
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

                    Travaux travaux = new Travaux(id, projectId, permitPermitId, contractNumber, boroughId, permitCategory,
                            currentStatus, durationStartDate, durationEndDate, reasonCategory, occupancyName,
                            submitterCategory, organizationName, loadDate, longitude, latitude);
                    travauxList.add(travaux);
                }
            } catch (Exception e) {
                System.err.println("Error parsing JSON: " + e.getMessage());
            }
        } else {
            System.err.println("Failed to retrieve data");
        }
        return travauxList;
    }

/**Afficher tous les projets à partir de l'API
 */
    // Méthode pour afficher les projets dans les trois prochains mois
    public void viewUpcomingProjects() {
        ArrayList<Travaux> travauxList = fetchAllTravaux();
        Date currentDate = new Date();
        Date threeMonthsFromNow = new Date(currentDate.getTime() + (90L * 24 * 60 * 60 * 1000)); // 90 jours

        System.out.println("Projets à venir dans les 3 prochains mois:");
        for (Travaux travaux : travauxList) {
            if (travaux.getDurationStartDate() != null) {
                Date startDate = Travaux.parseDate(travaux.getDurationStartDate());
                if (startDate != null && startDate.after(currentDate) && startDate.before(threeMonthsFromNow)) {
                    System.out.println(travaux.toString());
                }
            }
        }
    }

    // Méthode pour filtrer ou rechercher des travaux par quartier
    public void filterWorkByBorough(String borough) {
        ArrayList<Travaux> travauxList = fetchAllTravaux();
        System.out.println("Travaux dans le quartier " + borough + ":");
        if (borough.equalsIgnoreCase("0")){
            for (Travaux travaux : travauxList) {{
                    System.out.println(travaux.toString());
        }}}
        else {for (Travaux travaux : travauxList) {
            if (borough.equalsIgnoreCase(travaux.getBoroughId())) {
                System.out.println(travaux.toString());
            }
        }
    }}

    /** Récupérer toutes les entraves depuis l'API */
    public List<Entrave> fetchAllEntraves() {
        List<Entrave> entraves = new ArrayList<>();
        HttpClientApi api = new HttpClientApi();
        String resourceIdEntraves = "a2bc8014-488c-495d-941b-e7ae1999d1bd"; // ID API

        ApiResponse responseEntrave = api.getData(resourceIdEntraves);

        if (responseEntrave != null && responseEntrave.getStatusCode() == 200) {
            try {
                JsonArray records = jsonParsing(responseEntrave);

                for (int i = 0; i < records.size(); i++) {
                    JsonObject record = records.get(i).getAsJsonObject();

                    // Récupérer et convertir isArterial
                    boolean isArterial = "t".equals(record.get("isarterial").getAsString());

                    Entrave entrave = new Entrave(
                            record.get("_id").getAsInt(),
                            record.get("id_request").getAsString(),
                            record.get("streetid").getAsString().trim(),
                            record.get("shortname").getAsString().trim(), // Ajout du shortName
                            record.get("streetimpactwidth").getAsString(),
                            record.get("streetimpacttype").getAsString(),
                            record.has("nbfreeparkingplace") && !record.get("nbfreeparkingplace").isJsonNull()
                                    ? Integer.parseInt(record.get("nbfreeparkingplace").getAsString())
                                    : 0,
                            record.get("sidewalk_blockedtype").getAsString(),
                            record.get("bikepath_blockedtype").getAsString(),
                            record.get("fromname").getAsString(),
                            record.get("toname").getAsString(),
                            Double.parseDouble(record.get("length").getAsString()),
                            isArterial // Ajouter isArterial
                    );
                    entraves.add(entrave);
                }

            } catch (Exception e) {
                System.err.println("Error parsing JSON: " + e.getMessage());
            }
        } else {
            System.err.println("Failed to retrieve data: " +
                    (responseEntrave != null ? responseEntrave.getMessage() : "No response"));
        }

        return entraves;
    }

    /** Filtrer les entraves par le nom de la rue */
    public void filterEntraveByRue(String streetName) {
        List<Entrave> allEntraves = fetchAllEntraves();
        System.out.println("Entraves dans la rue" + streetName + ":");

        if (streetName.equalsIgnoreCase("0")){
            for (Entrave entrave : allEntraves) {{
                System.out.println(entrave.toString());
            }}}
        else {
            for (Entrave entrave : allEntraves)
            {
                if (streetName.equalsIgnoreCase(entrave.getShortName())) {
                System.out.println(entrave.toString());
            }
        }}
    }

/**Fonction pour parser le Json
 * @param responseEntrave la réponse de l'API pour les éntraves
 * @return Un array JSON
 */
    public JsonArray jsonParsing(ApiResponse responseEntrave){
        JsonObject rootObject = JsonParser.parseString(responseEntrave.getBody()).getAsJsonObject();
        JsonObject result = rootObject.getAsJsonObject("result");
        return result.getAsJsonArray("records");
    }

    // Méthode pour ajouter un résident (si nécessaire)
    public static void addResident(Resident resident) {
        residents.add(resident);
    }

    // Méthode pour obtenir tous les résidents
    public static List<Resident> getAllResidents() {
        return new ArrayList<>(residents); 
    }
}


