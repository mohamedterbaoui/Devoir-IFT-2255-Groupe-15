//FileOps.java
//IFT2255 - Équipe 15
//Classe qui gère la lecture et l'écriture des fichiers

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**Classe java qui a des méthodes pour gérer accès aux fichiers
 */
public class FileOps {
	/**
	 * Méthode pour sauvgarder les données dans un fichier
	 * @param String qui contient des données
	 * @param String qui contien le chemin vers le fichier
	 */
	public static void saveFileData(String data, String nomDuFichier){
		try{
			FileWriter fw = new FileWriter(nomDuFichier);
			fw.write(data);
			fw.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	/**Méthode pour chercher des données à partir d'un fichier
	 * @return String qui contient tout le contenu d'un fichier
	 * @param String chemin vers le fichier
	 */
	public static String getFileData(String nomDuFichier){
		Path path = Paths.get(nomDuFichier);
		try { 
			return(Files.readString(path));
		} catch (Exception e) {
			e.printStackTrace();
			return("File not found");
		}
	}
	

			
		
				

	public static void main(String[] args){
		saveFileData(args[0], args[1]);
		System.out.println(getFileData(args[1]));
	}
}
		



	
