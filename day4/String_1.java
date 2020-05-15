package com.string.day4;

public class String_1 {

	public static void main(String[] args) {
		
		String a = "Welcome";
		String b = "Welcome";
		String c = "welcome";
		
		String d = new String("Welcome");
		
		if(a==d)
		{
			//will not come inside
			System.out.println("== is checking memory location ");
		}
		
		if(a.equals(d))
		{
			//will come inside
			System.out.println(".equals checks content only");
		}
		
		//it is immutable
		System.out.println(a.concat("Test"));
		System.out.println(a);   //will give Welcome

	}

}
