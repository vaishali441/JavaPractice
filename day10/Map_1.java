package day10;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Map_1 {

	public static void main(String[] args) {
     HashMap<Character,Integer> hm = new HashMap<>();
     hm.put(null, null);
     hm.put('P', 5);
     System.out.println(hm);  //{null=null, P=5}
    Set s =  hm.keySet();   //[null, P]
    System.out.println(s);
     
     Hashtable<Character,Integer> ht = new Hashtable<>();
     ht.put('F', 4);
     System.out.println(ht);// {F=4}
     
     TreeMap<Character,Integer> tm = new TreeMap<>();
     tm.put('D', null);
     tm.put(null, null);
     System.out.println(tm);
     
     
     
	}

}
