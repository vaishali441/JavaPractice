package day10;

import java.util.HashMap;
import java.util.Map;

public class Methods {

	public static void main(String[] args) {
        Map m =new HashMap();
        m.put(1, 'a');
        m.put(2, 'b');
      System.out.println(  m.containsKey(1));
      System.out.println(m.containsValue('b'));
      System.out.println(m.get(1));
      System.out.println(m.size());
      System.out.println(m.isEmpty());
      System.out.println(m.replace(1, 'c'));
      System.out.println(m);
	
		System.out.println(m.remove(2)); 
		System.out.println(m);
		m.clear(); 
		System.out.println(m.isEmpty());
		 
        
	}

}
