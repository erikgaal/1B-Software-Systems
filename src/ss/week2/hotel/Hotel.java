package ss.week2.hotel;

import ss.week1.Password;

public class Hotel {

    private String name;
    private Room room1;
    private Room room2;
    private Password password;

    /*@requires size > 0 */
    public Hotel(String name) {
        this.name = name;
        room1 = new Room(0);
        room2 = new Room(1);
        password = new Password();
    }

    /*@requires password.length() > 0 && name.length() > 0 */
    public Room checkIn(String password, String name) {
        if (getPassword().testWord(password)) {
            Room room = getFreeRoom();
            if (room != null) {
                Guest guest;
                if (getRoom(name) != null) {
                    return null;
                } else {
                    guest = new Guest(name);
                }
                guest.checkin(room);
                return room;
            }
        }
        return null;
    }

    /*@requires name.length() > 0 */
    public void checkOut(String name) {
        Room room = getRoom(name);
        if (room != null) {
            room.getSafe().deactivate();
            room.getGuest().checkout();
        }
    }

    /*@ensures \result == null || \result.getGuest() == null */
    public Room getFreeRoom() {
        if (room1.getGuest() == null) {
            return room1;
        } else if (room2.getGuest() == null) {
            return room2;
        } else {
            return null;
        }
    }

    /*@requires name.length() > 0
     *@ensures \result == null || \result.getGuest().getName().equals(name) */
    public Room getRoom(String name) {
        if (room1.getGuest() != null && room1.getGuest().getName().equals(name)) {
            return room1;
        } else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) {
            return room2;
        } else {
            return null;
        }
    }

    /*@ensures \result != null */
    public Password getPassword() {
        return password;
    }

    public String toString() {
        return room1 + ", " + room1.getGuest() + "\n" + room2 + ", " + room2.getGuest();
    }
}
