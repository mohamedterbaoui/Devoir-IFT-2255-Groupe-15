package com.ift2255.MaVille;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AuthControllerTest {
    AuthController auth = new AuthController(true);
    Resident resident = new Resident("Seven",
            "Nine",
            null,
            "SevenOfNine@borg.com",
            "unimatrix1",
            "123456789",
            "137 av du President Kennedy",
            "h2x 3p6",
            "Montréal");
    
    @Test
    public void signupTest(){
        auth.signUpResident(resident);
        auth.loginResident("SevenOfNine@borg.com", "unimatrix1");
        ResidentController resCont = auth.getResidentController();
        assertTrue(resCont.getCurrentResident().getFirstName().equals("Seven"));


    }
    @Test
    void ResidentCreationTest(){
    ResidentController controller = new ResidentController(resident);
    Resident currentResident = controller.getCurrentResident();
    assertTrue(currentResident.getFirstName().equals("Seven"));
    assertTrue(currentResident.getLastName().equals("Nine"));
    }

}
