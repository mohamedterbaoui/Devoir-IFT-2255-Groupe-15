//Navigateur.java
//IFT2255 - Groupe 15
//Cette classe sert à gérer la navigation dans le système des menus

import java.util.Scanner;
import menuItems.*;

public class Navigateur{
	//déclarations
	Item itemActuel; //Item actuellement séléctionné
	Item racine;     //Il se peut que cela n'est pas necessaire... à suivre
	Menu m;
	Scanner scn = new Scanner(System.in);

	//méthodes
	public Navigateur(){
		m = new Menu();
		racine = m.getRacine();
		itemActuel = racine;
		this.accueil();
	}

	public void accueil(){
		System.out.println("Bienvenue à l'appliation MaVille");
		System.out.println("Qu'est-ce que nous pouvons faire pour vous\n");
		this.generateReport();
		this.boucle();

	}

	public void setActuel(int choix){
		if (choix > itemActuel.getNombreItems() || choix < 0){
			System.out.println("Veuiller choisir une option valide");
		} else {

		this.itemActuel = itemActuel.getChild(choix - 1);
		}
	}

	public Item getActuel(){
		return this.itemActuel;
	}

	public void generateReport(){
		System.out.println(this.getActuel());
		System.out.println("x. Sortir");
		System.out.println("d. Revenir au début");
		System.out.println("r. Revenir en arrière");
		System.out.println("Veuiller choisir un option");

	}

	public void boucle(){
		while(true){
			String input = scn.nextLine();
				try{
				switch (input) {
					case "x": //sortir
						return; 
					case "d": //revenir au début
						itemActuel = racine;
						this.generateReport();
						break;
					case "r": //revenir en arrière
						if(itemActuel.getParent() == null){
							itemActuel = racine;
						} else {
							itemActuel = itemActuel.getParent();
						}
						this.generateReport();
						break;
					default : 
						int sel = Integer.parseInt(input); //convertir en intéger
									     //pour trouver la séléction
						this.setActuel(sel);
						this.generateReport();
				}
				} catch (NumberFormatException e) {
					System.err.println("Veuiller saisir une option valide");
					this.generateReport();
				}
			}
		}
	}

	
	

