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
		    hexString.append(String.format("%02x", 0xFF & digest[i]));
	    }

	    return hexString.toString();
	}

	public static void main(String[] args){
		System.out.println(args[0]);
		try{
			System.out.println(hasher(args[0]));
	} catch (Exception e){
	}
	}


}

