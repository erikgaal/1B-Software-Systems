package ss.week4;

import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTest {

    public int random;

    @Test
    public void testConstant() throws Exception {
        double c = Math.random() * 10;
        Constant f1 = new Constant(c);
        Function f2 = f1.derivative();
        Function f3 = f1.integrand();

        random = (int) (Math.random() * 10);
        assertEquals(c, f1.apply(random), 0);

        random = (int) (Math.random() * 10);
        assertEquals(0, f2.apply(random), 0);

        random = (int) (Math.random() * 10);
        assertEquals(c*random, f3.apply(random), 0);
    }

    @Test
    public void testExponent() throws Exception {
        int c = (int) (Math.random() * 10);
        Exponent f1 = new Exponent(c);
        Function f2 = f1.derivative();
        Function f3 = f1.integrand();

        random = (int) (Math.random() * 10);
        System.out.println("f(x) = " + f1 + ", f(" + random + ") = " + f1.apply(random));
        assertEquals(Math.pow(random, c), f1.apply(random), 0);

        random = (int) (Math.random() * 10);
        System.out.println("f'(x) = " + f2 + ", f'(" + random + ") = " + f2.apply(random));
        assertEquals(c * Math.pow(random, c-1), f2.apply(random), 0);

        random = (int) (Math.random() * 10);
        System.out.println("F(x) = " + f3 + ", F(" + random + ") = " + f3.apply(random));
        assertEquals((1d / (c + 1d)) * Math.pow(random, c+1), f3.apply(random), 0);
    }

    @Test
    public void testSum() throws Exception {
        int n1 = (int) (Math.random() * 10);
        int n2 = (int) (Math.random() * 10);
        Sum f1 = new Sum(new Exponent(n1), new Exponent(n2));
        Function f2 = f1.derivative();
        Function f3 = f1.integrand();

        random = (int) (Math.random() * 10);
        System.out.println("g(x) = " + f1 + ", g(" + random + ") = " + f1.apply(random));
        assertEquals(Math.pow(random, n1) + Math.pow(random, n2), f1.apply(random), 0);

        random = (int) (Math.random() * 10);
        System.out.println("g'(x) = " + f2 + ", g'(" + random + ") = " + f2.apply(random));
        assertEquals(n1*Math.pow(random, n1-1) + n2*Math.pow(random, n2-1), f2.apply(random), 0);

        random = (int) (Math.random() * 10);
        System.out.println("G(x) = " + f3 + ", G(" + random + ") = " + f3.apply(random));
        assertEquals(((1d / (n1 + 1d)) * Math.pow(random, n1+1)) + ((1d / (n2 + 1d)) * Math.pow(random, n2+1)), f3.apply(random), 0);
    }

    @Test
    public void testProduct() throws Exception {
        int n1 = (int) (Math.random() * 10);
        int n2 = (int) (Math.random() * 10);
        Product f1 = new Product(new Exponent(n1), new Exponent(n2));
        Function f2 = f1.derivative();

        random = (int) (Math.random() * 10);
        System.out.println("h(x) = " + f1 + ", h(" + random + ") = " + f1.apply(random));
        assertEquals(Math.pow(random, n1) * Math.pow(random, n2), f1.apply(random), 0);

        random = (int) (Math.random() * 10);
        System.out.println("h'(x) = " + f2 + ", h'(" + random + ") = " + f2.apply(random));
        assertEquals(Math.pow(random, n1) * n2 * Math.pow(random, n2-1) + Math.pow(random, n2) * n1 * Math.pow(random, n1-1), f2.apply(random), 0);
    }

    @Test
    public void testPolynomial() throws Exception {
        int length = 1 + (int) (Math.random() * 9);
        LinearProduct[] products = new LinearProduct[length];
        for (int i = 0; i < length; i++) {
            int c = (int) (Math.random() * 10);
            int n = (int) (Math.random() * 10);
            products[i] = new LinearProduct(new Constant(c), new Exponent(n));
        }
        Polynomial f1 = new Polynomial(products);
        Function f2 = f1.derivative();
        Function f3 = f1.integrand();

        double result;

        random = (int) (Math.random() * 10);
        result = 0;
        for (int i = 0; i < products.length; i++) {
            result += products[i].apply(random);
        }
        System.out.println("i(x) = " + f1 + ", i(" + random + ") = " + f1.apply(random));
        assertEquals(result, f1.apply(random), 0);

        random = (int) (Math.random() * 10);
        result = 0;
        for (int i = 0; i < products.length; i++) {
            result += products[i].derivative().apply(random);
        }
        System.out.println("i'(x) = " + f2 + ", i'(" + random + ") = " + f2.apply(random));
        assertEquals(result, f2.apply(random), 0);

        random = (int) (Math.random() * 10);
        result = 0;
        for (int i = 0; i < products.length; i++) {
            result += products[i].integrand().apply(random);
        }
        System.out.println("I(x) = " + f3 + ", I(" + random + ") = " + f3.apply(random));
        assertEquals(result, f3.apply(random), 0);
    }
}