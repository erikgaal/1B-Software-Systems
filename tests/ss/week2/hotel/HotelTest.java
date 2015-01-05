package ss.week2.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.week1.Password;

/** 
 * Test program Password.
 * Lab exercise Software Systems
 * @author Arend Rensink, Christoph Bockisch
 * @version $Revision: 1.2 $
 */
public class HotelTest {
    /** Test variable for a <tt>Hotel</tt> object. */
    public Hotel hotel;
    public String correctPassword;
    public String wrongPassword;
    public static final String GUEST_NAME_1 = "Major Gowen";
    public static final String GUEST_NAME_2 = "Miss Tibbs";
    public static final String GUEST_NAME_3 = "Miss Gatsby";
    

     /**
     * Sets the instance variable <tt>hotel</tt> to a well-defined initial value.
     * All test methods should be preceded by a call to this method.
     */
    @Before
    public void setUp() {
        // initialisation of password-variable
        hotel = new Hotel("Fawlty Towers");
        correctPassword = Password.INITIAL;
        wrongPassword = Password.INITIAL + "wrong";
    }

    /**
     * CheckIn must return null is the password is wrong.
     * As long as rooms are available, checkIn must return a room occupied by the specified guest.
     * When the hotel is full, checkIn must return null.
     */
    @Test
    public void testCheckin() {
        Room room0 = hotel.checkIn(wrongPassword, GUEST_NAME_1);
        assertEquals("No chekin with wrong password", null, room0);

        Room room1 = hotel.checkIn(correctPassword, GUEST_NAME_1);
        assertEquals("Correct 1st guest checkin", GUEST_NAME_1, room1.getGuest().getName());

        Room room2 = hotel.checkIn(correctPassword, GUEST_NAME_2);
        assertEquals("Correct 2nd guest checkin", GUEST_NAME_2, room2.getGuest().getName());
        
        Room room3 = hotel.checkIn(correctPassword, GUEST_NAME_3);
        assertEquals("No checkin when hotel is full", null, room3);
    }

    /**
     * If the specified guest is checked in, he must be checked out, i.e., afterwards, he must not have a room anymore, and
     * his room must now be empty.
     * And the room's safe must be inactivated.
     */
    @Test
    public void testCheckout() {
        Room room = hotel.checkIn(correctPassword, GUEST_NAME_1);
        Guest guest = room.getGuest();
        Safe safe = room.getSafe();
        safe.activate(Password.INITIAL);
        
        hotel.checkOut(GUEST_NAME_1);
        assertEquals("Guest has no room", null, guest.getRoom());
        assertEquals("Room has no guest", null, room.getGuest());
        assertEquals("Safe is inactive", false, safe.isActive());
        
        hotel.checkOut(GUEST_NAME_2);
        // nothing to be checked here, but no exception should occur.
    }
    
    /**
     * If there is a free room, getFreeRoom must return a room without guest.
     * Otherwise is must return null.
     */
    @Test
    public void testgetFreeRoom() {
        Room room0 = hotel.getFreeRoom();
        assertEquals("Room is free", null, room0.getGuest());

        hotel.checkIn(correctPassword, GUEST_NAME_1);
        hotel.checkIn(correctPassword, GUEST_NAME_2);

        Room room1 = hotel.getFreeRoom();
        assertEquals("No room available", null, room1);
    }

    /**
     * If the guest is checked in, the returned room must be occupied by the specified guest.
     * Otherwise, no room must be returned.
     */
    @Test
    public void testgetRoom() {
        hotel.checkIn(correctPassword, GUEST_NAME_1);
        
        Room room0 = hotel.getRoom(GUEST_NAME_1);
        assertEquals("Room with correct guest", GUEST_NAME_1, room0.getGuest().getName());
        
        Room room1 = hotel.getRoom(GUEST_NAME_2);
        assertEquals("Guest not checked in", null, room1);
    }

    /**
     * A password object must be returned. 
     */
    @Test
    public void testgetPassword() {
        Password password = hotel.getPassword();
        assertEquals("Returned password is not null", true, password != null);
    }

    /**
     * ToString is difficult to test fully because there is no restriction on the
     * format of the returned String. At least it can be tested that a String is
     * returned and that it contains the name of a checked in guest.
     */
    @Test
    public void testtoString() {       
        hotel.checkIn(correctPassword, GUEST_NAME_1);
        
        String string = hotel.toString();
        assertEquals("Returned String is not null", true, string != null);
        assertEquals("Returned String contains guest name",
        		true, string.indexOf(GUEST_NAME_1) != -1);
    }
}
