import java.util.*;
class StringBuffermethods{
    public static void main(String[] args) {
        StringBuffer sb1= new StringBuffer("viratkohli");
        StringBuffer sb2= new StringBuffer("rcb");
        sb1.append("india");
        System.out.println(sb1);
        sb1.append(26);
        System.out.println(sb1);
        sb1.append(26.264);
        sb1.deleteCharAt(4);
        System.out.println(sb1);
        sb1.delete(2,9);
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
        StringBuffer sb3=sb1.insert(2,sb2);
        System.out.println(sb1);
    }
}