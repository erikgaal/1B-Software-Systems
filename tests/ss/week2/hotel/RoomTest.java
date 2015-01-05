package ss.week2.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import ss.week1.Password;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

/** 
 * Testprogram for Room en Guest
 * Software Systems
 * @author Arend Rensink
 * @version $Revision: 1.5 $
 */
public class RoomTest {
    /** <tt>Gast</tt>-testvariabele. */
    public Guest guest;
    /** <tt>Kamer</tt>-testvariabele. */
    public Room room;

    public Safe safe;


    @Before
    public void setUp() {
        // initialisatie van gast-variabele
        guest = new Guest("Jip");
        // initialisatie van kamer-variabele
        room = new Room(101);
        // init safe
        room.getSafe().activate(Password.INITIAL);
        room.getSafe().close();
    }

    /**
     * Test of the initial situation
     * Method call should be prefixed by setUp
     * <tt>{@link #setUp}</tt>.
     */
    @Test
    public void testInitial() {
        assertEquals("room.getNumber()", 101, room.getNumber());
        assertEquals("room.getSafe().isActive()", true, room.getSafe().isActive());
        assertEquals("room.getSafe().isOpen()", false, room.getSafe().isOpen());
    }

    /**
     * Test setting a guest
     * Method call should be prefixed by setUp
     * <tt>{@link #setUp}</tt>.
     */
    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals("room.setguest(gast); room.getGuest()", guest, room.getGuest());
    }

    @Test
    public void testSafe() {
        room.getSafe().open(Password.INITIAL);
        assertEquals("room.getSafe().isOpen()", true, room.getSafe().isOpen());
        room.getSafe().close();
        assertEquals("room.getSafe().isOpen()", false, room.getSafe().isOpen());
    }

}
