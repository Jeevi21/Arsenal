package com.jv.tree.bst;

import java.util.HashMap;
import java.util.Map;

public class FirstRepChar {
	
	 public static String firstRepeatingLetter(String s) {
	        Map<Character,Integer> map = new HashMap<>();
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            map.putIfAbsent(c,0);
	            map.put(c,map.get(c)+1);
	        }

	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            if(map.get(c)>1)
	               return c+"";
	        }

	        return null;
	    }


}
