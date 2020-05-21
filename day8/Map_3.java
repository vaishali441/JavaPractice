package day8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Map_3 {

	public static void main(String[] args) {
		Map<Character,Integer> m = new HashMap<>();
		m.put('A', 1);
		m.put('B', 2);
		m.put('C', 3);
		m.put('D', 4);
		m.put('E', 5);
		
		Iterator<Entry<Character,Integer>> it = m.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Character,Integer> e=it.next();
			System.out.println(e.getKey() + "=" + e.getValue());
		}
	}

}
