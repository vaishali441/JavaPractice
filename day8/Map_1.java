package day8;

import java.util.HashMap;
import java.util.Map;

public class Map_1 {
	
	/*
	 * Write a Java Program to print the keys and values from the Map map = {A=1,
	 * B=2, C=3, D=4, E=5} (Min 3 ways)
	 * 
	 * Note: Even if you google understand what you are doing!
	 * 
	 * 
	 * output: A->1
	 * 
	 * B->2
	 * 
	 * C->3
	 * 
	 * D->4
	 * 
	 * E->5
	 */


	public static void main(String[] args) {
           
		Map<Character,Integer> m = new HashMap<>();
		m.put('A', 1);
		m.put('B', 2);
		m.put('C', 3);
		m.put('D', 4);
		m.put('E', 5);
System.out.println(m);		
	}

}
