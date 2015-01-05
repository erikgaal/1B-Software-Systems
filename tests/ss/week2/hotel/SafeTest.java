package ss.week2.hotel;

import org.junit.Before;
import org.junit.Test;
import ss.week1.Password;

import static org.junit.Assert.*;

public class SafeTest {

    private Safe safe;

    @Before
    public void setUp() throws Exception {
        Password password = new Password();
        password.setWord(Password.INITIAL, "testing");
        safe = new Safe(password);
    }

    @Test
    public void testActivate() throws Exception {
        safe.activate(Password.INITIAL);
        assertEquals(false, safe.isActive());

        safe.activate("testing");
        assertEquals(true, safe.isActive());
    }

    @Test
    public void testDeactivate() throws Exception {
        safe.deactivate();
        assertEquals(false, safe.isActive());
        assertEquals(false, safe.isOpen());
    }

    @Test
    public void testClose() throws Exception {
        safe.close();
        assertEquals(false, safe.isOpen());
    }

    @Test
    public void testOpen() throws Exception {
        safe.activate("testing");
        safe.open(Password.INITIAL);
        assertEquals(false, safe.isOpen());

        safe.open("testing");
        assertEquals(true, safe.isOpen());
        safe.deactivate();
    }
}