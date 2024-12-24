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
	 * @param data Les données à écrire
	 * @param nomDuFichier le chemin vers le fichier
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
	 * @param nomDuFichier  chemin vers le fichier
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
	/**
	 * Sauvegarde une liste d'objets sérialisés dans un fichier.
	 * Cette méthode ouvre un flux d'écriture d'objets, sérialise la liste d'objets et l'enregistre dans le fichier spécifié.
	 * En cas d'erreur lors de la sauvegarde, un message d'erreur est affiché.
	 *
	 * @param <T> le type des objets contenus dans la liste, qui doit implémenter l'interface {@link Serializable}.
	 * @param objects la liste d'objets à sauvegarder dans le fichier.
	 * @param filename le nom du fichier où les objets seront enregistrés.
	 */

    public static <T extends Serializable> void saveToFile(List<T> objects, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
	/**
	 * Charge une liste d'objets sérialisés à partir d'un fichier.
	 * Cette méthode ouvre un flux de lecture d'objets, lit la liste d'objets sérialisés et la retourne.
	 * En cas d'erreur de lecture (fichier inexistant ou format incorrect), une liste vide est retournée.
	 *
	 * @param <T> le type des objets contenus dans la liste, qui doit implémenter l'interface {@link Serializable}.
	 * @param filename le nom du fichier à partir duquel les objets sont chargés.
	 * @return une liste d'objets chargés depuis le fichier, ou une liste vide en cas d'erreur.
	 */

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

	/**
	 * Point d'entrée principal de l'application. Cette méthode reçoit les arguments de la ligne de commande,
	 * enregistre les données dans un fichier et affiche le contenu du fichier.
	 *
	 * @param args les arguments passés lors de l'exécution de l'application.
	 *             `args[0]` représente la source des données à enregistrer, et `args[1]` le fichier dans lequel les données seront stockées.
	 */

	public static void main(String[] args){
		saveFileData(args[0], args[1]);
		System.out.println(getFileData(args[1]));
	}
}
		



	
