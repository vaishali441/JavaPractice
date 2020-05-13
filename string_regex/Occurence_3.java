package com.string_regex;
import java.util.HashMap;
import java.util.Map.Entry;

public class Occurence_3 {

	public static void main(String[] args) {

		HashMap<Character, Integer> hm = new HashMap<>();
		String word = "Count how many i is in this line";
		char arr[] = word.toCharArray();

		for (char a : arr) {
			if (hm.containsKey(a)) {
				hm.put(a, hm.get(a) + 1);
			} else
				hm.put(a, 1);
		}

		for (Entry entry : hm.entrySet()) {
			if (entry.getKey().equals('i')) {
				System.out.println(entry.getValue());
			}
		}
	}

}
