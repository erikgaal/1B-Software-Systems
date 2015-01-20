package ss.week7;

public class ConcatThread extends Thread {

    private static String text = "";
    private String toe;

    public ConcatThread(String toe) {
        this.toe = toe;
    }

    public void run() {
        synchronized (text) {
            text = text.concat(toe);
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        (new ConcatThread("one;")).start();
        (new ConcatThread("two;")).start();
    }
}
