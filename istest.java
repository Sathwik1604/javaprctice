import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class istest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the nth prime number: ");
        int p = scanner.nextInt();
        System.out.print("Enter the mth prime number: ");
        int q = scanner.nextInt();

        BigInteger nthPrime = nthPrime(p);
        BigInteger mthPrime = nthPrime(q);

        System.out.println(p + "th prime number is " + nthPrime);
        System.out.println(q + "th prime number is " + mthPrime);

        BigInteger[] keys = generateKeys(nthPrime, mthPrime);
        System.out.println("Public key = (" + keys[0] + ", " + keys[2] + ")");
        System.out.println("Private key = (" + keys[1] + ", " + keys[2] + ")");

        scanner.nextLine(); // Consume newline character left from nextInt()

        System.out.print("Enter the filename: ");
        String inputFile = scanner.nextLine();
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "Decrypted.txt";

        try {
            // Read input file
            List<String> lines = readLinesFromFile(inputFile);

            // Encrypt and write to encrypted file
            List<BigInteger> encryptedLines = new ArrayList<>();
            for (String line : lines) {
                BigInteger[] encryptedLine = encrypt(line, keys[0], keys[2]);
                for (BigInteger cipher : encryptedLine) {
                    encryptedLines.add(cipher);
                }
            }
            writeBigIntegersToFile(encryptedLines, encryptedFile);

            // Decrypt and write to decrypted file
            List<String> decryptedLines = new ArrayList<>();
            for (BigInteger cipher : encryptedLines) {
                String decryptedLine = decrypt(cipher, keys[1], keys[2]);
                decryptedLines.add(decryptedLine);
            }
            writeLinesToFile(decryptedLines, decryptedFile);

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

    public static String decrypt(BigInteger cipher, BigInteger d, BigInteger n) {
        byte[] decryptedBytes = cipher.modPow(d, n).toByteArray();
        return new String(decryptedBytes);
    }

    public static List<String> readLinesFromFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static void writeBigIntegersToFile(List<BigInteger> bigIntegers, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (BigInteger num : bigIntegers) {
                writer.write(num.toString());
                
                
                //writer.newLine();
            }
            
        }
    }

    public static void writeLinesToFile(List<String> lines, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                
               // writer.newLine();
            }
            
        }
    }
}
