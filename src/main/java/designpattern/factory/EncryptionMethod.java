package designpattern.factory;

import org.apache.commons.codec.digest.DigestUtils;

/*
    Note: Just test only, it's not belong to Factory method design pattern
    Cons:
        Big file, no structure.
        No interface expose for 3rd party implementation.
 */
public class EncryptionMethod {
    public String getSha256HexEncrypt(String plaintext) {
        return DigestUtils.sha256Hex(plaintext);
    }

    public String getSha512HexEncrypt(String plaintext) {
        return DigestUtils.sha512Hex(plaintext);
    }

    public String getSha256HexKey() {
        return "256key";
    }

    public String getSha512HexKey() {
        return "512key";
    }
}
