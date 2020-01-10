package com.jv.tree.bst;

public class CandleResidueReuse {
	
	
	static int getTotalCandlesBurnt(int amount, int costOfCandle, int noOfResidueCandles) {
			
		int  candles = amount/costOfCandle;
		
		int totalPurchasedCandles = candles;
		
		while(candles>=noOfResidueCandles) {
			
			int candlesFromResidue = candles / noOfResidueCandles;
			
			int balanceCandles = candles % noOfResidueCandles;
			
			candles = candlesFromResidue + balanceCandles;
			
			totalPurchasedCandles += candlesFromResidue;
		
		}
		
		return totalPurchasedCandles;

    }
	
	
	public static void main(String[] args) {
		
	}

}
