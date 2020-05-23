package day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map_2 {

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put("vaishali", 100);
		m.put("Seetha", 80);
		m.put("Ram", 56);
		m.put("vani", 75);
		m.put("vinoth", 45);

		System.out.println(m); // {vani=75, vaishali=100, Seetha=80, Ram=56, vinoth=45}

		System.out.println(m.entrySet()); // [vani=75, vaishali=100, Seetha=80, Ram=56, vinoth=45]

		Set s = m.entrySet(); // Each of these set elements i s a Map.Entry object
		Iterator i = s.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());

		}

		/*
		 * vani=75 
		 * vaishali=100 
		 * Seetha=80 
		 * Ram=56 
		 * vinoth=45
		 */

		Iterator i1 = s.iterator();
		  while(i1.hasNext()) 
		  {
		   Map.Entry map = (Map.Entry)i1.next(); 
		   Object key = map.getKey(); 
		   System.out.println(key); 
		   }
		  
		/*
		 * vani 
		 * vaishali 
		 * Seetha 
		 * Ram 
		 * vinoth
		 */
		  
		  Map m1 = new LinkedHashMap(); 
		  m1.put("vaishali", 100); 
		  m1.put("Seetha", 80);
		  m1.put("Ram", 56); 
		  m1.put("vani", 75); 
		  m1.put("vinoth", 45);
		  
		  System.out.println(m1); // {vaishali=100, Seetha=80, Ram=56, vani=75, vinoth=45}
		  
		  LinkedHashMap lm = new LinkedHashMap();
		  lm.put(null, null);
		  lm.put(null, 1);  //{null=1}
		  lm.put("kkl", null); //{null=1, kkl=null}
		  
		  System.out.println(lm);
		 

	}

}
