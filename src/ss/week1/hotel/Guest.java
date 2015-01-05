package ss.week1.hotel;

/**
 * Guest with a name and possibly a room
 * @author Erik Gaal
 * @version $Revision 3.1.4
 */
public class Guest {

    private String name;
    private Room room;

    /**
     * Creates a <code>Guest</code> with a name, without a <code>Room</code>
     * @param name name of the new <code>Guest</code>
     */
    public Guest(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this <code>Guest</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current room this <code>Guest</code> is living.
     * @return the room of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code>
     *         has no room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Returns a human-readable object name
     */
    public String toString() {
        return "Guest " + getName();
    }

    /**
     * Assigns a <code>Room</code> to this <code>Guest</code>.
     * @param room the next <code>Room</code> this <code>Guest</code> will rent;
     *             if <code>null</code> is passed, this <code>Guest</code>
     *             will have no <code>Room</code>
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Tries to checks in a <code>Guest</code> in the specified <code>Room</code>
     * @param room the <code>Room</code> to check the <code>Guest</code> in
     * @return if the checkin was successful.
     */
    public boolean checkin(Room room) {
        if (room.getGuest() == null && getRoom() == null) {
            setRoom(room);
            room.setGuest(this);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tries to checks out a <code>Guest</code>
     * @return if the checkout was successful.
     */
    public boolean checkout() {
        if (getRoom() != null) {
            room.setGuest(null);
            setRoom(null);
            return true;
        } else {
            return false;
        }
    }
}
