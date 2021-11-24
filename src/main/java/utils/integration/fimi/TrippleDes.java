package utils.integration.fimi;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TrippleDes {

    public static String encode(String vector) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] secretKey = "9mng65v8jf4lxn93nabf981m".getBytes();

        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "TripleDES");
        var initVector = vector.getBytes();
        IvParameterSpec ivSpec = new IvParameterSpec(initVector);
        String secretMessage = "DB_TEST1";
        Cipher encryptCipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
        byte[] secretMessagesBytes = secretMessage.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessagesBytes);
        return Base64.encodeBase64String(encryptedMessageBytes);
    }

//    private static final String UNICODE_FORMAT = "UTF8";
//    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
//    private KeySpec ks;
//    private SecretKeyFactory skf;
//    private Cipher cipher;
//    byte[] arrayBytes;
//    private String myEncryptionKey;
//    private String myEncryptionScheme;
//    SecretKey key;
//
//    public TrippleDes() throws Exception {
//        myEncryptionKey = "D9D038A9";
//        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
//        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
//        ks = new DESedeKeySpec(arrayBytes);
//        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
//        cipher = Cipher.getInstance(myEncryptionScheme);
//        key = skf.generateSecret(ks);
//    }
//
//
//    public String encrypt(String unencryptedString) {
//        String encryptedString = null;
//        try {
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
//            byte[] encryptedText = cipher.doFinal(plainText);
//            encryptedString = new String(Base64.encodeBase64(encryptedText));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return encryptedString;
//    }
//
//
//    public String decrypt(String encryptedString) {
//        String decryptedText = null;
//        try {
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] encryptedText = Base64.decodeBase64(encryptedString);
//            byte[] plainText = cipher.doFinal(encryptedText);
//            decryptedText = new String(plainText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptedText;
//    }
//
//
//    public static void main(String args[]) throws Exception {
//        TrippleDes td = new TrippleDes();
//
//        String target = "imparator";
//        String encrypted = td.encrypt(target);
//        String decrypted = td.decrypt(encrypted);
//
//        System.out.println("String To Encrypt: " + target);
//        System.out.println("Encrypted String:" + encrypted);
//        System.out.println("Decrypted String:" + decrypted);
//
//    }

}