package com.jv.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jeevi.Natarajan
 * 
 * https://leetcode.com/problems/valid-anagram/
 *
 */
public class FindAnagrams {
	
	/**
	 * 
	 *  Arrays.sort(str1);
    	Arrays.sort(str2);
    	return Arrays.equals(str1, str2);  -- to check if arrays are equal.
    
	 */
	
	public boolean isAnagram(String s, String t) {
		
		if(s.length()!=t.length())
			return false;
		
		Map<Character,Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.putIfAbsent(c, 0);
			map.put(c, map.get(c)+1);
		}
		
		for(char c : t.toCharArray()) {
			if(!map.containsKey(c) || map.get(c)<=0)
				return false;
			
			map.put(c, map.get(c)-1);
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		
		
		
	}
}
