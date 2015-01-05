package ss.week3;

import java.io.PrintStream;

public class Format {

    public static void printLine(String text, double amount, PrintStream out) {
        if (text != null && out != null) {
            out.printf("%-20.20s%10.2f\n", text, amount);
        }
    }

    public static void main(String[] args) {
        printLine("hehehehe", 20.86, System.out);
        printLine("hehe", 1.87, System.out);
        printLine("hehehehehehe", -32.87, System.out);
    }
}
