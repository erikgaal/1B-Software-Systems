package ss.week4;

public class Homework {

    public static void main(String[] args) {
        LinearProduct f1 = new LinearProduct(new Constant(4), new Exponent(4));
        Function f2 = f1.integrand();
        Function f3 = f1.derivative();
        System.out.println("f(x) = " + f1 + ", f(8) = " + f1.apply(8));
        System.out.println("F(x) = " + f2 + ", F(8) = " + f2.apply(8));
        System.out.println("f'(x) = " + f3 + ", f'(8) = " + f3.apply(8));
    }
}
