package com.day6;

import java.util.HashSet;
import java.util.Set;

/*1. Write a java program to print the duplicate character using Collections Framework.

Input: "When life gives you lemons, make lemonade"
*/

public class DupChar_2 {

	public static void main(String[] args) {
		
String input = "When life gives you lemons, make lemonade";

char a[] = input.toCharArray();

Set<Character> s = new HashSet();

for(char b : a)
{
	if(!s.add(b))
	{
		System.out.print(b);
	}
}

System.out.println(s);
	}

}
