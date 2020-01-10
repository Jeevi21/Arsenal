package com.jv.leetcode.weekly.two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MaxNumOfSubStrings {
	
		private int getUniqueChars(String s) {
			Set<Character> set  = new HashSet<>();
			
			for(Character c : s.toCharArray()) {
				set.add(c);
			}
			
			return set.size();
		}
	    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
	    	
	    	Map<String,Integer> map = new HashMap<>();


	    	for(int st =0 ; st< s.length();st++) {
	    		
		    	int end = st+minSize;
			    while(end<=st+maxSize && end<s.length()) {
			    	
			    		String str = s.substring(st,end);
			    		if(getUniqueChars(str)<=maxLetters) {
			    			
			    			map.putIfAbsent(str, 0);
			    			map.put(str, map.get(str)+1);
			    		}
			    			
			    		
			    		end++;
			    }
		    	
	    	}
	    
	    	int max =0;
	    	
	    	for(Entry<String, Integer> entry : map.entrySet()) {
	    		if(max<entry.getValue())
	    			max=entry.getValue();
	    	}
	    	
	    	return max;
	    }
	    
	    
	    public static void main(String[] args) {
			String str ="aababcaab";
			MaxNumOfSubStrings s = new MaxNumOfSubStrings();
			
			System.out.println(s.maxFreq(str, 2, 3, 4));
		}
	
}
