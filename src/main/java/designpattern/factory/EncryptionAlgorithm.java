package designpattern.factory;

public interface EncryptionAlgorithm {
    String encrypt(String plaintext);

    static String test(String plaintext) {
        return "";
    }
}
