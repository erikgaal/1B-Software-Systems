package ss.week1.hotel;

/** 
 * Testprogram for Room and Guest.
 * Lab Exercise SoftwareSystems
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class GuestTest {
    /** Testvariabele for a <tt>Guest</tt>-object. */
    public Guest ot;
    /** Testvariabele for a <tt>Guest</tt>-object. */
    public Guest sien;
    /** Testvariabele for a <tt>Room</tt>-object. */
    public Room k101;
    /** Testvariabele for a <tt>Room</tt>-object. */
    public Room k102;

    /** Calls all tests in this class one-by-one. */
    public void start() {
        System.out.println("Test class: " + this.getClass());
        setUp();
        testInitialcondition();
        setUp();
        testCheckinEmpty();
        setUp();
        testCheckinTaken();
        setUp();
        testCheckoutKnown();
        setUp();
        testCheckoutUnknown();
    }

    /**
     * Sets initial variables to a well-defined initial value.
     * All test methods should be preceded by a call to this method
     * <p>
     * Assigns a <tt>Guest</tt> object to the <tt>ot</tt> instance variable 
     * with the name <tt>&quot;Ot&quot;</tt> and assigns a <tt>Guest</tt> object
     * to the <tt>sien</tt> instance variable with the name <tt>&quot;Sien&quot;</tt>.
     * Also assigns <tt>Room</tt> objects to instance variables <tt>k101</tt> and
     * <tt>k102</tt> with numbers <tt>101</tt> and <tt>102</tt> respectively.
     * Lastly, checks in <tt>sien</tt> in room <tt>k102</tt>.
     */
    public void setUp() {
        // initialisation of Guest-variables
        ot = new Guest("Ot");
        sien = new Guest("Sien");
        // initialisation of Room-variables
        k101 = new Room(101);
        k102 = new Room(102);
        // check in sien on room 102
        sien.checkin(k102);
    }

    /**
     * Test if the initial condition complies to the specification.
     * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
     */
    public void testInitialcondition() {
        beginTest("Initial condition");
        assertEquals("ot.getName()", "Ot", ot.getName());
        assertEquals("sien.getName()", "Sien", sien.getName());
        assertEquals("ot.getRoom()", null, ot.getRoom());
        assertEquals("sien.getRoom()", k102, sien.getRoom());
    }

    /**
     * Tests checking in a new guest in an empty room.
     * Calls <tt>ot.checkin(k101)</tt>.
     * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
     */
    public void testCheckinEmpty() {
        beginTest("Checking in a new guest in an empty room");
        assertEquals("ot.checkin(k101)", true, ot.checkin(k101));
        assertEquals("ot.getRoom()", k101, ot.getRoom());
        assertEquals("k101.getGuest()", ot, k101.getGuest());
    }

    /**
     * Checks checking in a new guest in a room that is already taken.
     * Calls <tt>ot.checkin(k102)</tt>.
     * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
     */
    public void testCheckinTaken() {
        beginTest("Checking in a new guest in a room that is already taken");
        assertEquals("ot.checkin(k102)", false, ot.checkin(k102));
        assertEquals("ot.getRoom()", null, ot.getRoom());
        assertEquals("k102.getGuest()", sien, k102.getGuest());
    }

    /**
     * Tests checking out a guest that rented a room.
     * Calls <tt>sien.checkout()</tt>.
     * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
     */
    public void testCheckoutKnown() {
        beginTest("Checking out a guest that rented a room");
        assertEquals("sien.checkout()", true, sien.checkout());
        assertEquals("sien.getRoom()", null, sien.getRoom());
        assertEquals("k102.getGuest()", null, k102.getGuest());
    }

    /**
     * Tests checking out a guest that didn't rent a room.
     * Calls <tt>ot.checkout()</tt>.
     * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
     */
    public void testCheckoutUnknown() {
        beginTest("Checking out a guest that didn't rent a room");
        assertEquals("ot.checkout()", false, ot.checkout());
        assertEquals("ot.getRoom()", null, ot.getRoom());
    }

    /**
     * Print the testmethod's description.
     * @param text The description to be printed
     */
    private void beginTest(String text) {
    	System.out.println("    Test: " + text);
    }

    /**
     * Tests if the resulting value of a tested expression equals the 
     * expected (correct) value. This implementation prints both values, 
     * with an indication of what was tested, to the standard output. The 
     * implementation does not actually do the comparison.
     */
    private void assertEquals(String text, Object expected, Object result) {
    	System.out.println("        " + text);
    	System.out.println("            Expected:  " + expected);
    	System.out.println("            Result: " + result);
    }

    /** Makes a <tt>GuestTest</tt> object and runs it.*/
    public static void main(String[] args) {
        System.out.println("Log of " + GuestTest.class + 
                           ", " + new java.util.Date());
        new GuestTest().start();
    }
}
