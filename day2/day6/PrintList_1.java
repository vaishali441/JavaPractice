package com.day6;

import java.util.ArrayList;
import java.util.List;

/*Write a java program to print the list (Need 3 different answers)

Input: [B,u,g,a,t,t,i, ,C,h,i,r,o,n]*/

public class PrintList_1 {

	public static void main(String[] args) {
    String a = "Bugatti Chiron";
    List<Character> l = new ArrayList<>();
    for(int i = 0 ; i<a.length(); i++)
    {
    	l.add(a.charAt(i));
    }
    
    System.out.println(l);
    
	}

}
