package ss.week1;

public class MoneyCounterTest {

    private MoneyCounter counter;

    public MoneyCounterTest() {
        counter = new MoneyCounter();
    }

    public void run() {
        testState();
        testChange();
    }

    private void testState() {
        System.out.println("TESTING INIT");
        System.out.println("Initial state: " + counter.getDollars() + "." + counter.getCents());
    }

    private void testChange() {
        System.out.println("TESTING CHANGE");

        counter.add(5, 78);
        System.out.println("added 5.78: " + counter.getDollars() + "." + counter.getCents());

        counter.add(2, 22);
        System.out.println("added 2.22: " + counter.getDollars() + "." + counter.getCents());

        counter.substract(3, 14);
        System.out.println("substracted 3.14: " + counter.getDollars() + "." + counter.getCents());

        counter.add(6, 71);
        System.out.println("added 6.71: " + counter.getDollars() + "." + counter.getCents());
    }

    public static void main(String[] args) {
        MoneyCounterTest test = new MoneyCounterTest();
        test.run();
    }
}
