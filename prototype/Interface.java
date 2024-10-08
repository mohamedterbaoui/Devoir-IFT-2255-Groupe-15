//Interface.java
//IFT2255 - Equipe 15
//L'interface utilisateur pour le logiciel
//(Pour le moment, une partie se trouve dans Navigateur.
//Il faut que ce soit réglé dès qu'on a quelque chose qui fonctionne)

import usagers.*;
import menuItems.*;
import java.util.Scanner;

public class Interface{
    Scanner scn = new Scanner(System.in);
    public Interface(){
        afficherLogo();
        this.accueil();
    }
    ListeUsagers u = new ListeUsagers();
    Navigateur n;
    boolean continuer = true; //signal pour quitter la boucle

    // Affichage de la page d'accueil pour s'inscrire ou se connecter
    public void accueil(){
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("Bienvenue à l'application #MaVille");
        System.out.println("Veuillez choisir une option");
        System.out.println("1. Se connecter comme résident");
        System.out.println("2. Se connecter comme intervenant");
        System.out.println("3. S'inscrire comme résident");
        System.out.println("4. S'inscrire comme intervenant");
        System.out.println("q. Quitter l'application");
        System.out.println("\n---------------------------------------------------------------------------------------");

        String input = scn.nextLine();
        switch(input) {
            case "1":
                this.seConnecterResident();
                break;
            case "2":
                this.seConnecterIntervenant();
                break;
            case "3":
                this.sInscrireResident();
                break;
            case "4":
                this.sInscrireIntervenant();
                break;
            case "q":
                break;
            default:
                System.out.println("L'option que vous avez choisie n'existe pas, veuillez choisir une option valide");
                this.accueil();
        }
    }

    public void seConnecterResident(){
        System.out.println("Adresse Courriel: ");
        String courriel = scn.nextLine();
        System.out.println("Mot de passe : ");
        String motDePasse = scn.nextLine();
        //Demander l'authentication

        Resident resActuel = u.AuthenticationResident(courriel, motDePasse);
        if(resActuel == null){
            System.out.println("Nom d'utilisateur ou mot de passe n'est pas correct");
            this.accueil();
        } else {
            n = new Navigateur(resActuel);
            this.boucle();
        }
    }

    public void seConnecterIntervenant(){
        System.out.println("Adresse Courriel: ");
        String courriel = scn.nextLine();
        System.out.println("Mot de passe : ");
        String motDePasse = scn.nextLine();
        //Demander l'authentication

        Intervenant intActuel = u.AuthenticationIntervenant(courriel, motDePasse);
        if(intActuel == null){
            System.out.println("Nom d'utilisateur ou mot de passe n'est pas correct");
            this.accueil();
        } else {
            n = new Navigateur(intActuel);
            this.boucle();
        }
    }

    public void sInscrireResident(){
        System.out.println("Veuiller saisir les informations suivantes");
        System.out.println("Prenom : ");
        String prenom = scn.nextLine();

        System.out.println("Nom de famille : ");
        String nom = scn.nextLine();

        System.out.println("Adresse : ");
        String adresse = scn.nextLine();

        System.out.println("Courriel");
        String courriel = scn.nextLine();

        System.out.println("Mot de passe");
        String motDePasse = scn.nextLine();

        u.ajouterResident(prenom,nom,adresse,courriel,motDePasse);

        this.accueil();
    }

    public void sInscrireIntervenant(){
        System.out.println("Veuiller saisir les informations suivantes");
        System.out.println("Prenom : ");
        String prenom = scn.nextLine();

        System.out.println("Nom de famille : ");
        String nom = scn.nextLine();

        System.out.println("Adresse : ");
        String adresse = scn.nextLine();

        System.out.println("Courriel");
        String courriel = scn.nextLine();

        System.out.println("Mot de passe");
        String motDePasse = scn.nextLine();

        u.ajouterIntervenant(prenom,nom,adresse,courriel,motDePasse);

        this.accueil();
    }

    public void boucle(){
        while(this.continuer==true){
            Item itemActuel = n.getActuel();
            this.itemActions(itemActuel);
            this.continuer = this.naviguer();
        }
    }

    public void itemActions(Item itemActuel){
        if(itemActuel.hasAction()){
            Action action = itemActuel.getAction();
            System.out.println(action.actionDeSortie());
            if (action.hasActionDEntree()){
                action.actionDEntree(scn.nextLine());
            }
        }
    }

    public boolean naviguer(){
        String input = scn.nextLine();
        try{
            switch(input) {
                case "x": //sortir
                    return false;
                case "d": //revenir au debut
                    n.revenirAuDebut();
                    this.generateOptions();
                    break;
                case "r": //revenir en arrière
                    n.revenirEnArriere();
                    this.generateOptions();
                    break;
                default :
                    int sel = Integer.parseInt(input);
                    n.setActuel(sel);
                    this.generateOptions();
            }
        } catch (NumberFormatException e){
            System.out.println("Veuillez saisir une option valide");
            this.generateOptions();

        }

        return true;
    }

    public void generateOptions(){
        System.out.println(n.getActuel());
        System.out.println("x. Sortir");
        System.out.println("d. Revenir au début");
        System.out.println("r. Revenir en arrière");
        System.out.println("Veuillez choisir une option");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    // Fonction pour afficher le logo #MaVille, static pour pouvoir l'utiliser directement sans creer d'objet interface
    public static void afficherLogo(){
        String[] hashtag = {
            "  #   #   ",
            " #######  ",
            "  #   #   ",
            " #######  ",
            "  #   #   "
        };

        String[] M = {
            "|\\       /|",
            "| \\     / |",
            "|  \\   /  |",
            "|   \\ /   |",
            "|    V    |"
        };

        String[] A = {
            "    /\\    ",
            "   /  \\   ",
            "  /----\\  ",
            " /      \\ ",
            "/        \\"
        };

        String[] V = {
            "\\        /",
            " \\      / ",
            "  \\    /  ",
            "   \\  /   ",
            "    \\/    "
        };

        String[] I = {
            "  -----   ",
            "    |     ",
            "    |     ",
            "    |     ",
            "  -----   "
        };

        String[] L = {
            "|         ",
            "|         ",
            "|         ",
            "|         ",
            "|_______  "
        };

        String[] E = {
            " _______  ",
            "|         ",
            "|______   ",
            "|         ",
            "|_______  "
        };

        System.out.println("---------------------------------------------------------------------------------------");
        // combiner toutes les lettres
        for (int i = 0; i < M.length; i++) {
            System.out.println(hashtag[i] + "  " + M[i] + "  " + A[i] + "  " + V[i] + "  " + I[i]
                    + "  " + L[i] + "  " + L[i] + "  " + E[i]);
        }
    }
}
