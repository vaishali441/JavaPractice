package com.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 1. How to remove duplicates from a list? 
 * List = "A,B,C,D,A,D,E,F"
 */

public class RemDupLst_3 {

	public static void main(String[] args) {
		
		List<String> a = new ArrayList<>();
	       a.add("A");
	       a.add("B");
	       a.add("C");
	       a.add("D");
	       a.add("A");
	       a.add("D");
	       a.add("E");
	       a.add("F");
	       List<String> al = new ArrayList<>(a);     
	 for(int i = 0; i<al.size();i++)
	 {
		 String letter = al.get(i);
		 int count =0;
		 for(int j = 0; j<al.size();j++)
		 {
			 if (al.get(j)==letter)
			 {
				 count++;
			 }
		 }
		 
		 if(count > 1)
		 {
			 al.remove(letter);
		 }
	 }
	 
	 System.out.println(al);
	       
	   
	}

}
