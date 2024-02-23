import java.util.*;
public class Informationsecurity5 {
    public String keygeneration(int len) {
        Random random = new Random();
        StringBuilder key = new StringBuilder();
        for(int ind=0;ind<len;ind++){
            key.append((char) (random.nextInt(256)));
        }
        String str=key.toString();
        return str;
    }
    public String encrypt(String message, String key) {
        StringBuilder encryptedText = new StringBuilder();
        for(int ind=0;ind<message.length( );ind++){
            encryptedText.append((char) (message.charAt(ind) ^ key.charAt(ind)));
        }
        String str2=encryptedText.toString();
        return str2;
    }
    public static void main(String args []) {
        Scanner scan = new Scanner(System.in);
        System.out.print("please enter the secret message to encrypt:");
        String smessage = scan.nextLine();
       Informationsecurity5 obj=new Informationsecurity5();
        String key = obj.keygeneration(smessage.length());
       Informationsecurity5 obj2=new Informationsecurity5();
        String ciphertext = obj2.encrypt(smessage, key);

        System.out.println(" generated key is:"+key);
        System.out.println(" obtained ciphertext is:" + ciphertext);

    }
}
