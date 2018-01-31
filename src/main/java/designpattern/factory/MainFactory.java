package designpattern.factory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;


// https://dzone.com/articles/java-the-factory-pattern
public class MainFactory {
    public static void main(String[] args){
        String filename = Paths.get(".").toAbsolutePath().normalize().toString() + "/test.txt";
        System.out.println("Output: " + filename);

//        C1: many algorithm, each algorithm generate a Creator (Encryptor) to initialize a algorithm.
        PersistedFile file = new PersistedFile(filename, "Hello, world!", new Sha256Encryptor());
        file.persist();

//        C2: generate one Factory to initialize all algorithm.
        EncryptionAlgorithm subEng = EncryptionFactory.getEncryptionAlgorithmm("256");
        System.out.println("Encryption output: " + subEng.encrypt("Hello, world!"));

//        Note: Before Factory method dp, just test only, it's not belong to Factory method design pattern
//        doBusiness(filename, "Hello, world!", "256");
    }

    public static void doBusiness(String filename, String content, String encryptAlgorithm) {
        String cyphertext = "";
        String key = "";

        switch (encryptAlgorithm){
            case "256":
                EncryptionMethod en256 = new EncryptionMethod();
                cyphertext = en256.getSha256HexEncrypt(content);
                key = en256.getSha256HexKey();
                break;
            case "512":
                EncryptionMethod en512 = new EncryptionMethod();
                cyphertext = en512.getSha512HexEncrypt(content);
                key = en512.getSha512HexKey();
                break;
            default:
                break;

        }
        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            outputStream.write(cyphertext.getBytes());
            outputStream.write(key.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
