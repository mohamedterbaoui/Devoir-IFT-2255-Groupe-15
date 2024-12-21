package com.ift2255.MaVille;
/**Classe que gère la classe Street
 */
public class Street {
    int streetID;
    String streetName;
/**Constructeur de Street
 * @param id id de cette rue
 * @param nom nom de la rue
 */
    public Street(int id, String name){
        this.streetID = id;
        this.streetName = name;
    }
/** Afficher l'ID de la rue
 * @return ID de la rue
 */
    public int getStreetID() {
        return streetID;
    }
    /**Afficher le nom de la rue
     * @return le nom de la rue
     */
    public String getStreetName() {
        return streetName;
    }
/**Changer l'ID de la rue
 * @param streetID nouveau ID
 */
    public void setStreetID(int streetID) {
        this.streetID = streetID;
    }
/**Changer le nom de la rue
 * @param streetName Le nouveau nom
 */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    // Pour affichage 
    @Override
    public String toString() {
        return streetName; 
    }
}
