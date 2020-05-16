import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class Map_1 {
	
	/*
	 * difference between hashmap and hastable 
	 * Hashmap                                Hashtable
	 *                               
	 * hashmap is non synchronized            hashtable is synchronized 
	 * and not threadsafe                     and threadsafe
	 * 
	 * one null key and                       no null key or null value
	 * multiple null values allowed
	 * 
	 * fast                                   slow
	 * 
	 * 
	 * inherits abstractMAp                   inherits Dictionary class
	 */

	public static void main(String[] args) {
		
		HashMap<Integer, Character>  hm = new HashMap<Integer, Character>();
		hm.put(1, null);
		hm.put(null, null);    
		//hm.put(null,'p' );   - {null=null, 1=null}
		
		System.out.println(hm);
		
		//o/p-  {null=p, 1=null}
		
		Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
		ht.put(1, "Kavya");
		//ht.put(null, null);
		System.out.println(ht);   //java.lang.NullPointerException
		
		
		//Sorting of keys using treemap
		
		TreeMap<String,Integer> map = new TreeMap<>();
		map.put("Jayant", 80); 
        map.put("Abhishek", 90); 
        map.put("Anushka", 80); 
        map.put("Amit", 75); 
        map.put("Danish", 40); 
        
        System.out.println(map);
        
        //o/p- Abhishek=90, Amit=75, Anushka=80, Danish=40, Jayant=80}

        
        
		
		
		

	}

}
