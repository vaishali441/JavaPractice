package day9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountChar_1 {

	public static void main(String[] args) {
		String input = "Karma is powerful than God";
		Map<Character,Integer> hm = new HashMap<>();
		for(int i = 0 ; i <input.length()-1;i++)
		{
			int count = 0;
			for(int j = 0 ; j<input.length();j++)
			{
				if(input.charAt(i)==input.charAt(j))
				{
					count++;
				}
    				
			}
			
			hm.put(input.charAt(i), count);
			
			
					
		}
		
		System.out.println(hm);
	}

}
