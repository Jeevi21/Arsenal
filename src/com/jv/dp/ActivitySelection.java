package com.jv.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class ActivitySelection {

	
	public static int getMaxActivity(int [] st , int [] end , int endTime , int index , List<String> choosen , List<List<String>> chossenList) {
		
		if(index>=st.length) {
			
			if(chossenList.isEmpty()) {
				List<String> tmp = new ArrayList<>();
				tmp.addAll(choosen);
				chossenList.add(tmp);
			}
			else if(chossenList.get(0).size()<choosen.size()) {
				chossenList.remove(0);
				List<String> tmp = new ArrayList<>();
				tmp.addAll(choosen);
				chossenList.add(tmp);
			}
			
			
			return 0;
		}
		else {
			
			//Choose 
			
			int c =0;
			if(st[index]>=endTime) {//Only when it is not overlapping..
				choosen.add(st[index] + "," + end[index]);
				c = 1+getMaxActivity(st, end,  end[index], index+1  , choosen , chossenList);
				choosen.remove(choosen.size()-1);
			}
			
			//Dont choose
			int notChoosen = getMaxActivity(st, end, endTime, index+1 ,choosen , chossenList);
			
			int max = Math.max(c,notChoosen);
//			System.out.println(prefix + "( " + endTime +" , " + index + ")" + " -- " + max);
			return max;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		//Sort By st Time.
	
		
		int [] st = {0,1,2,3,3,5,5,6,8,8,12};  //I sorted manually.
		int [] end = {6,4,13,5,8,7,9,10,11,12,14};
		
		List<String> choosen = new ArrayList<>();
		List<List<String>> choosenList = new ArrayList<>();
		System.out.println("-max : " + getMaxActivity(st, end,  Integer.MIN_VALUE, 0 , choosen , choosenList));
		
		System.out.println("-- Choosen List :  " + choosenList);
		
	}
	
	
}
