package designpattern.factory;

public class EncryptionFactory {
    public static EncryptionAlgorithm getEncryptionAlgorithmm(String encryptAlgorithm) {
        switch (encryptAlgorithm){
            case "256":
                return new Sha256CEncryptionAlgorithm();
            case "512":
                return new Sha512EncryptionAlgorithm();
            default:
                break;
        }
        return null;
    }
}
