//Menu.java
//IFT2255 - Équipe 15
//Classe qui gère le menu
import java.util.Arrays;
public class Menu {
	//metadonnées pour le constructeur
	int[] coord = new int[]{0,0,0};  //coordonnées de chaque item
	//les noms pour chaque item
	String[][] nomsItems= new String[][]{{"Menu principle"},{"Option 1","Option 2"},{"Option a", "Option b", "Option c"}};
	String[][] nomItemsNiveau0 = new String[][]{{"Option 1", "Option 2"}};
	String[][] nomItemsNiveau1 = new String[][]{{"Option A", "Option B", "Option C"},{"Option D","Option E","Option F"}};
	String[][] nomItemsNiveau2 = new String[][]{{}};
	//pointeurs vers les items
	Item itemActuel; //l'item selectionné par l'usager
	Item racine = null;     // première élément du menu
	//
	Menu() { //constructeur
		//0e niveau
		racine = new Item("Menu principle",null);
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

	public Item getRacine(){
		return this.racine;
	}


	
	
}
