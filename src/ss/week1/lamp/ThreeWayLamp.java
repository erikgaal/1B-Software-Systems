package ss.week1.lamp;

public class ThreeWayLamp {

    private static final int STATES = 4;
    private int setting;

    public ThreeWayLamp() {
        setting = 0;
    }

    public int getSetting() {
        return setting;
    }

    public void setSetting(int setting) {
        this.setting = setting;
    }

    public void switchSetting() {
        setting = (setting++) % STATES;
    }
}