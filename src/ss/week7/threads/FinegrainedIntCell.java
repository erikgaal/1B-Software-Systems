package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {

    private int value;
    private ReentrantLock lock;
    private Condition write;
    private Condition read;
    private boolean written;

    public FinegrainedIntCell() {
        lock = new ReentrantLock();
        write = lock.newCondition();
        read = lock.newCondition();
    }

    public void setValue(int val) {
        lock.lock();
        while (written) {
            try {
                write.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        value = val;
        written = true;
        read.signal();
        lock.unlock();
    }

    public int getValue() {
        lock.lock();
        while (!written) {
            try {
                read.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int temp = value;
        written = false;
        write.signal();
        lock.unlock();
        return temp;
    }
}
