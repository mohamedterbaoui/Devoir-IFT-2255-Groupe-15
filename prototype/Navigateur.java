//Navigateur.jav)a
//IFT2255 - Groupe 15
//Cette classe sert à gérer la navigation dans le système des menus


// à faire : itemActuel et Racine doit être remplacés par les
// appels pour menu.getRacine()
// pour préserver l'encapsulation
import java.util.Scanner;
import menuItems.*;
import usagers.*;
public class Navigateur{
    //déclarations
    private Item itemActuel; //Item actuellement séléctionné
    //private Item racine;     //Il se peut que cela n'est pas necessaire... à suivre
    private Menu m;
    Scanner scn = new Scanner(System.in);
    Resident resActuel;
    Intervenant intActuel;

    //méthodes
    public Navigateur(Resident resActuel){

        m = new Menu(resActuel);
        //racine = m.getRacine();
        //itemActuel = racine;
        this.accueil();
    }

    public Navigateur(Intervenant intActuel){
        m = new Menu(intActuel);
        this.accueil();
    }

    public void accueil(){
        //	System.out.println("Bienvenue à l'appliation MaVille");
        System.out.println("Qu'est-ce que nous pouvons faire pour vous\n");
        this.generateReport();
//		this.boucle();

    }

    //getters

    public Item getRacine(){
        return m.getRacine();
    }

    public Resident getResActuel(){
        return m.getResActuel();
    }

    public Item getActuel(){
        return m.getActuel();
    }
    //setters
    public void setActuel(int choix){
        if (choix > this.getActuel().getNombreItems() || choix < 0){
            System.out.println("Veuiller choisir une option valide");
        } else {

            this.setActuel(this.getActuel().getChild(choix - 1));
        }
    }

    public void setActuel(Item item){
        m.setActuel(item);
    }
    //fonctions de parcours
    public void revenirEnArriere(){
        if (this.getActuel() != this.getRacine()){
            m.setActuel(this.getActuel().getParent());
        }

    }

    public void revenirAuDebut(){
        m.setActuel(m.getRacine());
    }


    public void generateReport(){
        System.out.println(this.getActuel());
        System.out.println("x. Sortir");
        System.out.println("d. Revenir au début");
        System.out.println("r. Revenir en arrière");
        System.out.println("Veuiller choisir un option");
        System.out.println("---------------------------------------------------------------------------------------\n");

    }
/*
	public void boucle(){
		while(true){
			String input = scn.nextLine();
				try{
				switch (input) {
					case "x": //sortir
						return;
					case "d": //revenir au début
						this.itemActuel= this.getRacine();
						this.generateReport();
						break;
					case "r": //revenir en arrière
						if(itemActuel.getParent() == null){
							itemActuel = this.getRacine();
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
		*/
}




