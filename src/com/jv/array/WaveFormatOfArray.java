package com.jv.array;

import java.util.Arrays;

import com.jv.utils.CommonUtils;

/**
 * https://www.geeksforgeeks.org/sort-array-wave-form-2/
 * @author Jeevi.Natarajan
 *
 */
public class WaveFormatOfArray {
	
	
	public static void waveformat(int [] arr) {
		if(arr==null || arr.length<=1)
			return;
		
		for(int i=1;i<arr.length-1;i=i+2) {
			
			if(arr[i]>arr[i-1]  && arr[i]>arr[i+1])
				continue;
			
			//else exchange it with the max element.
			if(arr[i-1]>arr[i+1]) {
				CommonUtils.swap(arr,i-1,i);
			}
			else {
				CommonUtils.swap(arr,i+1,i);
			}
		}
	
	}
	
	public static void main(String[] args) {
		int [] arr = {10, 90, 49, 2, 1, 5, 23};
		waveformat(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	

}
