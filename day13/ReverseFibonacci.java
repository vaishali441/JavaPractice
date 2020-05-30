package day13;

public class ReverseFibonacci {
	
	//Print the first 10 fibonacci numbers in reverse order

	//output: 34,21,13,8,5,3,2,1,1,0

	public static void main(String[] args) {
		
		int array[] = new int[10];
		int a = -1 , b=1;
		
		for(int i = 0 ; i<array.length;i++)
		{
			array[i] = a+b;
			a=b;
			b= array[i];
			
		}
		
		for(int j = array.length-1;j>=0 ; j--)
		{
			System.out.println(array[j]);
		}

	}

}
