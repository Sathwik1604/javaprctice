import javax.crypto.Cipher;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Scanner;
import java.math.BigInteger; // Added import statement for BigInteger

public class is3 {

    public static void encryptContent(long publicKeyA, long publicKeyB, String content, String outputFilename) throws Exception {
        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(BigInteger.valueOf(publicKeyA), BigInteger.valueOf(publicKeyB));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedContent = cipher.doFinal(content.getBytes());

        try (FileOutputStream fos = new FileOutputStream(outputFilename)) {
            fos.write(encryptedContent);
        }

        System.out.println("Content encrypted and saved as " + outputFilename);
    }

    public static void decryptContent(long privateKeyA, long privateKeyB, String encryptedContentPath, String outputFilename) throws Exception {
        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(BigInteger.valueOf(privateKeyA), BigInteger.valueOf(privateKeyB));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] encryptedContent = Files.readAllBytes(Paths.get(encryptedContentPath));
        byte[] decryptedContent = cipher.doFinal(encryptedContent);

        try (FileOutputStream fos = new FileOutputStream(outputFilename)) {
            fos.write(decryptedContent);
        }

        System.out.println("Content decrypted and saved as " + outputFilename);
    }

    public static void main(String[] args) throws Exception {
        // Replace 'your_last_name' with your actual last name
        String lastName = "your_last_name";

        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Collect public key from the user
        System.out.print("Enter public key (A B): ");
        long publicKeyA = scanner.nextLong();
        long publicKeyB = scanner.nextLong();

        // Collect private key from the user
        System.out.print("Enter private key (A B): ");
        long privateKeyA = scanner.nextLong();
        long privateKeyB = scanner.nextLong();

        // Collect sample text from the user via a text file
        String sampleTextFilename = "sample_text.txt";
        String sampleContent = new String(Files.readAllBytes(Paths.get(sampleTextFilename)));

        // Encrypt the content and save it to a file
        String encryptedFilename = lastName + "_encrypted.txt";
        encryptContent(publicKeyA, publicKeyB, sampleContent, encryptedFilename);

        // Decrypt the encrypted content and save it to another file
        String decryptedFilename = lastName + "_decrypted.txt";
        decryptContent(privateKeyA, privateKeyB, encryptedFilename, decryptedFilename);

        // Close scanner
        scanner.close();
    }
}
