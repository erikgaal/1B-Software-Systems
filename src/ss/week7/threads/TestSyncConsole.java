package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
    private ReentrantLock lock;

    public TestSyncConsole(String name, ReentrantLock lock) {
        super(name);
        this.lock = lock;
    }

    private void sum() {
        this.lock.lock();
        int n1, n2;
        n1 = SyncConsole.readInt(String.format("Thread %s: Number 1? ", this.getName()));
        n2 = SyncConsole.readInt(String.format("Thread %s: Number 2? ", this.getName()));
        SyncConsole.println(String.format("Thread %s: %s + %s = %s", this.getName(), n1, n2, n1 + n2));
        this.lock.unlock();
    }

    public void run() {
        sum();
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        TestSyncConsole consoleA = new TestSyncConsole("A", lock);
        TestSyncConsole consoleB = new TestSyncConsole("B", lock);
        consoleA.start();
        consoleB.start();
    }
}