package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;
/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String string = "Hello World";
        System.out.println(string + ": " + Hex.encodeHexString(string.getBytes()));

        string = "Hello Big World";
        System.out.println(string + ": " + Hex.encodeHexString(string.getBytes()));

        string = "4d6f64756c652032";
        System.out.println(string + ": " + new String(Hex.decodeHex(string.toCharArray())));

        string = "Hello World";
        System.out.println(string + ": " + Base64.encodeBase64String(string.getBytes()));

        string = "010203040506";
        System.out.println(string + ": " + Base64.encodeBase64String(Hex.decodeHex(string.toCharArray())));

        for (int i = 1; i < 10; i++) {
            string = "";
            for (int j = 0; j < i + 1; j++) {
                string += "a";
            }
            System.out.println(string + ": " + Base64.encodeBase64String(string.getBytes()));
        }

        string = "U29mdHdhcmUgU3lzdGVtcw";
        System.out.println(string + ": " + new String(Base64.decodeBase64(string)));
    }
}
