package rough;

/*Single action can be performed in 
different ways

polymorphism in java can be performed 
by 
Method overloading and                            Method Overriding 
   Static or Compiletime polymorphism            Dynamic or Runtime polymorphism
*
*
*
*/

public class Polymorphism extends Poly {
	
	
	  public void method(String name)
	  { 
		  System.out.println("method overriding " + name); 
	  }
	 
	public void method(int name)
	{
		System.out.println(name);
	}
	public void method(String name , int nam)
	{
		System.out.println(name + " " + nam);
	}

	public static void main(String[] args) {
		Polymorphism p = new Polymorphism();
        p.method("Vaish"); //---->   //Only in runtime it will decide which method to call 
        p.method(100);              //either own class method or superclass method .That's why
        p.method("Vaish",100);      //That's why its run =time polymorphism
        
	}

}
