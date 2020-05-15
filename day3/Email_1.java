package com.regex.day3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_1 {

	public static void main(String[] args) 
	{
       Scanner inp = new Scanner(System.in);
       System.out.println("Enter the mail id");
       String email = inp.nextLine();
       String pattern = "[a-zA-Z0-9._]+@[a-z0-9]+.[a-z]{1,7}"; 
       Pattern compiler = Pattern.compile(pattern);
       Matcher matcher = compiler.matcher(email);
       System.out.println(matcher.matches());
       
       
       
	}

}
