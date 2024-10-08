//Menu.java
//IFT2255 - Équipe 15
//Classe qui gère le menu
import menuItems.*;
import usagers.*;
import java.util.Arrays;

public class Menu {
    //metadonnées pour le constructeur
    int[] coord = new int[]{0,0,0};  //coordonnées de chaque item
    //les noms pour chaque item
    //On peut changer le nom pour chaque item en changant les noms ici. C'est structuré
    //de la même façon que le menu.
    //Les enfants par exemple nomItemsNiveau1[0] correspond aux enfants de NomItemsNiveau0[0][0]
    //ou les enfants de nomItemsNiveau1[0][0] sont dans nomItemsNiveau2[0][0].
    String[][] nomItemsNiveau0 = new String[][]{{
            "Consulter les travaux en cours ou à venir",
            "Participer à la planification des travaux",
            "Gérer ses notifications",
            "Soumettre une requête de travail",
            "Signaler un problème à la ville"}};
    String[][] nomItemsNiveau1 = new String[][]{
            {"Filtrer la recherche", "Recherche Avancée"}
            ,{"Ajouter des préférences de travaux", "Modifier ses préférences"},
            {"Modifier ses notifications"},
            {"Ajouter une requête de travail", "Modifier une requête de travail"},
            {"Remplir le formulaire de signalement"}
    };
    String[][][] nomItemsNiveau2 = new String[][][]{
            {
        {},
        {}
            },
            {
        {},{}
            },
            {
                    {}
            },
            {
                    {},{}
            },
            {
                    {}
            }
    };


    String[][] subMenuInt0 = new String[][]{{
        "Consulter la liste des requêtes de travail",
        "Consulter la liste des travaux",
        "Soumettre un nouveau projet de travail"
    }};
    String[][] subMenuInt1 = new String[][]{
            {},
            {},
            {}
    };
    String[][][] subMenuInt2 = new String[][][]{{},{},{}};
    //pointeurs vers les items
    Item itemActuel; //l'item selectionné par l'usager
    Item racine = null;     // première élément du menu
    Resident resActuel;     // L'utilisateur qui s'est connecté
    Intervenant intActuel; // l'intervenant qui s'est connecté

    Menu(Resident resActuel) { //constructeur
        this.resActuel = resActuel;
        //0e niveau
        racine = new Item("Menu principale",null);
        this.itemActuel = this.racine;
        //1e niveau
        for(int i=0;i < nomItemsNiveau0[0].length; i++){
            //créer le nouveau item
            Item nouveauEnfant = new Item(nomItemsNiveau0[0][i], racine);
            //et l'envoyé a la racine
            racine.ajouterEnfant(nouveauEnfant);
        }
        // 2e niveau
        for(int i=0; i < nomItemsNiveau1.length; i++){
            Item itemActuel = this.getItem(new int[]{i},racine);
            for (int j = 0; j < nomItemsNiveau1[i].length; j++){
                Item nouveauEnfant = new Item(nomItemsNiveau1[i][j], itemActuel);
                itemActuel.ajouterEnfant(nouveauEnfant);
            }
        }
        //3e niveau? Il est fort possible qu'on doit modifier cette partie en particulaire...
        //Pour le moment, on n'a que des items vides. On peut le remplacer par peut être un
        //tableau des objets "item" qui ont plus de fonctionalités.
        //
        //Il y a probablement aussi un façon plus simple pour le faire
        //avec un algorithme recursive...
        for(int i=0; i< nomItemsNiveau2.length; i++){
            //chercher le iem enfant à partir du racine
            for(int j=0; j < nomItemsNiveau2[i].length; j++){
                Item itemActuel = this.getItem(new int[]{i,j}, racine);
                for(int k=0; k < nomItemsNiveau2[i][j].length; k++){
                    Item nouveauEnfant = new Item(nomItemsNiveau2[i][j][k],itemActuel);
                    itemActuel.ajouterEnfant(nouveauEnfant);
                }
            }
        }
    }

    Menu(Intervenant intActuel){
        this.intActuel = intActuel;
        //0e niveau
        racine = new Item("Menu principale",null);
        this.itemActuel = this.racine;
        //1e niveau
        for(int i=0;i < subMenuInt0[0].length; i++){
            //créer le nouveau item
            Item nouveauEnfant = new Item(subMenuInt0[0][i], racine);
            //et l'envoyé a la racine
            racine.ajouterEnfant(nouveauEnfant);
        }
        // 2e niveau
        for(int i=0; i < subMenuInt1.length; i++){
            Item itemActuel = this.getItem(new int[]{i},racine);
            for (int j = 0; j < subMenuInt1[i].length; j++){
                Item nouveauEnfant = new Item(subMenuInt1[i][j], itemActuel);
                itemActuel.ajouterEnfant(nouveauEnfant);
            }
        }
        //3e niveau? Il est fort possible qu'on doit modifier cette partie en particulaire...
        //Pour le moment, on n'a que des items vides. On peut le remplacer par peut être un
        //tableau des objets "item" qui ont plus de fonctionalités.
        //
        //Il y a probablement aussi un façon plus simple pour le faire
        //avec un algorithme recursive...
        for(int i=0; i< subMenuInt2.length; i++){
            //chercher le iem enfant à partir du racine
            for(int j=0; j < subMenuInt2[i].length; j++){
                Item itemActuel = this.getItem(new int[]{i,j}, racine);
                for(int k=0; k < subMenuInt2[i][j].length; k++){
                    Item nouveauEnfant = new Item(subMenuInt2[i][j][k],itemActuel);
                    itemActuel.ajouterEnfant(nouveauEnfant);
                }
            }
        }
    }

    //getters
    public Item getActuel(){
        return this.itemActuel;
    }

    public Item getItem(int[] chemin, Item debutDeRecherche){
        //si le tableau est vide, on retourne l'item de debut
        if(chemin.length == 1){
            return debutDeRecherche.getChild(chemin[0]);

        } else {//sinon, on retourne l'enfant qui correspond au premier
            //position du chemin et on recommence le recherche.
            return this.getItem(Arrays.copyOfRange(chemin, 1, chemin.length),
                    debutDeRecherche.getChild(chemin[0]));
        }
    }
    public Resident getResActuel(){
        return this.resActuel;
    }

    public Intervenant getIntActuel(){
        return this.intActuel;
    }

    public Item getRacine(){
        return this.racine;
    }

    //setters
    public void setActuel(Item item){
        this.itemActuel = item;
    }
}
