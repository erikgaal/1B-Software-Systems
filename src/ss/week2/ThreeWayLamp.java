package ss.week2;

public class ThreeWayLamp {

    public enum State {
    	OFF, LOW, MEDIUM, HIGH
    }
    
    private State setting;

    public ThreeWayLamp() {
        setting = State.OFF;
    }

    /*@pure */
    public State getSetting() {
        return setting;
    }

    public void setSetting(State setting) {
        this.setting = setting;
    }

    /* @ensures \old(getSetting() == State.OFF ==> getSetting() == State.LOW;
     * @ensures if (\old(getSetting()) == State.LOW) { getSetting() == State.MEDIUM };
     * @ensures if (\old(getSetting()) == State.MEDIUM) { getSetting() == State.HIGH };
     * @ensures if (\old(getSetting()) == State.HIGH) { getSetting() == State.OFF };
     */
    public void switchSetting() {
        switch (setting) {
            case OFF:
                setting = State.LOW;
                break;
            case LOW:
                setting = State.MEDIUM;
                break;
            case MEDIUM:
                setting = State.HIGH;
                break;
            case HIGH:
                setting = State.OFF;
                break;
        }

    }
}