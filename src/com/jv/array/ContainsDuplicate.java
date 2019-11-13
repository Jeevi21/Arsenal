package com.jv.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	public static boolean containsDuplicate(int [] arr) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			
			if(!set.add(arr[i]))
			 return true;
		}
		
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		int [] arr = {1,1,2,3};
		
		System.out.println("--contains duplicate : " + containsDuplicate(arr));
		
	}

}
