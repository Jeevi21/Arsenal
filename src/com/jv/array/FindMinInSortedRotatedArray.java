package com.jv.array;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * This is just finding the Pivot point in an array(and not any element)
 * 
 * @author Jeevi.Natarajan
 *
 */
public class FindMinInSortedRotatedArray {
	
	
	private static int finMin(int [] arr , int low , int high) { //Binary search
		
		if(low<=high) {
		
			int mid = (low+high)/2;
			
			if(mid-1 >= 0 && arr[mid]<arr[mid-1])
				return mid;
			else if(arr[low]<arr[mid])
				return finMin(arr, mid+1, high);
			else
				return finMin(arr, low, mid-1);
		
		}
		return -1;
	}

	public static int findMin(int [] arr) {
		
		int res =  finMin(arr, 0, arr.length-1);
		
		return arr[res];
		
	}
	
	
	public static void main(String[] args) {
		
		int [] arr= {6,7,1,2,3,4,5};
		
		System.out.println("--- Pivot point : " + findMin(arr));
		
		
	}
}
