package com.jv.jobscheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainScheduling {
	
	
	public static int minNoOfPlatformsRequired(List<Interval> intervals) {
		
		intervals.sort((a,b)-> a.getSt() - b.getSt()); //Sort based on St time
		
		int platformsRequired =0;
		
		int st=Integer.MAX_VALUE; //TODO check for neg values
		int end = Integer.MIN_VALUE;
		for(int i=1;i<intervals.size();i++){
			
			Interval cur = intervals.get(i);
			
			if(cur.getSt()<end) { //overlap found.
				platformsRequired++;
			}
			
			st = Math.max(st, cur.getSt());
			end = Math.min(end, cur.getEnd());
			
		}
		
		return platformsRequired;
		
	}
	
	public static void main(String[] args) {
	
//		arr[]  = {904, 946, 952, 1100, 1508, 1806}
//		 dep[]  = {915, 1202, 1128, 1135, 1900, 2001}
		
		List<Interval> intervals  = new ArrayList<Interval>();
		intervals.addAll(Arrays.asList(new Interval(904, 915) , new Interval(946, 1202),
				new Interval(952, 1128),new Interval(110, 1135), new Interval(1508, 1900),
				new Interval(1806, 2001)));
		
		System.out.println("--- " + minNoOfPlatformsRequired(intervals));
		
	}
	
	
}


class Interval{
	private int st ;
	private int end;
	
	public Interval(int st , int end) {
		this.st = st;
		this.end = end;
	}

	public int getSt() {
		return st;
	}
	
	public void setSt(int st) {
		this.st = st;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
}