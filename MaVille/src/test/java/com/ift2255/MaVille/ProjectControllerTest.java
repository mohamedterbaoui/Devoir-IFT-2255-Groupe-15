package com.ift2255.MaVille;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class ProjectControllerTest {

    @Test
    void testAddProject() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Simule les entrées de l'utilisateur
        String input = "Mon Projet\n123 Rue Test\n2024-01-01\n2024-12-31\nDescription du projet\n10:00\n17:00\n1\n"; 
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Crée un nouveau projet avec ProjectController.addProject()
        Project newProject = ProjectController.addProject();

        System.setOut(System.out);
        System.setIn(System.in);

        // Vérifie que le projet a été créé avec succès (avec les bonnes info)
        assertNotNull(newProject, "Le projet n'a pas été créé.");
        assertEquals("Mon Projet", newProject.getTitle(), "Le titre du projet est incorrect.");
        assertEquals("123 Rue Test", newProject.getProjectAddress(), "L'adresse du projet est incorrecte.");
        assertEquals(java.sql.Date.valueOf("2024-01-01"), newProject.getStartDate(), "La date de début du projet est incorrecte.");
        assertEquals(java.sql.Date.valueOf("2024-12-31"), newProject.getEndDate(), "La date de fin du projet est incorrecte.");
        assertEquals("Description du projet", newProject.getDescription(), "La description du projet est incorrecte.");
        assertEquals("10:00", newProject.getHeureDebut(), "L'heure de début du projet est incorrecte.");
        assertEquals("17:00", newProject.getHeureFin(), "L'heure de fin du projet est incorrecte.");
        assertEquals(ProjectType.values()[0], newProject.getProjectType(), "Le type de projet est incorrect.");
        assertFalse(newProject.isCompleted(), "Le projet devrait être marqué comme non terminé par défaut.");

        // Vérifie que le projet a été ajouté à la liste des projets
        assertTrue(ProjectController.getProjectList().contains(newProject), "Le projet n'a pas été ajouté à la liste.");
    }

    @Test
    void testAddProjectQuit() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int initialSize = ProjectController.getProjectList().size(); // Taille de la liste avant l'ajout

        // Simule les entrées de l'utilisateur.  L'utilisateur entre "annuler" pour la date de fin pour sortir.
        String input = "Mon Projet\n123 Rue Test\n2024-01-01\nannuler\nDescription du projet\n10:00\n17:00\n1\n";
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Crée un nouveau projet avec ProjectController.addProject()
        Project newProject = ProjectController.addProject();

        System.setOut(System.out);
        System.setIn(System.in);

        // Vérifie que le projet n'a pas été créé
        assertNull(newProject, "Le projet a été créé alors que l'utilisateur a entré 'annuler'.");

        // Vérifie que la taille de la liste n'a pas changé
        assertEquals(initialSize, ProjectController.getProjectList().size(), "Le projet a été ajouté à la liste malgré l'annulation.");
    }
}