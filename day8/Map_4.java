package day8;

import java.util.HashMap;
import java.util.Map;

public class Map_4 {

	public static void main(String[] args) {
		Map<Character,Integer> m = new HashMap<>();
		m.put('A', 1);
		m.put('B', 2);
		m.put('C', 3);
		m.put('D', 4);
		m.put('E', 5);
		
System.out.println(m.entrySet());	}

}
