//User.java
//IFT2255 - Équipe 15
//Class pour le type User
package com.ift2255.MaVille;
import java.util.Date;
import java.text.SimpleDateFormat;

/**Classe générique qui gère les utilisateurs
 */
public class User {
    /**Le formatter pour les dates*/
    SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");

/**Prénom de l'utilisateur
 */
    protected String firstName;
   /**Nom de famille de l'utilisateur*/
    protected String lastName;
    /**Date de naissance de l'utilisateur*/
    protected Date birthDate;
    /**Adresse courriel de l'utilisateur*/
    protected String email;
    /**Mot de passe de l'utilisateur*/
    protected String password;
    /**No de téléphone de l'utilisateur*/
    protected String phone;
    /**Adresse d'utilisateur*/
    protected String userAddress; //on a probablement besoin d'un autre object d'adresse au lieu d'utiliser un String
    
    /**Constructeur pour l'objet d'utilisateur. Avec un numéro de téléphone
     * @param firstName Prénom de l'utilisateur
     * @param lastName Nom de famille de l'utilisatuer
     * @param birthDate Date de naissance de l'utilisateur
     * @param email Adresse courriel d'utilisatuer
     * @param password Mot de passe d'utilisateur
     * @param phone no de téléphone d'utilisateur
     * @param userAddress adresse physique de l'utilisateur
     */
    public User(String firstName, String lastName, Date birthDate, String email, String password, String phone, String userAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userAddress = userAddress;
    }
    /**Constructeur pour l'objet d'utilisateur. Avec un numéro de téléphone
     * @param firstName Prénom de l'utilisateur
     * @param lastName Nom de famille de l'utilisatuer
     * @param birthDate Date de naissance de l'utilisateur
     * @param email Adresse courriel d'utilisatuer
     * @param password Mot de passe d'utilisateur
     * @param userAddress adresse physique de l'utilisateur
     */
    public User(String firstName, String lastName, Date birthDate, String email, String password, String userAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.userAddress = userAddress;
    } 

    //methodes
    /**Cherche a savoir si la personne a plus que 18 ans
     * @return True si la personne est adulte
     */
    public boolean isAdult(){
        return (this.getAge() >= 18);
    }
    /**Calcul de l'age de la personne
     * @return l'age de la personne
     */
    public int getAge(){
        return 19;
        //on doit modifier le fonction eventuellement pour calculer l'age
        //à partir de la date d'aujourd'hui 
    }
   
    //getters
    /**Afficher le mot de passe pour le comparison
     * @return le mot de passe de l'utilisateur
     */
    public String getPassword(){return this.password;};
    /**retourn le prénom de la personne
     * @return prénom de l'utilisateur
     */
    public String getFirstName(){return this.firstName;}

    /**retourn le nom de famille de la personne
     * @return nom de famille de l'utilisateur
     */
    public String getLastName(){return this.lastName;}

    /**Retourne le nom de la personne
     * @return nom de la personne
     */
    public String getName(){
        String name = firstName + " " + lastName;
        return name;
    } 
    /**Retourne la date de naissance de la personne
     * @return date de naissance
     */
    public Date getBirthDate(){return this.birthDate;}
    /**
     * return l'adresse courriel de l'utilisateur
     * @return adresse courriel
     */
    public String getEmail(){return this.email;}
    
    /**Returne le no de téléphone de l'utilisateur
     * @return No de téléphone
     */
    public String getPhone(){return phone;}
    
    /**returne l'adresse de l'utilisateur
     * @return adresse de l'utilisateur
     */
    public String getUserAddress(){return userAddress;}

// setters
    /**Changer le prénom de l'utilisateur
     * @param firstName nouveau prénom
     */
    public void setFirstName(String firstName){this.firstName = firstName;}
/** Changer le nom de famille de l'utilisateur
 * @param lastName nouveau nomDeFamille
 */
    public void setLastName(String lastName){this.lastName = lastName;};
/**Changer la date de naissance
 * @param birthDate nouveau date de naissance
 */
    public void setBirthDate(Date birthDate){this.birthDate = birthDate;}
/**Changer l'adresse courriel de l'utilisateur
 * @param email nouveau adresse courriel
 */
    public void setEmail(String email){this.email = email;}
/**changer le mot de passe de l'utilisateur
 * @param password nouveau mot de passe
 */
    public void setPassword(String password){this.password = password;}
/**changer le no de téléphone de l'utilisateur
 * @param nouveau no de téléphone
 */
    public void setPhone(String phone){this.phone = phone;}
/**changer l'adresse de l'utilisateur
 * @param adresse nouveau adresse
 */
    public void setUserAddress(String address){this.userAddress = address;}


    
}
