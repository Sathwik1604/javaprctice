import java.util.*;
class Constrinhertprac{
    private String name;
    Constrinhertprac(){
        System.out.println("PArent consrtructer");
    }
    void disp(){
        System.out.println("parent method");

    }

}
class Child extends Constrinhertprac{
    void disp2(){

    }
}
class Launch{
    public static void main(String[] args) {
        Child c=new Child();
        c.disp();
    }
}