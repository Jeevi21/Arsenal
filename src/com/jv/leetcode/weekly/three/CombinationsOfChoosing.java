package com.jv.leetcode.weekly.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is part of this leetcode question
 * https://leetcode.com/contest/weekly-contest-169/problems/verbal-arithmetic-puzzle/
 * 
 * 
 * @author Jeevi.Natarajan
 *
 */
public class CombinationsOfChoosing {
	
	
	public void printAllpossibleMappings(List<Character> list , int index , List<Integer> availableDigits ,Map<Character,Integer> map) {
		
		if(index>=list.size() || availableDigits.isEmpty()) {
			System.out.println(map);
		}else {
			
			char curChar = list.get(index);
			for(int i=0;i<availableDigits.size();i++) {
				int digit = availableDigits.remove(i); //By removing the digit from the list. I am making it unavailable for the other chars(recursion)
				map.put(curChar, digit);
				printAllpossibleMappings(list, index+1, availableDigits, map);
				//Now add the digit back.
				availableDigits.add(i,digit);
			}
		}
	}
	

	public static void main(String[] args) {
		CombinationsOfChoosing com = new CombinationsOfChoosing();
		
		List<Character> list = new ArrayList<>(Arrays.asList('A','B','C'));
		
		List<Integer> availableDigits  = IntStream.range(0, 10).boxed().collect(Collectors.toList());
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		
		com.printAllpossibleMappings(list, 0, availableDigits, map);
		
	}
}
