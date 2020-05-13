package com.string_regex;

public class Occurence_2 {

	public static void main(String[] args) {
		String word = "Count how many i is in this line";
		String replacedword = word.replaceAll("[^i]", "");
		System.out.println(replacedword);
		System.out.println(replacedword.length());

	}

}
