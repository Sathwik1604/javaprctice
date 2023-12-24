
import java.util.*;
public class Binarysearch {
    public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    int []ar={10,15,30,35,40,42,45,50};
    System.out.println("Enter the element to search:");
    int key= scan.nextInt();
    int low=0;
    int high=ar.length-1;
    while(low<=high){
        int mid=(low+high)/2;
        if(ar[mid]==key){
            System.out.println("element found at"+mid+"index");
            break;
        }
        else if(key>ar[mid]){
            low=mid+1;
        }
        else if(key<ar[mid]){
            high=mid-1;
        }
    }
    if(low>high)
    {
        System.out.println("element not found");
    }
    
}

}
