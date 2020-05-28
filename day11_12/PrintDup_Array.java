package day11_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintDup_Array {

	public static void main(String[] args) {
     //to print the duplicate numbers in the array
		int array[] = {4 , 7, 87, 56, 34 , 4, 98,56,23 , 98, 4};
		
		System.out.println("------Method-1----------------");
		Arrays.sort(array);
		Set<Integer> s = new HashSet<>();
		for(int i =0 ; i<array.length-1 ; i++)
		{
			if(array[i] == array[i+1])
			{
				s.add(array[i]);
			}
		}
		
		System.out.println(s);
		
		System.out.println("--------------Method-2-----------");
		Set<Integer> s1 = new HashSet<>();
		for(int j = 0 ; j<array.length-1; j++)
		{
			for(int k =j+1 ; k<array.length ; k++)
			{
				if(array[j] == array[k] )
				{
					s1.add(array[k]);
				}
				
			}
			
		}
		
		System.out.println(s1);
	}

}
