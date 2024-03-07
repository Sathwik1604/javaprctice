import java.util.Scanner;

public class Info_sec_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the nth prime number: ");
        int p = scan.nextInt();
        long primeP = nthPrime(p);
        System.out.println(p + "th prime number is " + primeP);

        System.out.print("Enter the mth prime number: ");
        int q = scan.nextInt();
        long primeQ = nthPrime(q);
        System.out.println(q + "th prime number is " + primeQ);

        System.out.print("Enter your text: ");
        scan.nextLine(); // Consume newline
        String text = scan.nextLine();

        long n = primeP * primeQ;
        long phi = (primeP - 1) * (primeQ - 1);

        long e = generatePublicKey(phi);
        long d = generatePrivateKey(e, phi);

        System.out.println("\nPublic key = (" + e + ", " + n + ")");
        System.out.println("Private key = (" + d + ", " + n + ")");

        long[] encryptedText = encrypt(text, e, n);
        System.out.print("\nEncrypted Text = ");
        for (long value : encryptedText) {
            System.out.print(value + ", ");
        }
        
        // Decrypt and print the encrypted text
        String decryptedText = decrypt(encryptedText, d, n);
        System.out.println("\nDecrypted Text: " + decryptedText);
    }

    // Method to calculate the nth prime number
    public static long nthPrime(int n) {
        int count = 0;
        long num = 1;
        while (count < n) {
            num++;
            if (isPrime(num)) {
                count++;
            }
        }
        return num;
    }

    // Method to check if a number is prime
    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to generate the public key (e)
    public static long generatePublicKey(long phi) {
        long e = 2; // Start with the smallest possible value for e
        while (e < phi) {
            if (gcd(e, phi) == 1) {
                return e;
            }
            e++;
        }
        return -1; // No suitable public key found
    }

    // Method to generate the private key (d)
    public static long generatePrivateKey(long e, long phi) {
        return modInverse(e, phi);
    }

    // Method to calculate the modular multiplicative inverse
    public static long modInverse(long a, long m) {
        long m0 = m;
        long y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1) {
            long q = a / m;
            long t = m;

            // m is remainder now, process same as Euclid's algorithm
            m = a % m;
            a = t;
            t = y;

            // Update y and x
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }

    // Method to encrypt the text using RSA
    public static long[] encrypt(String text, long e, long n) {
        long[] encryptedText = new long[text.length()];
        for (int i = 0; i < text.length(); i++) {
            encryptedText[i] = powerModulo(text.charAt(i), e, n);
        }
        return encryptedText;
    }

    // Method to perform modular exponentiation
    public static long powerModulo(long base, long exponent, long modulus) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent /= 2;
        }
        return result;
    }

    // Method to decrypt the encrypted text
    public static String decrypt(long[] encryptedText, long d, long n) {
        StringBuilder decryptedText = new StringBuilder();
        for (long value : encryptedText) {
            decryptedText.append((char) powerModulo(value, d, n));
        }
        return decryptedText.toString();
    }

    // Method to calculate the greatest common divisor (GCD)
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
