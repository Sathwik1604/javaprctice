//without static keyword
import java.util.*;
class A{
    public void Show(){
        System.out.println("in show mwthod");
    }
    class B{
        public void config(){
            System.out.println("in config");
        }
    }
}
public class Innerclass1 {
    public static void main(String[] args) {
        A obj=new A();
        obj.Show();
        
        A.B obj1=obj.new B();
        obj1.config();
    }
}
