package com.string.day2;

public class SumofNum_3 {

	public static void main(String[] args) {
		String input = "asdf1qwer9as8d7";
		char arr[] = input.toCharArray();
		int sum = 0;

		for (char b : arr) {
			int a = b;
			if ((a >= 48) && (a <= 57)) {

				sum = sum + Integer.parseInt(String.valueOf(b));
			}

		}

		System.out.println(sum);
	}

}
