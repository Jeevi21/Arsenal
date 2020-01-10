package com.jv.leetcode.weekly.oneseventy;

import java.util.HashMap;
import java.util.Map;

class Solution {
	
	
	private int minIns(char [] str , int st , int end , Map<String,Integer> cache) {
		
		if(st>end)
			return 0;
		
		String key= st+":"+end;
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		else {
			
			int res=0;
		
			if(str.length<=1)
				res =0;
			if(str.length==2) {
				if(str[st]==str[end])
					res = 0;
				else
					res= 1;
			}
			if(str[st]==str[end])
				res = minIns(str, st+1, end-1,cache);
			else
				res= Math.min(Math.min(2+minIns(str, st+1, end-1,cache), 1+minIns(str, st+1, end,cache)),1+minIns(str, st, end-1,cache));
			
			cache.put(key, res);
			return res;
		}
	}
	
    public int minInsertions(String s) {
        Map<String,Integer> cache = new HashMap<>();
    	return minIns(s.toCharArray(), 0, s.length()-1,cache);
    }
    
    public static void main(String[] args) {
		
    	Solution sol = new  Solution();
    	
    	System.out.println("-- : " + sol.minInsertions("leetcode"));
	}
}