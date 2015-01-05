package ss.week3.pw;

public class StrongChecker extends BasicChecker {

    public boolean acceptable(String string) {

        /* regex
         * [A-Za-z]     any letter
         * .*           any character (except newlines)
         * [0-9]        any number
         */
        return super.acceptable(string) && string.matches("^[A-Za-z].*[0-9]$");
    }

    public String generatePass(int length) {
        if (length < 6) return null;
        builder = new StringBuilder();
        for (int i = 0; i < length; i++ ) {
            builder.append(randomCharacter());
        }
        builder.setCharAt(0, super.randomLetter());
        builder.setCharAt(length-1, super.randomNumber());
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StrongChecker().generatePass(12));
    }
}
