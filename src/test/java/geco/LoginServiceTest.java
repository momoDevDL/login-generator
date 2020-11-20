package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoginServiceTest {
    LoginService ls ;
    String[]  Al= {"mohamed","John","max"};
    String newLogin = "Albert";


    @Before
    public void setUp() throws Exception {
        ls = new LoginService(Al);
    }

    @Test
    public void loginExists() {
        assertTrue(ls.loginExists("John"));
    }

    @Test
    public void addLogin() {
        assertFalse(ls.loginExists(newLogin));
        ls.addLogin(newLogin);
       assertTrue(ls.loginExists(newLogin));
    }

    @Test
    public void findAllLoginsStartingWith() {
        ArrayList<String> listPref = new ArrayList<>();
        listPref.add("John");
        assertEquals(listPref,ls.findAllLoginsStartingWith("J"));
    }

    @Test
    public void findAllLogins() {
    assertTrue(ls.findAllLogins().size() == 3);

    }
}