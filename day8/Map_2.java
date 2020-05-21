package day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Map_2 {

	public static void main(String[] args) {
		Map<Character,Integer> m = new HashMap<>();
		m.put('A', 1);
		m.put('B', 2);
		m.put('C', 3);
		m.put('D', 4);
		m.put('E', 5);
		
		for(Entry<Character, Integer> entry : m.entrySet())
		{
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

	}

}
