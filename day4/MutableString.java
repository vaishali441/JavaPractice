package com.string.day4;

public class MutableString {

	public static void main(String[] args) {
		/*
		 * StringBuffer -Threadsafe and StringBuilder - not Threadsafe
		 * preferred when there is need of data security
		 */
		
		StringBuffer b = new StringBuffer("Welcome");
		System.out.println(b);
		b.append("To Testleaf");
		System.out.println(b);    //mutable
		
		
	}

}
