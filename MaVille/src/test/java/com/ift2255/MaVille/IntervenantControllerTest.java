package com.ift2255.MaVille;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class IntervenantControllerTest {
    private IntervenantController intervenantController;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    AuthController authController = new AuthController();

    @BeforeEach
    public void setUp() {
        authController = new AuthController();
        try {
            Resident resident1 = new Resident("Alice", "Dupont", dateFormat.parse("1998-10-23"), "alice@mail.com",
                    "password123", "1234567890", "123 Rue A", "h4p 1z6","Montréal");
            authController.residents.add(resident1);
            ResidentController residentController1 = new ResidentController(resident1);
            resident1.addWorkRequest(residentController1, "Réparation route",
                    "Réparer les nids-de-poule sur la rue principale.", "Travaux routiers",
                    dateFormat.parse("2024-10-30"), new Street(1, "912 Rue F"));

            Intervenant intervenant = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"),
                    "entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", 101);
            authController.intervenants.add(intervenant);
            intervenantController = new IntervenantController(intervenant);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Test l'ajout de l'intervenant créé en setUp()
    @Test
    public void testLoginIntervenant() {
        // Essayer de se connecter avec les identifiants de l'intervenant
        boolean loginSuccess = authController.loginIntervenant("entrepriseA@mail.com", "password123");
        assertTrue(loginSuccess, "L'intervenant devrait pouvoir se connecter avec des identifiants valides.");
    }

    // Test l'ajout de la requête de travail créée en setUp()
    @Test
    public void testViewWorkRequests() {
        List<WorkRequest> requests = intervenantController.getWorkRequestsTest();
        assertNotNull(requests, "La liste des requêtes de travail ne devrait pas être nulle.");
        assertFalse(requests.isEmpty(), "La liste des requêtes de travail ne devrait pas être vide.");
        assertEquals("Réparation route", requests.get(0).getTitle(),
                "Le titre de la requête de travail devrait correspondre.");
    }

    // Test que le code gère correctement les exceptions ("créer un intervenant avec des données invalides")
    @Test
    public void testInvalidIntervenantCreation() {
        // Test pour vérifier si un cityId de -5 lance une exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Intervenant("Nom", "Public", dateFormat.parse("1981-08-15"), "entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", -5);
        }, "La création d'un intervenant avec un cityId de -5 devrait lancer une exception.");
    }
}