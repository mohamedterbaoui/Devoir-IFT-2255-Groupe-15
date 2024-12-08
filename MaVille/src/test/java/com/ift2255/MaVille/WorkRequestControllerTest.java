package com.ift2255.MaVille;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkRequestControllerTest {
    @Test
    public void testCreateAndAssignIntervenant() throws ParseException {
        // Initialisation de l'intervenant
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Intervenant intervenant1 = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"),
                "entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", 101);

        // Création d'une requête de travail (vous devrez adapter les valeurs selon vos
        // besoins)
        Resident resident = new Resident("Alice", "Dupont", dateFormat.parse("1998-10-23"), "alice@mail.com",
                "password123", "1234567890", "123 Rue A", "Montréal");
        Street address = new Street(123, "Main Street"); // Exemple d'adresse
        WorkRequest request = new WorkRequest("Réparation de trottoir", "Trottoirs fissurés devant le 123 Main Street",
                dateFormat.parse("2024-03-15"), "Réparation", address);
        request.setResident(resident); // Affectation du résident à la requête

        // Ajout de la requête au contrôleur
        WorkRequestController.addWorkRequest(request);

        // Affectation de l'intervenant à la requête
        request.setIntervenant(intervenant1);

        assertEquals(intervenant1.getName(), request.getIntervenant().getName());
        assertEquals(intervenant1.getType(), request.getIntervenant().getType());

	WorkRequestController.remove();
    }
}
