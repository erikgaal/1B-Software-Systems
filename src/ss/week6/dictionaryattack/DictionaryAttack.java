package ss.week6.dictionaryattack;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DictionaryAttack {
    private Map<String, String> passwordMap;
    private Map<String, String> hashDictionary;

    public DictionaryAttack() {
        passwordMap = new HashMap<>();
    }

    /**
     * Reads a password file. Each line of the password file has the following form:
     * username: encodedpassword
     *
     * After calling this method, the passwordMap class variable should be filled with
     * the content of the file. The key for the map should be the username and the
     * password hash should be the content.
     * @param filename
     */
    public void readPasswords(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                if (line != null) passwordMap.put(line.split(": ")[0], line.split(": ")[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Given a password, return the MD5 hash of a password. The resulting
     * hash (or sometimes called digest) should be hex-encoded in a String.
     * @param password
     * @return
     */
    public String getPasswordHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return Hex.encodeHexString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Check the password for the user the password list. If the user does not exist,
     * return false.
     * @param user
     * @param password
     * @return whether the password for that user was correct.
     */
    public boolean checkPassword(String user, String password) {
        return (passwordMap.get(user) != null && passwordMap.get(user).equalsIgnoreCase(getPasswordHash(password)));
    }

    /**
     * Reads a dictionary from file (one line per word) and use it to add entries to
     * a dictionary that maps password hashes (hex-encoded) to the original password.
     * @param filename filename of the dictionary.
     */
    public void addToHashDictionary(String filename) {
        try {
            hashDictionary = new HashMap<>();
            Scanner in = new Scanner(new File(filename));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                hashDictionary.put(getPasswordHash(line), line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Do the dictionary attack.
     */
    public void doDictionaryAttack() {
        for (String username : passwordMap.keySet()) {
            for (String hash : hashDictionary.keySet()) {
                if (passwordMap.get(username).equalsIgnoreCase(hash)) System.out.println(username + ": " + hashDictionary.get(hash));
            }
        }
    }
    public static void main(String[] args) {
        DictionaryAttack da = new DictionaryAttack();
        da.readPasswords("passwords");
        da.addToHashDictionary("commonpw");
        da.doDictionaryAttack();
    }
}