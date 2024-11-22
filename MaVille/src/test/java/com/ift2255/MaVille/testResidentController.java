package com.ift2255.MaVille;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class testResidentController {

    @Test
    void testJsonParsing() {
        // Simulate the response body
        String mockJson = """
                {
                    "result": {
                        "records": [
                            {
                                "_id": 1,
                                "id_request": "entrave1",
                                "name": "Main Street",
                                "streetimpactwidth": "2 lanes",
                                "streetimpacttype": "Full",
                                "nbfreeparkingplace": "10",
                                "sidewalk_blockedtype": "Partial",
                                "bikepath_blockedtype": "Full",
                                "fromname": "1st Avenue",
                                "toname": "2nd Avenue",
                                "length": "100.5"
                            }
                        ]
                    }
                }
                """;

        // Create an ApiResponse object with the mock JSON body
        ApiResponse mockResponse = new ApiResponse(200, null, mockJson);

        // Create an instance of the class under test (ResidentController)
        ResidentController controller = new ResidentController(new Resident("Alice",
                "Dupont", null, "alice@mail.com", "password123",
                "1234567890", "123 Rue A", "Montréal"));

        // Call the jsonParsing function
        JsonArray result = controller.jsonParsing(mockResponse);

        // Now verify the contents of the resulting JsonArray
        // Verify that the array has one object (since there's one "record")
        assertEquals(1, result.size(), "The records array should contain one element.");

        // Verify that the first (and only) record has the correct fields
        JsonObject firstRecord = result.get(0).getAsJsonObject();
        assertEquals("entrave1", firstRecord.get("id_request").getAsString());
        assertEquals("Main Street", firstRecord.get("name").getAsString());
        assertEquals("2 lanes", firstRecord.get("streetimpactwidth").getAsString());
        assertEquals("Full", firstRecord.get("streetimpacttype").getAsString());
        assertEquals("10", firstRecord.get("nbfreeparkingplace").getAsString());
        assertEquals("Partial", firstRecord.get("sidewalk_blockedtype").getAsString());
        assertEquals("Full", firstRecord.get("bikepath_blockedtype").getAsString());
        assertEquals("1st Avenue", firstRecord.get("fromname").getAsString());
        assertEquals("2nd Avenue", firstRecord.get("toname").getAsString());
        assertEquals(100.5, firstRecord.get("length").getAsDouble(), 0.01);
    }

    @Test
    void testViewAllProjects() {
        ResidentController controller = new ResidentController(new Resident("Alice",
                "Dupont", null, "alice@mail.com", "password123",
                "1234567890", "123 Rue A", "Montréal"));

        // Redirect System.out to a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        controller.viewAllProjects();

        String output = outputStream.toString();

        int projectCount = output.split("ID").length - 1;

        assertEquals(100, projectCount);

    }

    @Test
    void testViewAllEntraves() {
        ResidentController controller = new ResidentController(new Resident("Alice",
                "Dupont", null, "alice@mail.com", "password123",
                "1234567890", "123 Rue A", "Montréal"));

        // Redirect System.out to a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        controller.viewAllEntraves();

        String output = outputStream.toString();

        int projectCount = output.split("ID").length - 1;

        assertEquals(100, projectCount);

    }


}

