package com.string_regex;

public class Occurence_1 {

	public static void main(String[] args) {
		String word = "Count how many i is in this line";
		char a[] = word.toCharArray();
		int count = 0;
		for (char b : a) {
			if (b == 'i') {
				count++;
			}
		}

		System.out.println("Occurence of i is " + count);
	}

}
