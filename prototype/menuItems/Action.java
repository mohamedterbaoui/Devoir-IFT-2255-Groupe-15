//Action.java
//IFT2255 - Équipe 15
//Classe qui gère les actions fait par les menu itmes
package menuItems;

public class Action{
	private boolean reponse = false;  // si on a besin d'une réponse
	private String prompt;            // Chose à imprimer 
	private String input;             // Input d'utilisateur

	public Action(boolean reponse, String prompt){
		this.reponse = reponse;
		this.prompt = prompt;
	}

	public String actionDeSortie(){
		return prompt;
	}

	public void actionDEntree(String entree){
		this.input = entree;
	}

	public boolean hasActionDEntree(){
		return reponse;
	}


}
