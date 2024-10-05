//Item.java
//IFT2255 - Équipe 15
//Cette classe crée les nouveaux Items
package menuItems;

import java.util.LinkedList;
public class Item{
	//déclarations
	int niveau; //le niveau d'embriquation du menu
	int id;     //l'index de ces items
	String nom; //nom d'item
	String[][] items; //tout le structure du menu
	Action action = null;
	//pointeurs
	Item parent = null; //pour revenir en arrière 
	LinkedList<Item> listeDItems = new LinkedList<Item>();
	//methodes
	public Item(String titre, Item parent){ //constructeur
		this.nom = titre;
		this.parent = parent;
		
	}
	//getters
	public int getNiveau(){
		return this.niveau;
	}

	public int getID(){
		return this.id;
	}

	public String getNom(){
		return this.nom;
	}

	public Item getChild(int n){
		if(listeDItems.size() == 0){
			return null;
		} else{
			return listeDItems.get(n);
		}
	}

	public int getNombreItems(){
		return listeDItems.size();
	}

	public Item getParent(){
		return this.parent;
	}

	public Action getAction(){
		return this.action;
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		for(int i=0;i < listeDItems.size(); i++){
			str.append(i+1); //nombre d'Item
			str.append(". ");
			str.append(this.getChild(i).getNom());
			str.append("\n");
		}
		return str.toString();
	}
	//setters
	public void setAction(Action action){
		this.action = action;
	}

	//autres choses
	public void ajouterEnfant(Item newItem){
		//ce methode sert à ajouter des nouveaux enfants à la liste
		listeDItems.add(newItem);	
	}

	public boolean hasAction(){
		return(this.action != null);
	}	
}

