package ss.week3.hotel;

import ss.week3.Format;

import java.io.PrintStream;

public class Bill {

    private PrintStream out;
    private double sum;

    public Bill(PrintStream out) {
        this.out = out;
    }

    public void newItem(Item item) {
        Format.printLine(item.toString(), item.getPrice(), out);
        sum += item.getPrice();
    }

    public double getSum() {
        return sum;
    }

    public void close() {
        Format.printLine("Total:", getSum(), out);
    }

    public static interface Item {
        double getPrice();
    }
}
