package ss.week3.pw;

public class Password {

    private String password;
    private Checker checker;
    private String initPass;

    public Password() {
        this(new BasicChecker());
    }

    public Password(Checker checker) {
        this.checker = checker;
        initPass = checker.generatePass(8);
        password = initPass;
    }

    public boolean acceptable(String suggestion) {
        return checker.acceptable(suggestion);
    }

    public boolean testWord(String test) {
        return password.equals(test);
    }

    public String getInitPass() {
        return initPass;
    }

    public Checker getChecker() {
        return checker;
    }

    public boolean setWord(String oldpass, String newpass) {
        if (testWord(oldpass) && acceptable(newpass)) {
            password = newpass;
            return true;
        }
        return false;
    }
}
