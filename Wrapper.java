class Wrapper{
    public static void main(String[] args) {
      Integer i1= Integer.valueOf(10);
        System.out.println(i1);
        Integer i2=Integer.valueOf("10");
        System.out.println(i2);
        Boolean b1=Boolean.valueOf("sachin");
        System.out.println(b1);
        Integer i3=Integer.valueOf("ten"); 
        // number format exception
        System.out.println(i3);
    }
}

//output:
/*
 10
 10
 false
 NumberFormatException
 */