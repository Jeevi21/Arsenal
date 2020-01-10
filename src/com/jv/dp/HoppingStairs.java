package com.jv.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/contests/juniper-hackathon/challenges/hopping-jack
 * @author Jeevi.Natarajan
 *
 */
public class HoppingStairs {
	
	public static int hops(int curStep , int N , int K , int hopNum) {
		
		if(hopNum>N)
		return curStep;
		else {
			
			int left =0;
			if(curStep+hopNum!=K)
				left = hops(curStep+hopNum, N, K, hopNum+1);
			
			return Math.max(left, hops(curStep, N, K, hopNum+1));
		}
		

		
	}
	
	public static int hopsDP(int curStep , int N , int K , int hopNum , Map<String , Integer> cache) {
		
		String key = curStep+":"+hopNum;
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		else {
			int res = curStep;
			if(hopNum<=N) {
				
				int left =0;
				if(curStep+hopNum!=K)
					left = hopsDP(curStep+hopNum, N, K, hopNum+1,cache);
				
				res = Math.max(left, hopsDP(curStep, N, K, hopNum+1,cache));
				
			}
			cache.put(key, res);
			return res;
		}
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("--back : " + hops(0, 2, 1, 0));
		
		Map<String,Integer> cache = new HashMap<String, Integer>();
		
		System.out.println("--Dp : " + hopsDP(0, 2, 1, 0, cache));
	}

}
