import java.util.*;

public class Information_security_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the pth prime value=");
        int p = scan.nextInt();
        long prime_P = pthPrime(p);
        System.out.println(p + "Th prime number=" + prime_P);

        System.out.print("Enter the qth prime value=");
        int q = scan.nextInt();
        long prime_Q = pthPrime(q);
        System.out.println(q + "th prime number=" + prime_Q);

        System.out.print("Please enter your First name: ");
        scan.nextLine(); 
        String name = scan.nextLine();

        long n = prime_P * prime_Q;
        long tp = (prime_P - 1) * (prime_Q - 1);

        long e = gen_PublicKey(tp);
        long d = gen_PrivateKey(e, tp);

        System.out.println("Public key = (" + e + ", " + n + ")");
        System.out.println("Private key = (" + d + ", " + n + ")");

        long[] encryptedName = encryption(name, e, n);
        System.out.println("Encrypted name = ");
        for (long value : encryptedName) {
            System.out.print(value + ", ");
        }
    }

    public static long pthPrime(int n) {
        int counter = 0;
        long numb = 1;
        while (counter < n) {
            numb++;
            if (is_Prime(numb)) {
                counter++;
            }
        }
        return numb;
    }

    public static boolean is_Prime(long number) {
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

    public static long gen_PublicKey(long tp) {
        long e = 2; 
        while (e < tp) {
            if (hcf(e, tp) == 1) {
                return e;
            }
            e++;
        }
        return -1; 
    }

    public static long gen_PrivateKey(long e, long tp) {
        long d = 1;
        while (true) {
            if ((d * e) % tp == 1) {
                return d;
            }
            d++;
        }
    }

    public static long[] encryption(String name, long e, long n) {
        long[] encryptedText = new long[name.length()];
        for (int i = 0; i < name.length(); i++) {
            encryptedText[i] = Mod_expo(name.charAt(i), e, n);
        }
        return encryptedText;
    }

    public static long Mod_expo(long base, long exponent, long modulus) {
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

