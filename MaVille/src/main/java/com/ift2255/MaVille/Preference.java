//Preference.java
//IFT2255 - Équipe 15
//Classe pour les préférences 
package com.ift2255.MaVille;
/**Classe qui gère les préférences pour un utilisateur
 */
public class Preference {
    int preferenceId;
    String schedule;
  /**Constructeur pour les préférences
   * @param id L'id de préférence
   * @param schedule L'horaire pour les travaux
   */  
    public Preference(int id, String schedule){
        this.preferenceId = id;
        this.schedule = schedule;
    }

    public Preference(String schedule){
        this.schedule = schedule;
    }
/** Afficher l'id de la préférence
 * @return l'ID de la préférence
 */
    public int getPreferenceId() {
        return preferenceId;
    }
/**Afficher l'horaire de la préférence
 * @return L'horaire préfére
 */
    public String getSchedule() {
        return schedule;
    }
/**Changer l'ID pour le préférence
 * @param preferenceId le nouveau préférence id
 */
    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }
/**changer l'horaire de ce préférence
 * @param schedule la nouvelle préfèrence
 */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public String toString(){
        return this.schedule;
    }
}
