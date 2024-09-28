//Navigateur.java
//IFT2255 - Groupe 15
//Cette classe sert à gérer la navigation dans le système des menus

import java.util.Scanner;

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
		this.boucle();

	}

	public void setActuel(int choix){
		this.itemActuel = itemActuel.getChild(choix - 1);
	}

	public void boucle(){
		while(true){
			String str = scn.nextLine();
			switch (str) {
				case "x":
					break;
				case "r":
					itemActuel = racine;
				default : 
					int sel = Integer.parseInt(str); //convertir en intéger
								     //pour trouver la séléction
					this.setActuel(sel);
					System.out.println(itemActuel);
			}
		}
	}
	
}
