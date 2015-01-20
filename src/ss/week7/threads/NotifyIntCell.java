package ss.week7.threads;

public class NotifyIntCell implements IntCell {

    private int value;
    private boolean written;

    public synchronized void setValue(int val) {
        while (written) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        value = val;
        notifyAll();
        written = true;
    }

    public synchronized int getValue() {
        while (!written) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        written = false;
        notifyAll();
        return value;
    }
}
