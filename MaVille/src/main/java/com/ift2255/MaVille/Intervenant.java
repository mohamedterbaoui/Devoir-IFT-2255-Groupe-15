//Intervenant.java
//IFT2255 - Équipe 15
//Fichier pour la classe Intervenant
package com.ift2255.MaVille;

import java.util.LinkedList;
import java.util.Date;

/**Cette class gère les méthodes et ce genre de chose pour l'intérvenant
 */
public class Intervenant extends User{
    private String typeIntervenant;
    /**La matricule de l'intervenant*/
    private int cityId;
    /**Une liste chaîné des requêtes de travail*/
    private LinkedList<WorkRequest> workRequests;
    /**Une liste chaîné des projets*/
    private LinkedList<Project> projects;

/**Le constructeur pour la classe intérvenant.
 * @param firstName le prénom de l'intérvenant
 * @param lastName le nom de famille de l'intérvenant
 * @param birthDate la date de naissaiance de l'intérvenant
 * @param email L'adresse courriel de l'intérvenant
 * @param password le mot de passe (SHA-256) de l'intérvenant
 * @param phone Le numéro de téléphone pour l'intérvenant
 * @param userAddress l'adresse de l'intérvenant
 * @param typeIntervenant le type d'intérvenant
 * @param cityId La matricule de l'intérvenant
 */
    public Intervenant(String firstName, String lastName, Date birthDate, String email, String password, String phone, String userAddress, String typeIntervenant, int cityId) {
        super(firstName, lastName, birthDate, email, password, phone, userAddress);
        this.typeIntervenant = typeIntervenant; 
        // Vérification si cityId est valide
        if (cityId <= 0) {
            throw new IllegalArgumentException("cityId doit être supérieur à 0");
        }
        this.cityId = cityId; 
        this.workRequests = new LinkedList<>();
    }

    public void applyToWorkRequest(){
        //fonction
    }

    public void addNewProject(){
        //fonction
    }
    /**Afficher les heures préférées d'un résident pour des projets
     * @param resident Le résident qui nous intéresse
     * return  la liste des préférences pour ce résident
     */
    public LinkedList<String> viewResidentPreferences(Resident resident){
       return(resident.getPreferredProjectTimes());
    }

    public void editProjectDetails(Project project){
        //fonction
    }


    //getters
    /**Afficher le type d'intérvenant
     * @return un string avec le type d'intérvenant
     */
    public String getTypeIntervenant() {
        return typeIntervenant;
    }
    /**Chercher la matricule de l'intérvenant
     * @return la matricule donné par la ville de l'intérvenant
     */
    public int getCityId() {
        return cityId;
    }
/**Affiche les projets de l'intérvenant
 *@return Les projets de l'intérvenant
    public LinkedList<Project> getProjects() {
        return projects;
    }
/**Afficher les requêtes de travail de l'intérvenant
 * @return une liste chaîné des requêtes de travail
 */
    public LinkedList<WorkRequest> getWorkRequests() {
        return workRequests;
    }

    // setters
    /**changer la matricule de l'intérvenant
     * @param cityId le nouveau matricule
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
/**Changer la liste de projets pour cet intérvenant
 * @param projects le nouveau liste de projets
 */
    public void setProjects(LinkedList<Project> projects) {
        this.projects = projects;
    }
  /**Changer le type d'intérvenant
   * @param typeIntervenant le nouveau type d'intérvenant
   */  
    public void setTypeIntervenant(String typeIntervenant) {
        this.typeIntervenant = typeIntervenant;
    }
/**remplacer la liste de requêtes de travail avec une nouvelle liste
 * @param workRequests la nouvelle liste chaînée de requêtes
 */
    public void setWorkRequests(LinkedList<WorkRequest> workRequests) {
        this.workRequests = workRequests;
    }
    
}
