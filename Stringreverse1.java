import java.util.*;
public class Stringreverse1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the string:");
        StringBuffer sen= new StringBuffer();
        sen=sen.append(scan.nextLine());
        sen.reverse();
        System.out.println(sen);
    }
}
