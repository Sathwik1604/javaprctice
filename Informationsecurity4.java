import java.util.*;

public class Informationsecurity4 {

    public  String ciphertext(String smessage, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for(char c : smessage.toCharArray()){
            if(Character.isLetter(c)){
                int shift = key % 26;
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) ((c - base + shift) % 26 + base));
            }else{
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    public static void main(String[ ] args){
        Scanner scan= new Scanner(System.in);
        Informationsecurity4 obj=new Informationsecurity4();

        System.out.print("Enter the key: ");
        int key = scan.nextInt();
        scan.nextLine(); 

        System.out.print("Enter secretmessage to encrypt: ");
        String smessage = scan.nextLine();

        String substitutioncipher = obj.ciphertext(smessage, key);
        System.out.println("Encrypted text: " + substitutioncipher);

    }
}
