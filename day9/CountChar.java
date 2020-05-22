package day9;

import java.util.HashMap;

public class CountChar {

	public static void main(String[] args) {
     String input = "Karma is powerful than God";
     char b[] = input.toCharArray();
     
     HashMap<Character,Integer> hm = new HashMap<>();
     
     for(char c: b)
     {
    	 if(hm.containsKey(c))
    	 {
    		hm.put(c, hm.get(c)+1) ;
    	 }
    	 else
    	 {
    		 hm.put(c, 1);
    	 }
     }
     
     System.out.println(hm);
     
	}

}
