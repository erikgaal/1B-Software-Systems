package ss.week2;

public class ThreeWayLampTest {

    private ThreeWayLamp lamp;

    public ThreeWayLampTest() {
        lamp = new ThreeWayLamp();
    }

    public void run() {
        testState();
        testChange();
    }

    private void testState() {
        System.out.println("TESTING INIT");
        System.out.println("Initial state: " + lamp.getSetting());
    }

    private void testChange() {
        System.out.println("TESTING CHANGE");
        lamp.switchSetting();
        System.out.println("Change 1: " + lamp.getSetting());

        lamp.switchSetting();
        System.out.println("Change 2: " + lamp.getSetting());

        lamp.switchSetting();
        System.out.println("Change 3: " + lamp.getSetting());

        lamp.switchSetting();
        System.out.println("Change 4: " + lamp.getSetting());
    }

    public static void main(String[] args) {
        ThreeWayLampTest test = new ThreeWayLampTest();
        test.run();
    }
}
