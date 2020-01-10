package com.jv.utils;

public class CommonUtils {
	
	public static void swap(int [] arr, int indexi , int indexj) {
		
		int tmp = arr[indexi];
		arr[indexi] = arr[indexj];
		arr[indexj] = tmp;
		
	}
	
	public static int swap(int a , int b) {
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		return a;
	}
	
	
	public static void main(String[] args) {
		int a= 5;
		int b=10;
		
		a = swap(b, b=a); //Left to  right.
		
		System.out.println(a);
		System.out.println(b);
	}

}
