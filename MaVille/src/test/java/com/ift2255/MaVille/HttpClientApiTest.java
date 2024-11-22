package com.ift2255.MaVille;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class HttpClientApiTest {
    @Test
    void testGetData() {
        HttpClientApi api = new HttpClientApi();
        String resourceId = "cc41b532-f12d-40fb-9f55-eb58c9a2b12b";
        ApiResponse response = api.getData(resourceId);

        assertNotNull(response, "La réponse de l'API ne doit pas être nulle.");
        assertEquals(200, response.getStatusCode(), "Le statut de la réponse doit être 200.");
        assertNotNull(response.getBody(), "Le corps de la réponse ne doit pas être nul.");
    }
}
