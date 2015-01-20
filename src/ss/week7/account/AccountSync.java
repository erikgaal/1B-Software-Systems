package ss.week7.account;

public class AccountSync {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        MyThread threadA = new MyThread(25, 200, account);
        MyThread threadB = new MyThread(-25, 200, account);

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println(account.getBalance());
    }
}
