import java.util.*;
public class Stringreverse4 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String [] ar=str.split(" ");
        String str2="";
        for(int i=ar.length-1;i>=0;i--){
            str2=str2+ar[i]+" ";
        }
        System.out.println(str2);
    }
}
