package day11_12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//array is used to store the collection of data of same type with fixed length

public class Array_1 {

	public static void main(String[] args) {
		
		//1) How to create an array
		int a[] = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		
		for(int i =0 ; i <a.length ; i++)
		{
			System.out.println(a[i]);
		}
		
		//2) How to create an array
		
		int a1[]= {4,5,6};
		
		for(int g : a1)
		{
			System.out.println(g);
		}
		
		
		//ArraySort and Reverse - method 1
		System.out.println("------ArraySort--------------");
		Integer[] array = {5,1,33,79,22,11,45};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));  //[1, 5, 11, 22, 33, 45, 79]
		
		
		System.out.println("-------Reversal of Array---------");
		
		  Collections.reverse(Arrays.asList(array)); 
         System.out.println(Arrays.asList(array));		 //[79, 45, 33, 22, 11, 5, 1]
		  System.out.println(Arrays.toString(array));    //[79, 45, 33, 22, 11, 5, 1]
		  
		//ArraySort and Reverse - method 2
		 System.out.println("---------------METHOD---2------------------"); 
		 int a2[] = {2,5,8,4,23,90,549,237};
		 Arrays.sort(a2);
		 for(int i = 0 ; i <a2.length;i++)
		 {
			 System.out.print(a2[i] + " ");
		 }
		 
		 //reverse
		 System.out.println();
		 for(int i = a2.length-1 ; i>=0 ; i--)
		 {
			 
			 System.out.print(a2[i] + " ");
		 }
				
		
	}

}
