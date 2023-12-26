import java.util.*;
class Dog{
    private String name;
    private int cost;
    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }
    public void setName(String name){
        this.name=name;
    } 
    public void setCost(int cost){
        this.cost=cost;
    }
}
public class PracticeSetter{
    public static void main(String[] args) {
        Dog d=new Dog();
        d.setName("chitinaidu");
        System.out.println(d.getName());
        d.setCost(1000);
        System.out.println(d.getCost());
    }

}