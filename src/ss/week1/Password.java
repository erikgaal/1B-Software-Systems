package ss.week1;

/**
 * Representation of a password.
 * @author Erik Gaal
 */
public class Password {

    /**
     * The standard initial password
     */
    public static String INITIAL = "XGDVRNGSFGDF";
    private String password;

    /**
     * Creates a <code>Password</code> set to the initial password.
     */
    public Password() {
        password = INITIAL;
    }

    /**
     * Test if a given string is an acceptable password.
     * @param suggestion
     * @return
     */
    public boolean acceptable(String suggestion) {
        return suggestion.length() >= 6 && !suggestion.contains(" ");
    }

    /**
     * Tests if a given word is equal to the current password.
     * @param test Word that should be tested
     * @return true if <code>test</code> is equal to the current password
     */
    public boolean testWord(String test) {
        return password.equals(test);
    }

    /**
     * Changes this password
     * @param oldpass The current password
     * @param newpass The new password
     * @return <code>true</code> if <code>oldpass</code> is equal to the current password and that <code>newpass</code> is an acceptable password
     */
    public boolean setWord(String oldpass, String newpass) {
        if (testWord(oldpass) && acceptable(newpass)) {
            password = newpass;
            return true;
        }
        return false;
    }
}
