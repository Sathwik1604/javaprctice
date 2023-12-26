import java.util.*;
class Student{
    private String name;
    private int age;
    private String city;
    public Student(String name,int age,String city){
        this.name=name;
        this.age=age;
        this.city=city;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCity() {
        return city;
    }
    
}
public class PracticeConstructer {
    public static void main(String[] args) {
        Student std=new Student("sathwik",17,"suryapet");
        System.out.println(std.getAge()+ std.getCity() + std.getName());
    }

    
}
