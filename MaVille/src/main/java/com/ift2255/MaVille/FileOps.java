//FileOps.java
//IFT2255 - Équipe 15
//Classe qui gère la lecture et l'écriture des fichiers

package com.ift2255.MaVille;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**Classe java qui a des méthodes pour gérer accès aux fichiers
 */
public class FileOps {
	/**
	 * Méthode pour sauvgarder les données dans un fichier
	 * @param Data Les données à écrire
	 * @param NomDuFichier le chemin vers le fichier
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
	 * @return tout le contenu d'un fichier
	 * @param nomDuFicher chemin vers le fichier
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
	

    public static final String PROJECTS_FILE = "projects.dat";
    public static final String WORK_REQUESTS_FILE = "workrequests.dat";

    public static <T extends Serializable> void saveToFile(List<T> objects, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    public static <T extends Serializable> List<T> loadFromFile(String filename) {
        List<T> objects = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            objects = (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading from file: " + e.getMessage());
            // Handle the case where the file doesn't exist – return an empty list
        }
        return objects;
    }		
		
				

	public static void main(String[] args){
		saveFileData(args[0], args[1]);
		System.out.println(getFileData(args[1]));
	}
}
		



	
