package com.jv.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 * 
 * https://leetcode.com/problems/partition-equal-subset-sum/submissions/
 * 
 * 
 * @author Jeevi.Natarajan
 *
 * Find if it is possible to divide the given set into two sets with equal sum. 
 */
public class Partitioning {

	public static boolean partitionUtil(int [] arr , int st , int totalSum , int currSum , String prepend) {
		
		System.out.println(prepend+"PU("+ st + "," + totalSum+","+currSum+")");
		
		if(totalSum==currSum)
			return true;
		else if(st<arr.length && totalSum >= 0 && currSum >=0) {
			
			return partitionUtil(arr, st+1, totalSum-arr[st], currSum+arr[st] , prepend+"-----") || 
					partitionUtil(arr, st+1, totalSum, currSum,prepend+"-----");
		}
		
		return false;
	}
	
	public static boolean partitionUtilDP(int [] arr , int st , int totalSum , int currSum,Map<String,Boolean> cache) {
		
		String key = totalSum+":"+currSum;
		
//		System.out.println(key);
		
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		else {
			
			boolean res = false;
			if(totalSum==currSum) {
				res = true;
			}
			else if(st<arr.length && totalSum >= 0 && currSum >=0) {
				
				res =  partitionUtilDP(arr, st+1, totalSum-arr[st], currSum+arr[st],cache) || 
						partitionUtilDP(arr, st+1, totalSum, currSum,cache);
				
				
				
				/**
				 * cache.computeIfAbsent(key, {function}
				 * 
				 */
				
			}
			
			cache.put(key, res);
			return res;
			
		}
		
	}
	
	public static boolean equalPartitionPossible(int [] arr) {
		int totalSum = Arrays.stream(arr).reduce(0, Integer::sum);
		Map<String,Boolean> cache = new HashMap<String , Boolean>();
		
		//System.out.println("--back " + partitionUtil(arr, 0, totalSum, 0,""));
		
		boolean res =  partitionUtilDP(arr, 0, totalSum, 0,cache);
		
		//System.out.println("--map : " + cache);
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {91,4,44,50,6,63,63,92,33,68,92,27,16,96,65,51,71,90,25,56,42,49,68,4,59,29,90,6,47,83,44,32,2,51,36,80,50,12,14,13,41,66,93,83,3,58,65,96,18,4,78,100,72,66,7,49,43,67,80,87,83,35,65,47,40,28,51,45,31,73,22,23,15,70,56,77,77,93,84,71,83,16,80,56,5,49,94,50,36,98,89,17,56,52,24,88,14,48,41,61};
		
		System.out.println("-- is partionable : " + equalPartitionPossible(arr));
		
		
	}
	
}
