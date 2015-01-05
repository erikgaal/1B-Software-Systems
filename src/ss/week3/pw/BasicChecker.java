package ss.week3.pw;

import java.util.Random;

public class BasicChecker implements Checker {

    private final Random random = new Random();
    StringBuilder builder;

    public static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String numbers = "0123456789";
    public static String characters = letters + numbers;

    public boolean acceptable(String string) {
        return string.length() >= 6 && !string.contains(" ");
    }

    public String generatePass(int length) {
        if (length < 6) return null;
        builder = new StringBuilder();
        for (int i = 0; i < length; i++ ) {
            builder.append(randomCharacter());
        }
        return builder.toString();
    }

    public Character randomLetter() {
        return letters.charAt(random.nextInt(letters.length()));
    }

    public Character randomNumber() {
        return numbers.charAt(random.nextInt(numbers.length()));
    }

    public Character randomCharacter() {
        return characters.charAt(random.nextInt(characters.length()));
    }
}
