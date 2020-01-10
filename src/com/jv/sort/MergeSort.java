package com.jv.sort;

import java.util.Arrays;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class MergeSort {
	

	private static void merge(int [] arr , int st , int mid ,  int end) {
		//I have 2 arrays here. 
		int [] res = Arrays.copyOf(arr, arr.length);
		
		int left = st;
		int right = mid+1;//I think this was the mistake.
		int index = st;
		
		while(left<=mid && right<=end) {
			
			if(res[left]<=res[right]) {
				arr[index]=res[left];
				left++;
			}
			else {
				arr[index]=res[right];
				right++;
			}
			index++;
		}
		
		while(left<=mid) {
			arr[index++] = res[left++];
		}
		
		while(right<=end) {
			arr[index++] = res[right++];
		}
		
	}
	
	private static void mergeSortUtil(int [] arr, int st , int end) {
		if(st<end) {
			int mid = (st+end)/2;
			mergeSortUtil(arr, st, mid);
			mergeSortUtil(arr, mid+1, end);
			merge(arr, st, mid, end);
		}
		
	}
	
	public static void mergeSort(int [] arr) {
		mergeSortUtil(arr, 0, arr.length-1);
		
	}
	
	public static void main(String[] args) {
		int [] arr = {10,2,3,1,40,30};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
