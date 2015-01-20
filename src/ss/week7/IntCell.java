package ss.week7;

public class IntCell {
    private int contents;

    public synchronized void add(int amount) {
        contents += amount;
    }

    public int get() {
        return contents;
    }

    public static void main(String[] args) {
        IntCell cell = new IntCell();
        Adder adderA = new Adder(cell, 1);
        Adder adderB = new Adder(cell, 2);
        adderA.start();
        adderB.start();

        try {
            adderA.join();
            adderB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cell.get());
    }
}

class Adder extends Thread {
    private IntCell cell;
    private int amount;

    public Adder(IntCell cell, int amount) {
        this.cell = cell;
        this.amount = amount;
    }

    public void run() {
        cell.add(amount);
    }
}
