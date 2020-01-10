package com.jv.array;

import java.util.Arrays;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class InversionCount {

	private static int merge(int [] arr , int st , int mid , int end) {
		int [] tmp = Arrays.copyOf(arr, arr.length);
		
		//(mid-left) + 1
		int left = st;
		int right = mid+1;
		int index = st;
		int count=0;
		while(left<=mid && right<=end) {
			
			if(arr[left] <= arr[right]) {
				tmp[index] = arr[left];
				left++;
			}
			else{//Time to increase the count
				tmp[index] = arr[right++];
				count+=(mid-left)+1;
			}
			index++;
		}
		
		while(left<=mid) {
			tmp[index++]= arr[left++];
		}
		
		while(right<=end) {
			tmp[index++] = arr[right++];
		}
		
		
		return count;
		
	}
	
	private static int mergeUtil(int [] arr, int st , int end) {
		int count =0;
		if(st<end) {
			int mid = (st+end)/2;
			count += mergeUtil(arr, st, mid);
			count += mergeUtil(arr, mid+1, end);
			
			count += merge(arr, st, mid, end);
		}
		
		return count;
	}
	
	public static int inversionCount(int [] arr) {
		return mergeUtil(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int arr[] = { 1, 20, 6, 4, 5 };
		System.out.println("-- inversion count : " + inversionCount(arr));
	}
}
