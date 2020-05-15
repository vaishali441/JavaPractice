package com.regex.day3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Username_1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the username");
		String uname = input.nextLine();
		String pattern = "[a-zA-Z0-9]{8,}+";
		Pattern compiler = Pattern.compile(pattern);
		Matcher matcher = compiler.matcher(uname);
		System.out.println(matcher.matches());
				
		

	}

}
