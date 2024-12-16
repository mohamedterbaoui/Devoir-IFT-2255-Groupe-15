//Notifications.java
//IFT2255 - Équipe 15
//Controlleur pour les notifications
package com.ift2255.MaVille;

import java.util.LinkedList;

/**Classe qui gère une liste chaîné avec des notifications pour
 * un résident*/

public class Notifications {
	private LinkedList<Notification> notifications;
	
	/**Constructeur sans déclaration de résident
	 */
	public Notifications(){
		this.notifications = new LinkedList<>();
	}

	/**Ajouter une notification
	 * @param notification Le nouveau objet de notification
	 */
	public void addNotification(Notification notification){
		notifications.add(notification);
	}

	/**Afficher l'i-ème notification
	 * @param i l'index de notification
	 */
	public Notification getNotificationsByIndex(int i){
		return notifications.get(i);
	}

	/**Afficher les nouveaux notifications
	 * @return un autre objet Notifications qui ne contient que des nouveaux notifications
	 */

	public Notifications getNewNotifications(){
		Notifications newNotifications = new Notifications();
		for(Notification notification : notifications){
			if(!notification.getRead()){
				newNotifications.addNotification(notification);
			}
		}

		return newNotifications;
	}



/**Le fonction qui imprime les titres des notifications
 * @return String qui contient les titres de chaque notification
 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if (notifications.size() == 0){
			return "Vous n'avez aucune notification";
		}
		else{
			for (int i=0; i < notifications.size(); i++){
				
				if (!notifications.get(i).getRead()){
					sb.append(". * ");
				}

				sb.append(notifications.get(i).getTitle());
				sb.append("\n");
			}
		}

		return sb.toString();
	}

} 


				

			