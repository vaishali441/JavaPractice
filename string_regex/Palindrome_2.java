package com.string_regex;

public class Palindrome_2 {

	public static void main(String[] args) {
     String word = "madam";
     StringBuffer word1 = new StringBuffer();
     word1.append(word);
     StringBuffer rev = word1.reverse();
     System.out.println(rev);
     if(rev.toString().equalsIgnoreCase(word))
     {
    	 System.out.println("yes palindrme");
     }
     
	}

}
