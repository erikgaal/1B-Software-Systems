package ss.week1;

public class MoneyCounter {
    private int dollars;
    private int cents;

    public void add(int dollars, int cents) {
        int total = this.dollars * 100 + this.cents;
        total += dollars * 100 + cents;
        this.dollars = total / 100;
        this.cents = total % 100;
    }

    public void substract(int dollars, int cents) {
        int total = this.dollars * 100 + this.cents;
        total -= dollars * 100 + cents;
        this.dollars = total / 100;
        this.cents = total % 100;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public void reset() {
        this.dollars = 0;
        this.cents = 0;
    }
}
