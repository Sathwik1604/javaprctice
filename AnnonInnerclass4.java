import java.util.*;
abstract class Computer{
    public abstract void config();
}
class AnnonInnerclass4{
    public static void main(String[] args) {
        Computer obj=new Computer() {
            public void config(){
                System.out.println("its working");
            }
        };
            obj.config();
    }
}