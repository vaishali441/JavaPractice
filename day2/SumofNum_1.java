package com.string.day2;

public class SumofNum_1 {

	public static void main(String[] args) {

		String input = "asdf1qwer9as8d7";
		String num = input.replaceAll("[^0-9]", "");
		char arr[] = num.toCharArray();
		int sum = 0;
		for (char a : arr) {
			int b = Integer.parseInt(String.valueOf(a));
			sum = sum + b;
		}

		System.out.println(sum);

	}

}

//1)
//ascii 
//regeex done
//character.isdigit done

//3)
//char clss
//ascii
//regex