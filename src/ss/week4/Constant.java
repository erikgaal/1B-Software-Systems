package ss.week4;

public class Constant implements Function, Integrandable {

    double c;

    public Constant(double constant) {
        this.c = constant;
    }

    @Override
    public double apply(double argument) {
        return c;
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }

    @Override
    public Function integrand() {
        return new LinearProduct(new Constant(c), new Exponent(1));
    }

    public String toString() {
        return String.valueOf(c);
    }
}
