package day11_12;

public class ArrAverage {
	
	//Average of an array

	public static void main(String[] args) {
		int[] array= {20, 30, 25, 35, -16, 60, -100};
		
		System.out.println("----------Method1----------------");
		int length = array.length;
		int sum = 0;
		int avg = 0;
		for(int i = 0 ; i<length ; i++)
		{
			sum += array[i];
		}
		System.out.println(sum);
		avg = sum /length;
		System.out.println(avg);
		
		System.out.println("---------Method2-----------");
		int sum1 = 0,avg1=0;
		
		for(int a : array)
		{
			sum1 = sum1 + a;
		}
		avg1 = sum /length;
		System.out.println(avg1);
		
	}

}
