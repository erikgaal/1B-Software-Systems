package ss.week1;

public class Employee {
    private int hours;
    private double rate;

    public double pay() {
        return Math.min(hours, 40) * rate + Math.max((hours - 40), 0) * rate * 1.5;
    }
}