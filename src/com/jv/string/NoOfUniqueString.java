package com.jv.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * HackerRank
 * @author Jeevi.Natarajan
 *
 */
public class NoOfUniqueString {
	
	public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
	  
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int st=0;st<s.length();st++) {
			for(int end=st+minLength ; end<=st+maxLength;end++) {
				
				if(end<=s.length()) {
					String subString = s.substring(st, end); //I have my substring here...
					if(subString.length()<maxUnique || getUniqueCharacters(subString)<=maxUnique) {//add it to map
						map.putIfAbsent(subString, 0);
						map.put(subString, map.get(subString)+1);
					}	
				}
			}
		}
		
	    //Now return the max value..
		
		System.out.println("--map : " + map);
		
		int max =0;
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			
			if(entry.getValue()>max)
				max = entry.getValue();
			
		}
		
		
		return max;

	}
	
	
	private static int getUniqueCharacters(String str) {
		
		Set<Character> set = new HashSet<>();
		for(char c : str.toCharArray()) {
			set.add(c);
		}
		
		return set.size();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("--" + getMaxOccurrences("ababab", 2, 3, 4));
	}

}
