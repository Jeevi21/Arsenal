package com.jv.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LIS - Longest Increasing Subseq
 * @author Jeevi.Natarajan
 *
 */
public class LongestIncreasingSubsequnce {

	
	private static int LISUtil(int [] arr , int st, int length , List<Integer> choosen) {
		
		if(st>=arr.length)
			return length;
		else if(!choosen.isEmpty() && choosen.get(choosen.size()-1) >= arr[st]){
			return LISUtil(arr, st+1, length, choosen); //Not choosing
		}
		else {
			
				choosen.add(arr[st]);
				int lenOnChoosing = LISUtil(arr, st+1, length+1, choosen);
				choosen.remove(choosen.size()-1);
			
				//not choose..
				int lenOnNotChoosing = LISUtil(arr, st+1, length, choosen);
				
				return Math.max(lenOnChoosing, lenOnNotChoosing);
			
		}
		
	}
	
	
	private static int LISUtilDP(int [] arr , int st, int lastElem, Map<String,Integer> cache) {
	
		String key= st+":"+lastElem;
		
		if(st>=arr.length)
			return 0;
		else if(!cache.containsKey(key)) {
			
			int lenOnChoosing =0 ;
			if(lastElem< arr[st]) {
				lenOnChoosing = 1+LISUtilDP(arr, st+1, arr[st],cache);
			}
		
			//not choose..
			int lenOnNotChoosing = LISUtilDP(arr, st+1, lastElem,cache);
			
			cache.put(key, Math.max(lenOnChoosing, lenOnNotChoosing));
		}
		
		return cache.get(key);
	}
	
	private static int LISUtilDPArr(int [] arr , int st, int prevIndex, int [] [] cache) {
		
		if(st>=arr.length)
			return 0;
		else if(cache[st][prevIndex+1]==-1) {
			
			int lenOnChoosing =0 ;
			if(prevIndex<0 || arr[prevIndex]< arr[st]) {
				lenOnChoosing = 1+LISUtilDPArr(arr, st+1, st,cache);
			}
		
			//not choose..
			int lenOnNotChoosing = LISUtilDPArr(arr, st+1, prevIndex,cache);
			
			cache[st][prevIndex+1] =  Math.max(lenOnChoosing, lenOnNotChoosing);
		}
		
		return cache[st][prevIndex+1];
	}

	public static int LIS(int [] arr) {
		
		/*
		Map<String,Integer> cache = new HashMap<String,Integer>();
		int len = LISUtilDP(arr, 0,Integer.MIN_VALUE , cache);
		System.out.println("--cache : " +  cache + "--size : " + cache.size());
		return len;
		*/
		
		int [] [] cache = new int[arr.length+1][arr.length+1];
		Arrays.fill(cache, -1);
		return LISUtilDPArr(arr, 0, -1, cache);
		
		
	}
	
	public static void main(String[] args) {
		int [] arr = {10,9,2,5,3,7,101,18};
		System.out.println("--length  : "  +  LIS(arr));
	}
}
