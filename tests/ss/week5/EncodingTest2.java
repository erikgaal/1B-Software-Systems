package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;

public class EncodingTest2 {
    public static void main(String[] args) throws DecoderException {
        System.out.println(Hex.encodeHexString("Hello Big World".getBytes()));

        System.out.println(new String(Hex.decodeHex("4d6f64756c652032".toCharArray()), Charset.forName("UTF-8")));


    }
}
