package com.string_regex;

public class Occurence_4 {

	public static void main(String[] args) {
		String word = "Count how many i is in this line";
		int length = word.length();
		int count = 0;
		for(int i = 0 ; i< length ; i++)
		{
			if(word.charAt(i) == 'i')
			{
				count++;
			}
		}
		System.out.println(count);
	}

}
