package com.day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*How to remove duplicates from a list? 
List = "A,B,C,D,A,D,E,F"*/

public class RemDupLst_2 {

	public static void main(String[] args) {
		List<Character> l1 = new ArrayList<>();
	       l1.add('A');
	       l1.add('B');
	       l1.add('C');
	       l1.add('D');
	       l1.add('A');
	       l1.add('D');
	       l1.add('E');
	       l1.add('F');
	       
	       Collections.sort(l1);
	       System.out.println(l1);
	       
	       Object[] array = l1.toArray();
	       
	       for(int i =0 ; i<array.length-1;i++)
	       {
	    	   if(array[i] ==array[i+1])
	    	   {
	    		   l1.remove(i);
	    	   }
	       }
	       
	       System.out.println(l1);
	}

}
