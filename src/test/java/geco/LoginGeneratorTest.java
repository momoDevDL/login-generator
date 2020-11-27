package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {
    LoginGenerator lg;
    LoginService ls;
    @Before
    public void setUp() throws Exception {
        ls = new LoginService(new String[] {"JROL",
                "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        lg = new LoginGenerator(ls);
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        lg.generateLoginForNomAndPrenom("Durand","Paul");
        lg.generateLoginForNomAndPrenom("Durand","Paul");
        lg.generateLoginForNomAndPrenom("Ralling","John");
        lg.generateLoginForNomAndPrenom("Rolling","Jean");
        lg.generateLoginForNomAndPrenom("Du","Paul");
        assertTrue(ls.loginExists("PDUR"));
        assertTrue(ls.loginExists("PDUR1"));
        assertTrue(ls.loginExists(("JRAL2")));
        assertTrue(ls.loginExists(("JROL1")));
        assertTrue(ls.loginExists("PDU"));

    }
}