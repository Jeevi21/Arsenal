package com.jv.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class Knapsack {
	
	
	private static int knapsackUtil(Item [] items , int W , int st) {
		
		if(items.length<=st) {
			return 0;
		}
		else{
			
			//choose
			int choose = 0;
			if(items[st].getWeight()<=W)
				choose = items[st].getValue() + knapsackUtil(items, W-items[st].getWeight(), st+1);
			
			//dont choose
			
			int notChoosen = knapsackUtil(items, W, st+1);
			
			return Math.max(choose, notChoosen);			
		}
		
		
	}
	
	private static int knapsackUtilMemo(Item [] items , int W ,int st , Map<String, Integer> cache) {
		
		String key = st+":"+W;
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		else {
			int maxSum = 0;
			if(st<items.length) {
				
				//dont choose
				int notChoosen = knapsackUtilMemo(items, W , st+1 , cache);
					
				//choose
				int choose = 0;
				if(items[st].getWeight()<=W)
					choose = items[st].getValue() + knapsackUtilMemo(items, W-items[st].getWeight() , st+1 , cache);
				
				return Math.max(choose, notChoosen);
			
			}
			
			cache.put(key, maxSum);
			return maxSum;
		}
		
	}
	
	public static void knapsack(Item [] items  , int W) {
		Map<String,Integer> cache = new HashMap<String, Integer>();
		System.out.println("-- knapsack : " + knapsackUtilMemo(items, W, 0, cache) );
		
		System.out.println("-- My cache : " +  cache);
		
		//System.out.println("-- selectedItems  : " + selectedItems);
	}
	
	public static void main(String[] args) {
		
		Item [] items = { new Item(60, 10) , new Item(100, 20) , new Item(120, 30) };
		
		knapsack(items, 35);
		
		
	}

}

class Item{
	private int value;
	private int weight;
	
	public Item(int value , int weight) {
		this.value = value;
		this.weight = weight;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "[" + this.value + " , " + this.weight +" ] ";
	}
}
