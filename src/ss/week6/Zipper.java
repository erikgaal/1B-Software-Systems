package ss.week6;

public class Zipper {
    /*@
       requires s1 != null & s2 != null;
       requires s1.length() == s2.length();
     */
    public static String zip(String s1, String s2) {
        String result = "";
        for (int i = 0; i < s1.length(); i++) {
            result += Character.toString(s1.charAt(i)) + Character.toString(s2.charAt(i));
        }
        return result;
    }

    public static String zip2(String s1, String s2) throws WrongArgumentException {
        if (s1 == null || s2 == null) throw new TooFewArgumentsException("must pass two command line arguments");
        if (s1.length() != s2.length()) throw new ArgumentLengthsDifferException("length of command line arguments differs ("+ s1.length() + ", " + s2.length() + ")");

        String result = "";
        for (int i = 0; i < s1.length(); i++) {
            result += Character.toString(s1.charAt(i)) + Character.toString(s2.charAt(i));
        }
        return result;
    }


    public static void main(String[] args) {
        String s1 = args.length >= 1 ? args[0] : null;
        String s2 = args.length >= 2 ? args[1] : null;
        try {
            System.out.println(zip2(s1, s2));
        } catch (WrongArgumentException e) {
            e.printStackTrace();
        }
    }
}
