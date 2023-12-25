import java.util.*;
public class Stringreverse2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str1=scan.nextLine();
        String str2=" ";
        int len=str1.length();
        int i=(str1.length()-1);
        int j=0;
        while(i>=0){
            str2= str2+str1.charAt(i);
            i--;
            j++;
        }
        System.out.println(str2);
    }
    
}
