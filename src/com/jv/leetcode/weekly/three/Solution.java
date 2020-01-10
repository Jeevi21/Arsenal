package com.jv.leetcode.weekly.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    
    
    private Set<Character> getUniqueChars(String[] words, String result){
        
        Set<Character> set = new HashSet<>();
         for(String str : words){
             for(Character c : str.toCharArray())
                set.add(c);
        }
        
         for(Character c : result.toCharArray())
                set.add(c);
        
        return set;
    }
    
        //Why DP is not possible here? - this looks more like perm. 
    	public boolean isSolvableUtil(List<Character> list , int index , List<Integer> availableDigits ,Map<Character,Integer> map , String[] words, String result) {
    	
    		if(index>=list.size() || availableDigits.isEmpty()) {
    			return isValid(map, words, result);
    		}else {
    			
    			char curChar = list.get(index);
    			for(int i=0;i<availableDigits.size();i++) {
    				int digit = availableDigits.remove(i); //By removing the digit from the list. I am making it unavailable for the other chars(recursion)
    				map.put(curChar, digit);
    				if(isSolvableUtil(list, index+1, availableDigits, map,words,result))
    					return true;
    				//Now add the digit back.
    				availableDigits.add(i,digit);
    			}
    		}
    		
    		return false;
    	}
    
    	private boolean isValid(Map<Character,Integer> currMapping , String[] words, String result) {
    		        
//    		System.out.println(currMapping);
    		int lhs =0;
    	    for(String str : words){
    	    	String cur="0";
    	    	for(char c : str.toCharArray())
    	    		 cur+= currMapping.get(c);
    	        
    	     
    	    	lhs+= Integer.parseInt(cur);
    	    }
    	            
    	        
    	        String cur="0";
    	        for(char c : result.toCharArray()) 
    	        	cur += currMapping.get(c);
    	        
    	        int rhs=Integer.parseInt(cur);
    	               	            
//    	        System.out.println(lhs + " - " + rhs);
    	   return lhs == rhs;         
    	}
    	
    
    public boolean isSolvable(String[] words, String result) {
        
        List<Character> uniqueChars = new ArrayList<Character>();
        uniqueChars.addAll( getUniqueChars(words,result));
       
        List<Integer> availableDigits = IntStream.range(0,10).boxed().collect(Collectors.toList());
        Map<Character,Integer> map = new HashMap<>();
        
        return isSolvableUtil(uniqueChars, 0 , availableDigits, map,words,result);  //
    }
    
    public static void main(String[] args) {
		Solution sol = new Solution();
		String [] words = {"LEET","CODE"};
		String result = "POINT";
		System.out.println("-- " + sol.isSolvable(words, result));
	}
}