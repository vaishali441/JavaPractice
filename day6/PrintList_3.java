package com.day6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintList_3 {

	public static void main(String[] args) {
		 String a = "Bugatti Chiron";
		 List<Character> l = new ArrayList<>();
		 for(int i = 0 ; i < a.length(); i++)
		 {
			 l.add(a.charAt(i));
		 }
		 
		 Iterator<Character> iterator = l.iterator();
		 while(iterator.hasNext())
		 {
			 System.out.print(iterator.next());
		 }
		 
	}

}
