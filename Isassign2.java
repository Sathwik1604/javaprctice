import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Isassign2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the pth prime number:");
        int p = scanner.nextInt();
        System.out.print("Enter the qth prime number:");
        int q = scanner.nextInt();

        BigInteger nthPrime = nthPrime(p);
        BigInteger mthPrime = nthPrime(q);

        System.out.println("calculated"+p + "th prime number:" + nthPrime);
        System.out.println("calculated"+q + "th prime number:" + mthPrime);

        BigInteger[] keys = generateKeys(nthPrime, mthPrime);
        System.out.println("Public_key = ("+keys[0]+","+keys[2]+")");
        System.out.println("Private_key = ("+keys[1]+","+keys[2]+")");

        scanner.nextLine(); 

        System.out.print("Enter the filename which need to be encrypted: ");
        String inputFile = scanner.nextLine();
        String encryptedFile = "Challa_encrypted.txt";
        String decryptedFile = "Challa_Decrypted.txt";

        try {
            String inputText = readTextFromFile(inputFile);
            BigInteger[] encryptedText = encrypt(inputText, keys[0], keys[2]);
            writeBigIntegersToFile(encryptedText, encryptedFile);

            String decryptedText = decrypt(encryptedText, keys[1], keys[2]);
            writeTextToFile(decryptedText, decryptedFile);

            System.out.println("Encryption and decryption completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static BigInteger nthPrime(int n) {
        BigInteger num = BigInteger.ONE;
        for (int count = 0; count < n; num = num.add(BigInteger.ONE)) {
            if (num.isProbablePrime(100)) {
                count++;
            }
        }
        return num.subtract(BigInteger.ONE);
    }

    public static BigInteger[] generateKeys(BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        BigInteger phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = BigInteger.valueOf(2);
        while (e.compareTo(phi_n) < 0 && !e.gcd(phi_n).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }

        BigInteger d = e.modInverse(phi_n);

        return new BigInteger[]{e, d, n};
    }

    public static BigInteger[] encrypt(String text, BigInteger e, BigInteger n) {
        byte[] bytes = text.getBytes();
        BigInteger[] encryptedText = new BigInteger[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encryptedText[i] = BigInteger.valueOf(bytes[i]).modPow(e, n);
        }
        return encryptedText;
    }

    public static String decrypt(BigInteger[] encryptedText, BigInteger d, BigInteger n) {
        StringBuilder decryptedText = new StringBuilder();
        for (BigInteger cipher : encryptedText) {
            byte[] decryptedBytes = cipher.modPow(d, n).toByteArray();
            decryptedText.append(new String(decryptedBytes));
        }
        return decryptedText.toString();
    }

    public static String readTextFromFile(String filename) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }

    public static void writeBigIntegersToFile(BigInteger[] bigIntegers, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (BigInteger num : bigIntegers) {
                writer.write(num.toString());
                writer.newLine();
            }
        }
    }

    public static void writeTextToFile(String text, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(text);
        }
    }
}
