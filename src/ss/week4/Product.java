package ss.week4;

public class Product implements Function {

    Function g;
    Function h;

    public Product(Function g, Function h) {
        this.g = g;
        this.h = h;
    }

    @Override
    public double apply(double argument) {
        return g.apply(argument) * h.apply(argument);
    }

    @Override
    public Function derivative() {
        return new Sum(new Product(g.derivative(), h), new Product(h.derivative(), g));
    }

    public String toString() {
        return g.toString() + "*" + h.toString();
    }
}
