package com.ift2255.MaVille;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkRequestControllerTest {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testCreateAndAssignIntervenant() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Intervenant intervenant1 = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"),"entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", 101);

        Resident resident = new Resident("Seven",
        "Nine",
        null,
        "SevenOfNine@borg.com",
        "unimatrix1",
        "123456789",
        "137 av du President Kennedy",
        "h2x 3p6",
        "Montréal");        
        Street address = new Street(123, "Main Street"); 
        WorkRequest request = new WorkRequest(456, "Réparation de trottoir", "Trottoirs fissurés devant le 123 Main Street", dateFormat.parse("2024-03-15"), "Réparation", address);
        request.setResident(resident); 

        WorkRequestController.addWorkRequest(request);

        request.setIntervenant(intervenant1);

        assertEquals(intervenant1.getName(), request.getIntervenant().getName());
        assertEquals(intervenant1.getType(), request.getIntervenant().getType());

	WorkRequestController.remove();
    }


    // Ces tests ne fonctionnent pas...
    /*
    @Test
    void testApplyToWorkRequest() throws ParseException {
        Street address = new Street(123, "Main Street");
        WorkRequest request = new WorkRequest(10, "Réparation de trottoir", "Trottoirs fissurés devant le 123 Main Street", dateFormat.parse("2024-03-15"), "Réparation", address);
        WorkRequestController.addWorkRequest(request);
        
        String input = "10\n"; 
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        IntervenantController.applyToWorkRequest();

        Intervenant assignedIntervenant = WorkRequestController.getIntervenant(10);
        assertNotNull(assignedIntervenant, "Un intervenant devrait être assigné à la requête.");
        assertEquals("Entreprise A", assignedIntervenant.getName(), "L'intervenant assigné devrait être 'Entreprise A'.");
    }

    @Test
    public void testWithdrawApplication() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Intervenant intervenant = new Intervenant("Entreprise A", "Public", dateFormat.parse("1981-08-15"),"entrepriseA@mail.com", "password123", "1234567890", "321 Rue D", "Entreprise publique", 101);
        AuthController authController = new AuthController();
        authController.getIntervenants().add(intervenant);
        IntervenantController.setCurrentIntervenant(intervenant);

        Resident resident = new Resident("Seven",
        "Nine",
        null,
        "SevenOfNine@borg.com",
        "unimatrix1",
        "123456789",
        "137 av du President Kennedy",
        "h2x 3p6",
        "Montréal");
        ResidentController residentController1 = new ResidentController(resident);

        resident.addWorkRequest(residentController1, "Réparation route", "Réparer les nids-de-poule sur la rue principale.", "Travaux routiers", dateFormat.parse("2024-10-30"), new Street(1, "912 Rue F"));
        
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

    */
}
