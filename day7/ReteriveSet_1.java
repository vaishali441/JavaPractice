package com.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
/*
How to retrieve a value from a Set?
Set = "1,2,3,4,5,6,7,8,9"
retrieve and print only the value - 7
*/
public class ReteriveSet_1 {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);
		s.add(7);
		s.add(8);
		s.add(9);
		
		List<Integer> l = new ArrayList<>(s);
		System.out.println(l.get(6));
	}

}
