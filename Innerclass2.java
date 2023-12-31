//with static keyword
import java.util.*;
class A{
     void Show(){
        System.out.println("in show mwthod");
    }
    static class B{
         void config(){
            System.out.println("in config");
        }
    }
}
class Innerclass2 {
    public static void main(String[] args) {
        A obj=new A();
        obj.Show();
        
        A.B obj1;
        obj1=new A.B();
        obj1.config();
    }
}
