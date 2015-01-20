package ss.week7.account;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

    protected double balance = 0d;

    public synchronized void transaction(double amount) throws InterruptedException {
        while (balance - amount < -1000) {
            wait();
        }
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
