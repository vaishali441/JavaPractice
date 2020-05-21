package com.day6;

import java.util.ArrayList;
import java.util.List;

public class PrintList_2 {
	
	/*Write a java program to print the list (Need 3 different answers)

	Input: [B,u,g,a,t,t,i, ,C,h,i,r,o,n]*/

	public static void main(String[] args) {
        String a = "Bugatti Chiron";
        char arr[] =a.toCharArray();
        List<Character> l = new ArrayList<>();
        for(char b : arr)
        {
        	l.add(b);
        }
        
        System.out.println(l);
	}

}
