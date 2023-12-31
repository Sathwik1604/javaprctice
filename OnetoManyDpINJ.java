import java.util.*;
class Employee{
    String eid;
    String ename;
    String eaddr;
    Employee(String eid,String ename,String eaddr){
        this.eid=eid;
        this.ename=ename;
        this.eaddr=eaddr;

    }

}
class Department{
    private String did;
    private String dname;
    private Employee []emps;
    Department(String did, String dname, Employee[] emps){
        this.did=did;
        this.dname=dname;
        this.emps=emps;
    }
    public void getDepartmentDetails(){
        System.out.println("Department Details:");
        System.out.println("----------");
        System.out.println("Department Id:" +did);
        System.out.println("Department name:" +dname);
        System.out.println();
        System.out.println("Employee details are:");
        for(Employee employee:emps){
            System.out.println("Employee id:"+employee.eid);
            System.out.println("Employee name:"+employee.ename);
            System.out.println("Employee addr:"+employee.eaddr);
        }
    }

}
class OnetoManyDpINJ {
    public static void main(String[] args) {
        Employee e1=new Employee("10", "Sachin", "MI");
        Employee e2=new Employee("18", "kohli", "RCB");
        Employee e3=new Employee("7","dhoni","cse");
        Employee[] emps=new Employee[3];
        emps[0]=e1;
        emps[1]=e2;
        emps[2]=e3;
        Department department=new Department("ipl16","bcci",emps);
        department.getDepartmentDetails();
    }
    
}
