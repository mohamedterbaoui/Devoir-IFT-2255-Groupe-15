//Initialization.java
//IFT2255 - Équipe 15
//Classe d'initialisation
package com.ift2255.MaVille;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Initialization {
    public static void initialize(AuthController authController) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

             // Initialisation des résidents
             Resident resident1 = new Resident("Alice", "Dupont", dateFormat.parse("1998-10-23"), "alice@mail.com", "password123", "1234567890", "123 Rue A", "Montréal");
             Resident resident2 = new Resident("Bob", "Martin", dateFormat.parse("2000-12-18"), "bob@mail.com", "securepass", "1234567890", "456 Rue B", "Montréal");
             Resident resident3 = new Resident("Caroline", "Lavoie", dateFormat.parse("1956-05-03"), "caroline@mail.com", "pass789", "1234567890", "789 Rue C", "Montréal");
 
             // Ajouter les résidents à la liste de l'authController
             authController.residents.add(resident1);
             authController.residents.add(resident2);
             authController.residents.add(resident3);
 
             // Initialisation des intervenants
             Intervenant intervenant1 = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"), "entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", 101);
             Intervenant intervenant2 = new Intervenant("Entreprise B", "Privé", dateFormat.parse("1965-09-16"), "entrepriseB@mail.com", "securepass", "1234567890", "654 Rue E", "Entrepreneur privé", 102);
             Intervenant intervenant3 = new Intervenant("Entreprise C", "Particulier", dateFormat.parse("1999-07-17"), "entrepriseC@mail.com", "pass789", "1234567890", "987 Rue F", "Particulier", 103);
 
             // Ajouter les intervenants à la liste de l'authController
             authController.intervenants.add(intervenant1);
             authController.intervenants.add(intervenant2);
             authController.intervenants.add(intervenant3);
 
             // Initialisation des requêtes de travail
             Street street1 = new Street(1, "912 Rue F");
             Street street2 = new Street(2, "345 Rue T");
             Street street3 = new Street(3, "567 Rue Y");
 
             WorkRequest workRequest1 = new WorkRequest("Réparation route", "Réparer les nids-de-poule sur la rue principale.", dateFormat.parse("2024-10-30"), "Travaux routiers", street1);
             WorkRequest workRequest2 = new WorkRequest("Panneau stop à ajouter", "Installer un nouveau panneau stop sur la rue", dateFormat.parse("2024-11-15"), "Travaux de signalisation", street2);
             WorkRequest workRequest3 = new WorkRequest("Entretien paysager", "Tailler les arbres et nettoyer les espaces verts.", dateFormat.parse("2024-11-20"), "Entretien paysager", street3);
 
            // Ajout des requêtes à la liste globale
            AuthController.workRequests.add(workRequest1);
            AuthController.workRequests.add(workRequest2);
            AuthController.workRequests.add(workRequest3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

