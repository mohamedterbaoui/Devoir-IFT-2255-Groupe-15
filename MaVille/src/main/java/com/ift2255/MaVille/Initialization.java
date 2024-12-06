//Initialization.java
//IFT2255 - Équipe 15
//Classe d'initialisation
package com.ift2255.MaVille;

import java.text.SimpleDateFormat;

public class Initialization {
    public static void initialize(AuthController authController) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Résidents
            Resident resident1 = new Resident("Alice", "Dupont", dateFormat.parse("1998-10-23"), "alice@mail.com", Hash.hasher("password123"), "1234567890", "123 Rue A", "Montréal");
            Resident resident2 = new Resident("Bob", "Martin", dateFormat.parse("2000-12-18"), "bob@mail.com", Hash.hasher("securepass"), "1234567890", "456 Rue B", "Montréal");
            Resident resident3 = new Resident("Caroline", "Lavoie", dateFormat.parse("1956-05-03"), "caroline@mail.com", Hash.hasher("pass789"), "1234567890", "789 Rue C", "Montréal");

            authController.residents.add(resident1);
            authController.residents.add(resident2);
            authController.residents.add(resident3);

            // Intervenants
            Intervenant intervenant1 = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"), "entrepriseA@mail.com", Hash.hasher("password123"), "1234567890", "321 Rue D", "Entreprise publique", 101);
            Intervenant intervenant2 = new Intervenant("Entreprise B", "Privé", dateFormat.parse("1965-09-16"), "entrepriseB@mail.com", Hash.hasher("securepass"), "1234567890", "654 Rue E", "Entrepreneur privé", 102);
            Intervenant intervenant3 = new Intervenant("Entreprise C", "Particulier", dateFormat.parse("1999-07-17"), "entrepriseC@mail.com", Hash.hasher("pass789"), "1234567890", "987 Rue F", "Particulier", 103);

            authController.intervenants.add(intervenant1);
            authController.intervenants.add(intervenant2);
            authController.intervenants.add(intervenant3);

            // Requêtes de travail
            ResidentController residentController1 = new ResidentController(resident1);
            ResidentController residentController2 = new ResidentController(resident2);

            // Requêtes de travail associées aux résidents
            resident1.addWorkRequest(residentController1, "Réparation route", "Réparer les nids-de-poule sur la rue principale.", "Travaux routiers", dateFormat.parse("2024-10-30"), new Street(1, "912 Rue F"));

            resident1.addWorkRequest(residentController1, "Panneau stop à ajouter", "Installer un nouveau panneau stop sur la rue", "Travaux de signalisation", dateFormat.parse("2024-11-15"), new Street(2, "345 Rue T"));

            resident2.addWorkRequest(residentController2, "Entretien paysager", "Tailler les arbres et nettoyer les espaces verts.", "Entretien paysager", dateFormat.parse("2024-11-20"), new Street(3, "567 Rue Y"));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



