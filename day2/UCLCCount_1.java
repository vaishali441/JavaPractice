package com.string.day2;

public class UCLCCount_1 {

	public static void main(String[] args) {
       String input = "Its Work from Home Not Work for Home";
       
       int uppercase = input.replaceAll("[^A-Z]", "").length() ;
       int lowercase = input.replaceAll("[^a-z]", "").length();
       int numbers = input.replaceAll("[^0-9]", "").length();
       int spaces =   input.replaceAll("[^ ]" , "").length();
       
       System.out.println("uppercase " + uppercase);
       System.out.println("lowercase " + lowercase);
       System.out.println("numbers " + numbers);
       System.out.println("spaces `" + spaces);
       
	}

}
