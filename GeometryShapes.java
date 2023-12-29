import java.util.*;
abstract class Shapes{
    float area;
    abstract public void input();
    abstract public void compute();
    public void disp(){
        System.out.println("the area is "+area);
    }
}
class Rectangle extends Shapes{
    float length;
    float breadth;
    Scanner scan=new Scanner(System.in);
    public void input(){
        System.out.println("Enter the value of length:");
             length=scan.nextFloat();
        System.out.println("Enter the value of breadth:");
             breadth=scan.nextFloat();

    }
    public void compute(){
        area=length*breadth;

    }
}
class GeometryArea{
    void permit(Shapes s){
        s.input();
        s.compute();
        s.disp();
    }
}
class GeometryShapes{
    public static void main(String[] args){
        Rectangle rectangle=new Rectangle();
        //GeometryArea ga=new GeometryArea();
       // ga.permit(rectangle);
       rectangle.input();
       rectangle.compute();
       rectangle.disp();
       
        
    }
}