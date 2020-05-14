package com.string.day2;

public class SumofNum_2 {

	public static void main(String[] args) {
		
		String input = "asdf1qwer9as8d7";
		char arr[] = input.toCharArray();
		int sum = 0;
		for(char d: arr)
		{
			if(Character.isDigit(d) == true )
			{
				sum = sum + Integer.parseInt(String.valueOf(d));
			}
		}
		
		System.out.println("Sum is " + sum);

	}

}
