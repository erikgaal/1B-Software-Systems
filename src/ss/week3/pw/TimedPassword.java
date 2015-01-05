package ss.week3.pw;

public class TimedPassword extends Password {

    private long created;
    private long validTime;

    public TimedPassword(long validTime) {
        this.created = System.currentTimeMillis();
        this.validTime = validTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - created > validTime;
    }

    /* if we overwrite testPass returning false whenever the password is expired,
     * we will never be able to change the password again */

    public boolean setWord(String oldpass, String newpass) {
        if (super.setWord(oldpass, newpass)) {
            created = System.currentTimeMillis();
            return true;
        }
        return false;
    }
}
