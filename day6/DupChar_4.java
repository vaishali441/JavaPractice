package com.day6;

import java.util.Arrays;

public class DupChar_4 {

	/*1. Write a java program to print the duplicate character using Collections Framework.

	Input: "When life gives you lemons, make lemonade"
	*/
	public static void main(String[] args)
	{
       String input = "When life gives you lemons, make lemonade";
       char a[] = input.toCharArray();
       Arrays.sort(a);
       for(int i = 0 ;  i < a.length-1 ; i++)
       {
    	  if(a[i]==a[i+1])
    	  {
    		  System.out.print(a[i]);
    	  }
       }
       
	}

}
