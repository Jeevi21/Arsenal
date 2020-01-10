package com.jv.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class SubsetSum {

	private static void subsetSumUtil(int [] list , int st,  int target , List<Integer> choosen) {
		
		if(target==0) {
			System.out.println(choosen);
		}
		else if(st<list.length) {
			
			choosen.add(list[st]);
			subsetSumUtil(list, st+1 , target - list[st], choosen); //choosen
			choosen.remove(choosen.size()-1);
			
			subsetSumUtil(list, st+1, target, choosen); //not-choosen
			
		}
	}
	
	public static void subsetSum(int [] list , int target) {
		
		List<Integer> choosen = new ArrayList<Integer>();
		
		subsetSumUtil(list, 0, target, choosen);
		
	}
	
	public static void main(String[] args) {
		
		int [] list = {1,2,3};
		subsetSum(list, 3);
	}
}
