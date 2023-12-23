import java.util.*;
class Fan{
    int cost;
    String brand;
    int noOfWings;
}
class Launch{
    public static void main(String[] args)
    {
        Fan[] fan=new Fan[3];
        fan[0]= new Fan();
        fan[1]=new Fan();
        fan[2]=new Fan();
        fan[0].cost=100;
        fan[0].brand="usha";
        fan[0].noOfWings=3;
        System.out.println(fan[0].brand);

    }
}