package com.day6;

import java.util.HashMap;
import java.util.Map.Entry;

/*1. Write a java program to print the duplicate character using Collections Framework.

Input: "When life gives you lemons, make lemonade"
*/


public class DupChar_1 {

	public static void main(String[] args) 
	{
		
		String input = "When life gives you lemons, make lemonade";
		char a[] = input.toCharArray();
		
		HashMap<Character,Integer> m = new HashMap<>();
		for(char b : a)
		{
			if(m.containsKey(b))
			{
			  m.put(b, m.get(b)+1);	
			}
			else
			{
				m.put(b, 1);
			}
			
		}
		
    for(Entry<Character, Integer> entry : m.entrySet())	
    {
    	if(entry.getValue() > 1)
    	{
    		System.out.println(entry.getKey());
    	}
    }

	}

}
