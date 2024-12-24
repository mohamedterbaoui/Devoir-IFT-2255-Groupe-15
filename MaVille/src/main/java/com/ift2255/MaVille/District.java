//District.java
//IFT2255 - Équipe 15
//Classe district

package com.ift2255.MaVille;
/**Classe qui gère les méthodes et attributes pour les districts
 */
public class District {
    int districtId;
    String districtName;
/**Constructeur pour la classe district
 * @param id l'ID pour le district
 * @param name le nom du district
 */
    public District(int id, String name){
        this.districtId = id;
        this.districtName = name;
    }
/**afficher l'ID du district
 * @return l'ID du district
 */
    public int getDistrictId() {
        return districtId;
    }
/**affiche le nom du district
 * @return le nom du district
 */
    public String getDistrictName() {
        return districtName;
    }
/**Changer l'ID du district
 * @param nouveauID nouveau id pour le district
 */
    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
/**Changer le nom du district
 * @param districtName le nouveau nom du district
 */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}
