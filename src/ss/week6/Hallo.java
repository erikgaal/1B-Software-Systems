package ss.week6;

import java.util.Scanner;

public class Hallo {

    private String name;

    public Hallo() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            name = in.next();
        }
    }

    public String toString() {
        return "Hello, " + name;
    }

    public static void main(String[] args) {
        System.out.println(new Hallo());
    }
}
