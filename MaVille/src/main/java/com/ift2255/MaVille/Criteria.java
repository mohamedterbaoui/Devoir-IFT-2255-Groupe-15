//Criteria.java
//IFT2255 - Équipe 15
//Classe Criteria
package com.ift2255.MaVille;
import java.util.Date;
public class Criteria {
    String searchName;
    ProjectType projectType;
    District district;
    Date startDate;
    Date endDate;
/**Le constructeur pour la classe de critéria
 * @param nom le nom pour le critéria
 * @param type le type de projet
 * @param district Le district pour le projet
 * @param startDate la date de début
 * @param endDate la date de fin
 */
    public Criteria(String name, ProjectType type, District district, Date startDate, Date endDate){
        this.searchName = name;
        this.projectType = type;
        this.district = district;
        this.startDate = startDate;
        this.endDate = endDate;
    }
/**Affiche le district
 * @return le district associé à ce critéria
 */
    public District getDistrict() {
        return district;
    }
  /**afficher la date de fin
   * @return la date de fin
   */  
    public Date getEndDate() {
        return endDate;
    }
/**Affiche le type de projet
 * @return le type de projet
 */
    public ProjectType getProjectType() {
        return projectType;
    }
/**afficher le nom de la recherche
 * @return le nom de la recherche
 */
    public String getSearchName() {
        return searchName;
    }
/**Afficher la date de début
 * @return le nouveau date de début
 */
    public Date getStartDate() {
        return startDate;
    }
/**Changer le district
 * @param district le district pour les travaux
 */
    public void setDistrict(District district) {
        this.district = district;
    }
/**Changer la date de fin
 * @param endDate la date de fin
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
/** Changer le type de projet
 * @param projectType le type de projet
 */
    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
/**Changer le nom de la recherche
 * @param searchName le nouveau nom pour la recherche
 */
    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
/** Changer la date de début
 * @param startDate nouvelle date de début
 */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
}
