package ss.week4;

public class LinearProduct extends Product implements Function, Integrandable {

    public LinearProduct(Constant c, Function g) {
        super(c, g);
    }

    @Override
    public Function derivative() {
        return new LinearProduct((Constant) g, h.derivative());
    }

    @Override
    public Function integrand() {
        if (g != null && h != null && h instanceof Integrandable) {
            return new LinearProduct((Constant) g, ((Integrandable) h).integrand());
        }
        return null;

    }

    public String toString() {
        return g.toString() + "*" + h.toString();
    }
}
