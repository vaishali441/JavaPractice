package com.string.day2;

public class UCLCCount_3 {

	public static void main(String[] args) {
		String input = "Its Work from Home Not Work for Home";
		char arr[] = input.toCharArray();
		int numcount = 0,uc_cnt = 0,lc_cnt = 0,space_cnt = 0;
		
		for(char b: arr)
		{
			if(Character.isDigit(b))
			{
				numcount = numcount + 1;
			}
			else if(Character.isUpperCase(b))
			{
				uc_cnt = uc_cnt + 1;
			}
			else if(Character.isLowerCase(b))
			{
				lc_cnt = lc_cnt + 1;
			}
			if(b == ' ')
			{
				space_cnt = space_cnt + 1;
			}
		}
		
		System.out.println("numcount " + numcount);
		System.out.println("uc_cnt " + uc_cnt);
		System.out.println("lc_cnt " + lc_cnt);
		System.out.println("space_cnt " + space_cnt);
	}

}
