package ss.week4;

public class Exponent implements Function, Integrandable {

    int n;

    public Exponent(int n) {
        this.n = n;
    }

    @Override
    public double apply(double argument) {
        return Math.pow(argument, n);
    }

    @Override
    public Function derivative() {
        return new LinearProduct(new Constant(n), new Exponent(n - 1));
    }

    @Override
    public Function integrand() {
        return new LinearProduct(new Constant(1d / (n + 1)), new Exponent(n + 1));
    }

    public String toString() {
        return "x^" + String.valueOf(n);
    }

}
