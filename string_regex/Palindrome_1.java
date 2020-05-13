package com.string_regex;

public class Palindrome_1 {

	public static void main(String[] args) {
        String word = "malayalam";
        String revword = "";
        char arr[] = word.toCharArray();
        int len = word.length();
        for(int i = len-1 ; i >= 0 ; i--)
        {
        	revword = revword + arr[i];
        }
        
        System.out.println(revword);
        if(revword.equalsIgnoreCase(word)) {
        	System.out.println("yes palindrome");
        }
	}

}
