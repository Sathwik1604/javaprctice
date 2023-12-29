import java.util.*;
//Dependent object
class Account{
    String accNo;
    String accName;
    String accType;
    Account(String accNo,String accName,String accType){
        this.accNo=accNo;
        this.accName=accName;
        this.accType=accType;

    }
}
class Employee{
    private String eid;
    private String ename;
    private String eaddr;
    Account account;
    //Constructer Injection
    public Employee(String eid,String ename,String eaddr,Account account){
        
        this.eid=eid;
        this.ename=ename;
        this.eaddr=eaddr;
        this.account=account;
    }
    public void getEmployeeDetails(){
        System.out.println("Employee Details::");
        System.out.println("Emp ID:"+eid);
        System.out.println("Emp Name"+ ename);
        System.out.println("Emp Addr" + eaddr);
        System.out.println("-----------");
        System.out.println("Account details:");
        System.out.println("ACC No:" +account.accNo);
        System.out.println("Acc Name:"+account.accName);
        System.out.println("Acc Type:"+account.accType);
    }
}
class OnetoOneDpINJ{
    public static void main(String[] args) {
        Account account= new Account("ABCD123","SAchin","SAvings");
        //Constructor Injection
        Employee employee =new Employee("Ind10","sachin","MI",account);
        employee.getEmployeeDetails();
    }
}