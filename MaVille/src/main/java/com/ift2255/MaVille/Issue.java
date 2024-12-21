//Issue.java
//IFT2255 - Équipe 15
// Classe issue
package com.ift2255.MaVille;
import java.util.Date;
/**Classe qui gère les issues
 */
public class Issue {
    String issueType;
    String description;
    Date sendingDate;
  /**Constructeur pour la classe Issue
   * @param issueType La type d'issue
   * @param description La déscription de l'issue
   * @param sendingDate date d'envoie
   */  
    public Issue(String issueType, String description, Date sendingDate){
        this.issueType = issueType;
        this.description = description;
        this.sendingDate = sendingDate;
    }
/**Afficher la déscription
 * @return la éscription de la problème
 */
    public String getDescription() {
        return description;
    }
  /**Chercher le type de problème
   * @return Le type de problème
   */
    public String getIssueType() {
        return issueType;
    }
/**Afficher la date d'envoie
 * @return la date d'envoie
 */
    public Date getSendingDate() {
        return sendingDate;
    }
/**Changer le déscription du problème
 * @param description Le nouveau description
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**Changer la type de problème
 * @param issueType le type de problème
 */
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }
/**Changer la date d'envoie
 * @param sendingDate Nouvelle date d'envoie
 */
    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

}
