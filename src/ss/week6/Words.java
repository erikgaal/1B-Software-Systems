package ss.week6;

import java.util.Scanner;

public class Words {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean running = true;

        System.out.print("Line (or \"end\"): ");
        while (in.hasNextLine()) {
            int i = 1;
            String line = in.nextLine();
            if (line.startsWith("end")) break;
            for (String word : line.split(" ")) {
                System.out.println("Word " + i + ": " + word);
                i++;
            }

            System.out.print("Line (or \"end\"): ");
        }
        System.out.println("End of programme.");
    }
}
