import java.io.*;

public class InSec2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample_text.txt"));
            BufferedWriter encryptWriter = new BufferedWriter(new FileWriter("Challa_encrypted.txt"));
            BufferedWriter decryptWriter = new BufferedWriter(new FileWriter("Challa_Decrypted.txt"));

            // Read prime numbers from input file
            int p = Integer.parseInt(reader.readLine());
            int q = Integer.parseInt(reader.readLine());

            long primeP = pthPrime(p);
            long primeQ = pthPrime(q);

            long n = primeP * primeQ;
            long tp = (primeP - 1) * (primeQ - 1);

            long e = genPublicKey(tp);
            long d = genPrivateKey(e, tp);

            // Write encryption code to file
            encryptWriter.write("Public key = (" + e + ", " + n + ")\n");
            encryptWriter.write("Encrypted Text = ");

            // Write decryption code to file
            decryptWriter.write("Private key = (" + d + ", " + n + ")\n");
            decryptWriter.write("Decrypted Text = ");

            reader.readLine(); // Skip blank line
            String text = reader.readLine();

            // Encrypt and write encrypted text to file
            long[] encryptedText = encryption(text, e, n);
            for (long value : encryptedText) {
                encryptWriter.write(value + " ");
            }

            // Decrypt and write decrypted text to file
            String decryptedText = decryption(encryptedText, d, n);
            decryptWriter.write(decryptedText);

            reader.close();
            encryptWriter.close();
            decryptWriter.close();

            System.out.println("Encryption and Decryption codes have been written to files successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static long pthPrime(int n) {
        int counter = 0;
        long numb = 1;
        while (counter < n) {
            numb++;
            if (isPrime(numb)) {
                counter++;
            }
        }
        return numb;
    }

    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long genPublicKey(long tp) {
        long e = 2; 
        while (e < tp) {
            if (hcf(e, tp) == 1) {
                return e;
            }
            e++;
        }
        return -1; 
    }

    public static long genPrivateKey(long e, long tp) {
        long d = 1;
        while (true) {
            if ((d * e) % tp == 1) {
                return d;
            }
            d++;
        }
    }

    public static long[] encryption(String text, long e, long n) {
        long[] encryptedText = new long[text.length()];
        for (int i = 0; i < text.length(); i++) {
            encryptedText[i] = modExpo(text.charAt(i), e, n);
        }
        return encryptedText;
    }

    public static String decryption(long[] encryptedText, long d, long n) {
        StringBuilder decryptedText = new StringBuilder();
        for (long value : encryptedText) {
            decryptedText.append((char) modExpo(value, d, n));
        }
        return decryptedText.toString();
    }

    public static long modExpo(long base, long exponent, long modulus) {
        long res = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                res = (res * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent /= 2;
        }
        return res;
    }

    public static long hcf(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
