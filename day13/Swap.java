package day13;

public class Swap {
	
	//swap two numbers without third num

	public static void main(String[] args) {
    int a = 5, b= 10;
    
    a = a+b;
    b= a-b;
    a=a-b;
    System.out.println(a + " " + b);
	}

}
