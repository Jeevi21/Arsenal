package com.jv.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jeevi.Natarajan
 * 
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 */
public class TwoSum {

	
	
	public static int [] twoSum(int [] arr , int x) {
		Map<Integer,Integer> map = new HashMap<>(); // Have to return the indexes.
		
		for(int i=0;i<arr.length;i++) {
			
			if(map.containsKey(arr[i])) {
				int [] res = new int[2];
				res[0] = i;
				res[1] = map.get(arr[i]);
				
				return res;
			}
			
			map.put(x-arr[i], i);
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
