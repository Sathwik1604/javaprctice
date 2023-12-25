import java.util.*;
public class Stringreverse3 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String str=scan.nextLine();
        String str2="";
        String[]ar =str.split(" ");
        for(String elem: ar){
            str2=str2+reverseword(elem);   
        }
        System.out.println(str2);
        
    }
    static String  reverseword(String x){
        int start=x.length()-1;
        String str="";
        while(start>=0){
        str=str+x.charAt(start); 
        start--;
        }
        return str+" ";
    }
    
}
