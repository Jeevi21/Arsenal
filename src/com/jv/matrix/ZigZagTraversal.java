package com.jv.matrix;

/**
 * 
 * @author Jeevi.Natarajan
 *
 *
 *	1 2 3 4
 *  5 6 7 8 
 *  9 10 11 12
 *  13 14 15 16
 *  
 *  
 *  1. Print the above matrix as  1 2 3 4     8 7 6 5   9 10 11 12        16 15 14 13
 *  2. From below - 13 14 15 16       12 11 10 9      5 6 7 8   4 3 2 1
 *
 */
public class ZigZagTraversal {
	
	public static void printZigZagfromAbove( int [][] matrix) {
		
		boolean flag = false;
		int N =matrix.length;
		for(int i=0;i<N;i++) {
			
			if(flag) { //reverse
				
				for(int j=N-1;j>=0;j--) {
					System.out.print( matrix[i][j] +" ");
				}
					
			}
			else {
				for(int j=0;j<N;j++) {
					System.out.print( matrix[i][j] +" ");
				}
			}	
				
			flag = !flag;
			System.out.println();
			
		}
		
		
		
	}
	
public static void printZigZagfromBelow( int [][] matrix) {
		
		boolean flag = false;
		int N =matrix.length;
		for(int i=N-1;i>=0;i--) {
			
			if(flag) { //reverse
				
				for(int j=N-1;j>=0;j--) {
					System.out.print( matrix[i][j] +" ");
				}
					
			}
			else {
				for(int j=0;j<N;j++) {
					System.out.print( matrix[i][j] +" ");
				}
			}	
				
			flag = !flag;
			System.out.println();
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		int [] [] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		printZigZagfromAbove(matrix);
		System.out.println("---------------------------------");
		printZigZagfromBelow(matrix);
		
	}

}
