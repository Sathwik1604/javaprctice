import java.util.*;
public class Enhancedforloop {
    public static void main(String[] args){
        int []a=new int[5];

    Scanner scan=new Scanner(System.in);
        for(int i=0;i<a.length;i++)
        {
            System.out.println("enter " + i +" element:");
            a[i]=scan.nextInt();
        }
        System.out.println("printing all :");
        for(int elem:a)
        {
            System.out.println(elem);
        }
    }
    
}
