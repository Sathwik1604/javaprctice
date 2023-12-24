import java.util.*;
public class Linearsearch {
    public static void main(String[] args)
    {
        boolean flag=false;
        Scanner scan=new Scanner(System.in);
        int []a=new int[5];
        System.out.println("enter the values:");
        for(int i=0;i<a.length;i++)
        {
            a[i]=scan.nextInt();
        }
        System.out.println("enter the number to find:");
        int key=scan.nextInt();


        for(int i=0;i<a.length;i++)
        {
            if(key==a[i])
            {
                System.out.println("we found key at "+ i+ "index");
                flag=true;
                break;
            }

        }
        if(flag==false)
        {
            System.out.println("element not found");
        }

    }
}
