package ss.week4;

public class Polynomial implements Function, Integrandable {

    LinearProduct[] products;

    public Polynomial(LinearProduct[] products) {
        this.products = products;
    }

    @Override
    public double apply(double argument) {
        double result = 0;
        for (int i = 0; i < products.length; i++) {
            result += products[i].apply(argument);
        }
        return result;
    }

    @Override
    public Function derivative() {
        LinearProduct[] derivative = new LinearProduct[products.length];
        for (int i = 0; i < products.length; i++) {
            derivative[i] = (LinearProduct) products[i].derivative();
        }
        return new Polynomial(derivative);
    }

    @Override
    public Function integrand() {
        LinearProduct[] integrand = new LinearProduct[products.length];
        for (int i = 0; i < products.length; i++) {
            integrand[i] = (LinearProduct) products[i].integrand();
        }
        return new Polynomial(integrand);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < products.length; i++) {
            result += products[i].toString() + "+";
        }
        return result.substring(0, result.length()-1);
    }
}
