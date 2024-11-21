//usagers.java
//IFT2255 - Equipe 15
//La liste des usagers

//Il serait mieux de le mettre dans une arbre binaire de recherche, mais
//je n'ai pas trop envie de le faire. Donc on s'en va comme ça

package usagers;
import java.util.LinkedList;

public class ListeUsagers {
    private LinkedList<Resident> residents = new LinkedList<>();
    private LinkedList<Intervenant> intervenants = new LinkedList<>();
    public ListeUsagers(){
        //création d'utilisateur de teste
        this.ajouterResident("Test","Test",
                "124 boul de la maisoneuve", "test@test.ca","chose");
        this.ajouterIntervenant("Test","Test",
                "124 boul de la maisoneuve", "intervenant@test.ca","admin");
    }
    //methodes

    //Il serait peut-être mieux si on retourne l'objet resident au lieu juste de le stocker.
    //Il est probablement necessaire pour ajouter le no de téléphone au moins.
    public void ajouterResident(String prenom, String nom, String adresse, String courriel, String motDePasse){
        residents.add(new Resident(prenom,nom,adresse,courriel,motDePasse));
    }
    public void ajouterIntervenant(String prenom, String nom, String adresse, String courriel, String motDePasse){
        intervenants.add(new Intervenant(prenom,nom,adresse,courriel,motDePasse));
    }
    //méthode on a utiliser pour se connecter
    public Resident chercherResident(String courriel){
        for (Resident resident : residents){
            if (resident.getCourriel().equals(courriel)){
                return resident;
            }

        }
        return null;
    }

    public Intervenant chercherIntervenant(String courriel){
        for (Intervenant intervenant : intervenants){
            if (intervenant.getCourriel().equals(courriel)){
                return intervenant;
            }

        }
        return null;
    }

    //methode d'authentication
    //Il se peut que ça va lancer un "NUll Pointer exception"
    //si l'utilisateur n'est pas trouvé. Je veux le gèrer ailleurs
    public Resident AuthenticationResident(String courriel, String motDePasse){
        Resident ceResident = this.chercherResident(courriel);
        try{
            if(ceResident.verifierMotDePasse(motDePasse)){
                return ceResident;
            } else {
                return null;
            }
        } catch (NullPointerException e){
            return null;
        }
    }
    public Intervenant AuthenticationIntervenant(String courriel, String motDePasse){
        Intervenant cetIntervenant = this.chercherIntervenant(courriel);
        try{
            if(cetIntervenant.verifierMotDePasse(motDePasse)){
                return cetIntervenant;
            } else {
                return null;
            }
        } catch (NullPointerException e){
            return null;
        }
    }
}

