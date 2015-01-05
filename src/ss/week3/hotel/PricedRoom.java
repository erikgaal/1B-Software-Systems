package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item{

    private double price;

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     *
     * @param no number of the new <code>Room</code>
     */
    public PricedRoom(int no, double price, Safe safe) {
        super(no, safe);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String toString() {
        return super.toString();
    }
}
