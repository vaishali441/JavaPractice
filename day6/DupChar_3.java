package com.day6;

import java.util.ArrayList;

/*1. Write a java program to print the duplicate character using Collections Framework.

Input: "When life gives you lemons, make lemonade"
*/

public class DupChar_3 {

	public static void main(String[] args) {

		String input = "When life gives you lemons, make lemonade";
		char a[] = input.toCharArray();
		
		ArrayList<Character> al = new ArrayList<>();
		for(char c : a)
		{
			if(!al.contains(c))
			{
				al.add(c);
			}
			else
			{
				System.out.print(c);
			}
		}
	}

}
