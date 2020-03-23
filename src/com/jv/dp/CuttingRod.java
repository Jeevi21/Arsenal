package com.jv.dp;

/**
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 * @author Jeevi.Natarajan
 *
 */
public class CuttingRod {

	public static int cutRod(int [] prices , int len , int st){
	
		if(len==0 || st>=prices.length){
			return 0;
		}
		else{
		int maxProfit =0;
			for(int i=1;i<=len-2  && st+i< prices.length; i++){
				
				int curProfit = Math.max(prices[st+i-1] + cutRod(prices , len-i , st+i) , cutRod(prices,len,st+i));
				maxProfit = Math.max(maxProfit,curProfit); 

			}
			
			return maxProfit;
		}
	
	}
	
	public static void main(String [] args) {
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("--maxprofit :" + cutRod(arr,arr.length,0));
	}
	
	
}
