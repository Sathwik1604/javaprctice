class MyThread extends Thread{  
    public void run(){  
    System.out.println("run method"); 
    } 
    public void start(){  
    System.out.println("start method"); 
    } 
    } 
    class multithread1{ 
    public static void main(String... args){  
    MyThread t=new MyThread(); 
    t.start(); 
     System.out.println("Main method"); 
    } 
    } 