package co.borucki.mycv.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Encryption {
    private MD5Encryption() {
    }

    public static String encrypt(String s) {
        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(s.getBytes(), 0, s.length());
            return new BigInteger(1,md5.digest()).toString(16);

        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
