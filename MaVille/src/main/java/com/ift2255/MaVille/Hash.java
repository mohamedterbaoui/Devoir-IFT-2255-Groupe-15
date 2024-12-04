//Hash.java
//IFT2255 - Équipe 15
//Fichier qui gère les méthodes pour faire un hash d'un String
import java.security.MessageDigest;
/**
 * Cette classe sert à créer un hash SHA-256 du mot de passe
 * @author IFT2255 - Équipe 15
 */
class Hash{
	/**
	 * Cette méthode est la seule méthode de la classe "Hash"
	 * Il accepte un string et retourne le SHA-256 de l'input
	 */
	public static String hasher(String input) throws Exception{
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(input.getBytes());

	    byte[] digest = md.digest();

	    StringBuffer hexString = new StringBuffer();

	    for (int i = 0; i<digest.length;i++) {
		    hexString.append(Integer.toHexString(0xFF & digest[i]));
	    }

	    return hexString.toString();
	}

}

