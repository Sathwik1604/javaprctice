class ConstrSupThisInher {
    int a,b,c;
    ConstrSupThisInher(){
        a=10;
        b=20;
        System.out.println("Parent Constructer");
    }
    ConstrSupThisInher(int a,int b){
        this.a=a;
        this.b=b;
        System.out.println("parent para const");
    }
}
class Child extends ConstrSupThisInher{
    int x,y;
    Child(){
        this(111,222);
        x=100;
        y=200;
    }
    Child(int x,int y){
        super(x,y);
        this.x=x;
        this.y=y;
    }
    void disp(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(x);
        System.out.println(y);
    }
}
class Launch{
    public static void main(String[] args){
        Child c=new Child();
        c.disp();
    }
}
