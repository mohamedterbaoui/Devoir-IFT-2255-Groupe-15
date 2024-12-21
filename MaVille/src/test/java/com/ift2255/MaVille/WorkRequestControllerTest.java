package com.ift2255.MaVille;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkRequestControllerTest {
    @Test
    public void testCreateAndAssignIntervenant() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Intervenant intervenant1 = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"),"entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", 101);

        Resident resident = new Resident("Alice", "Dupont", dateFormat.parse("1998-10-23"), "alice@mail.com","password123", "1234567890", "123 Rue A", "Montréal");
        Street address = new Street(123, "Main Street"); 
        WorkRequest request = new WorkRequest(456, "Réparation de trottoir", "Trottoirs fissurés devant le 123 Main Street", dateFormat.parse("2024-03-15"), "Réparation", address);
        request.setResident(resident); 

        WorkRequestController.addWorkRequest(request);

        request.setIntervenant(intervenant1);

        assertEquals(intervenant1.getName(), request.getIntervenant().getName());
        assertEquals(intervenant1.getType(), request.getIntervenant().getType());

	WorkRequestController.remove();
    }

    @Test
    void testApplyToWorkRequest() {
        String input = "1\n"; 
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    
        IntervenantController.applyToWorkRequest();
    
        List<WorkRequest> appliedRequests = WorkRequestController.getAllRequests();
        assertFalse(appliedRequests.isEmpty(), "La liste des requêtes de travail ne devrait pas être vide après la candidature.");
    }

    @Test
    public void testWithdrawApplication() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Intervenant intervenant = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"),"entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", 101);
        AuthController authController = new AuthController();
        authController.intervenants.add(intervenant);
        IntervenantController.setCurrentIntervenant(intervenant);

        Resident resident1 = new Resident("Alice", "Dupont", dateFormat.parse("1998-10-23"), "alice@mail.com", "password123", "1234567890", "123 Rue A", "Montréal");

        ResidentController residentController1 = new ResidentController(resident1);

        resident1.addWorkRequest(residentController1, "Réparation route", "Réparer les nids-de-poule sur la rue principale.", "Travaux routiers", dateFormat.parse("2024-10-30"), new Street(1, "912 Rue F"));
        
        String input = "1\n"; 
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        IntervenantController.applyToWorkRequest();


        List<WorkRequest> appliedRequests = WorkRequestController.getAllRequests();
        assertFalse(appliedRequests.isEmpty(), "La liste des requêtes de travail ne devrait pas être vide.");

        IntervenantController.withdrawApplication();

        appliedRequests = WorkRequestController.getAllRequests();
        assertTrue(appliedRequests.stream().anyMatch(req -> req.getIntervenant() != null && 
            req.getIntervenant().equals(IntervenantController.getCurrentIntervenant())), 
            "L'intervenant devrait avoir postulé à la requête.");

    }
}
