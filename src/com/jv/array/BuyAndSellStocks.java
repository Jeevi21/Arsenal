package com.jv.array;

/**
 * 
 * 
 * 1 3 7 10 2 5 3 8
 * 
 * He can buy and sell only once.
 * 
 * @author Jeevi.Natarajan
 *
 */
public class BuyAndSellStocks {

	public static int getMaxProfit(int[] stocks) { // First let me find profit.

		int maxProfit = 0;
		int currMin = Integer.MAX_VALUE;
		int max = stocks[stocks.length-1];

		// If the stock is continuously falling down... Then buying and selling it on
		// same day will be the profitable venture. - we are avoiding loss here.

		for (int i = stocks.length - 1; i >= 0; i--) {

			currMin = Math.min(currMin, stocks[i]);

			int profit = max - currMin;
			if (stocks[i] > max) {
				max = stocks[i];
				currMin = stocks[i];
			}
			maxProfit = Math.max(maxProfit, profit);

		}

		return maxProfit;

	}

	public static void main(String[] args) {

		int[] stocks = { 1, 3, 7, 10, 2, 5, 3, 8 };
		System.out.println("--max profit : " + getMaxProfit(stocks));

	}

}
