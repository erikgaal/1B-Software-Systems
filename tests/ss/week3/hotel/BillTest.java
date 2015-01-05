package ss.week3.hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillTest {

    public Bill bill;
    public Voedsel voedsel1;
    public Voedsel voedsel2;

    @Before
    public void setUp() throws Exception {
        bill = new Bill(System.out);
        voedsel1 = new Voedsel("Heel erg vies", Math.random()*100);
        voedsel2 = new Voedsel("Best wel lekker", Math.random()*100);
    }

    @Test
    public void testBill() throws Exception {
        bill.newItem(voedsel1);
        assertEquals(voedsel1.getPrice(), bill.getSum(), 0);
        bill.newItem(voedsel2);
        assertEquals(voedsel2.getPrice() + voedsel1.getPrice(), bill.getSum(), 0);
    }
}