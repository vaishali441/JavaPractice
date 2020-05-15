package com.regex.day3;

public class Username_2 {

	public static void main(String[] args) 
	{
      String uname = "Vaishali#9";
      String pattern = "[a-zA-Z0-9@$._#]{8,}+";
      System.out.println(uname.matches(pattern));
      
	}

}
