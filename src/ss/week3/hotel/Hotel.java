package ss.week3.hotel;

import ss.week1.Password;

import java.io.PrintStream;

public class Hotel {

    private String name;
    private Room room1;
    private Room room2;
    private Password password;

    /*@requires size > 0 */
    public Hotel(String name) {
        this.name = name;
        room1 = new PricedRoom(0, 20, new PricedSafe(20));
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

    public Bill getBill(String guest, int nights, int drinks, PrintStream out) {
        Room room = getRoom(guest);
        if (room != null && room instanceof PricedRoom) {
            Bill bill = new Bill(out);
            for (int i = 0; i < nights; i++) {
                bill.newItem((PricedRoom) room);
            }
            bill.newItem(new Fridge(Integer.MAX_VALUE));
            bill.close();
            return bill;
        }
        return null;
    }

    /*@ensures \result != null */
    public Password getPassword() {
        return password;
    }

    public String toString() {
        return room1 + ", " + room1.getGuest() + "\n" + room2 + ", " + room2.getGuest();
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Derp");
        hotel.checkIn(Password.INITIAL, "John Doe");
        hotel.getBill("John Doe", 5, 5, System.out);
    }
}
