package java8Basics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class RemoveDuplicatesWithoutChangingOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Call taxi";
		char b[] = input.toCharArray();
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		for(char a:b)
		{
			if(map.containsKey(a))
			{
				map.put(a, map.get(a)+1);
			}
			else
				map.put(a, 1);
		}
		
		for(Entry<Character, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey());
		}
	}

}
