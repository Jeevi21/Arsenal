package com.jv.string;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class LongestSubstringWithoutRep {

	 public int lengthOfLongestSubstring(String s) { //O(n*k)
	        
	        Queue<Character> queue  = new ArrayDeque<>();
	        int maxLength =0;
	        
	        for(char c : s.toCharArray()){
	            
	            if(queue.contains(c)){ //rep found.  - O(k)
	                
	                while(!queue.isEmpty() && queue.peek()!=c){
	                    queue.poll();
	                }
	                queue.poll(); //removing the last char 
	            }
	            
	            queue.add(c);
	            
	            maxLength = Math.max(maxLength,queue.size()); //I update it all the times. 
	        }
	        
	        return maxLength;
	    }
	 
	 
	 public int lengthOfLongestSubstringWithMap(String s) { //O(n) 
	        
	       Map<Character,Integer> map = new HashMap<>();
	        int maxLength =0;
	        int st=0;
	        for(int end=0;end<s.length();end++){
	            
	            if(map.containsKey(s.charAt(end)) && st <= map.get(s.charAt(end)) ){ //Rep found.
	                
	                st = map.get(s.charAt(end)) +1; //setting the st to repeated-char +1
	                
	            }
	            
	            map.put(s.charAt(end),end);
	            maxLength = Math.max(maxLength,(end-st)+1);
	        }
	        
	        return maxLength;
	    }
	
	public static void main(String[] args) {
		
	}

}
