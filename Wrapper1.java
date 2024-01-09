public class Wrapper1 {
    public static void main(String[] args) {
        Integer i1=Integer.valueOf("100",2);
        System.out.println(i1);
    
        System.out.println("Max_Radix=>" +Character.MAX_RADIX);
        System.out.println("Min_Radix=>"+Character.MIN_RADIX);

    }
    
}
/*
 output:
 4
 Max_Radix=>36
 Mix_Radix=>2
 */