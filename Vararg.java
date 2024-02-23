class Vararg
 {
 public void methodOne(int ...i){System.out.println("Var arg method");}
 public void methodOne(int i){System.out.println("Int arg method");}
 
 public static void main(String[] args)
 {
Vararg t= new Vararg();
 t.methodOne(10);//Int arg method
 t.methodOne();//Var arg method
 t.methodOne(10,20,30);//Int arg method
 }
 }