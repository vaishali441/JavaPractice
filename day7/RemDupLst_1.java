package com.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemDupLst_1 
{
	/*
	 * 1. How to remove duplicates from a list? 
	 * List = "A,B,C,D,A,D,E,F"
	 */
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
       System.out.println(l1);
       
       Set<Character> a = new HashSet<>(l1);
       System.out.println(a);
       
	}

}
