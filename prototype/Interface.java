//Interface.java
//IFT2255 - Equipe 15
//L'interface utilisateur pour le logiciel
//(Pour le moment, une partie se trouve dans Navigateur.
//Il faut que ce soit réglé dès qu'on a quelque chose qui fonctionne)

import usagers.*;
import java.util.Scanner;

public class Interface{
	Scanner scn = new Scanner(System.in);
	public Interface(){
		this.accueil();
	}
	Usagers u = new Usagers();

	public void accueil(){
		System.out.println("Bienvenue à l'application #MaVille");
		System.out.println("Veullez choisir une option");
		System.out.println("1. Se connecter");
		System.out.println("2. S'inscrire");

		String input = scn.nextLine();
		switch(input) {
			case "1":
				this.seConnecter();	
			case "2":
				//s'inscrire

		}
	} 

	public void seConnecter(){
		System.out.println("Adresse Courriel: ");
		String courriel = scn.nextLine();
		System.out.println("Mot de passe : ");
		String motDePasse = scn.nextLine();
		//Demander l'authentication
	
		Resident resActuel = u.Authentication(courriel, motDePasse);
		if(resActuel == null){
			System.out.println("Nom d'utilisateur ou mot de passe n'est pas correct");
			this.accueil();
		} else {
			Navigateur n = new Navigateur(resActuel);
		}	
		
	} 	

	

}

	
