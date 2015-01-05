package ss.week3.hotel;

public class Voedsel implements Bill.Item {

    private String text;
    private double price;

    public Voedsel(String text, double price) {
        this.text = text;
        this.price = price;
    }

    public String toString() {
        return text;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
