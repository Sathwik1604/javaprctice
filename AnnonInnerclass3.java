class Computer{
    public void config(){
        System.out.println("in computer config");
    }
}
class SecondCode{
    public static void main(String[] args) {
        Computer obj=new Computer()
        {
            public void config(){
             System.out.println("in computer config");
            }
            
        };
        obj.config();
    
        
    }
}
