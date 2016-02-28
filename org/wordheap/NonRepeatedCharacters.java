package org.wordheap;

import java.util.HashMap;
import java.util.Map.Entry;

public class NonRepeatedCharacters {

	
	NonRepeatedCharacters(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = str.toLowerCase().trim().toCharArray();
		for(char c:chars) {
			if(map.get(c) !=null && map.get(c)>0) {
				map.put(c, new Integer(map.get(c)+1));
			} else
				map.put(c,1);
		}			
		
		map.forEach((k,v)-> System.out.println(k+" times: "+ v));
		
		for(char c:chars) {
			if(map.get(c) == 1) {
				System.out.println("First non-repeated character: "+c);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new NonRepeatedCharacters("arsenal");
		//new NonRepeatedCharacters("SocioNocturnal");
	}
}
