package com.jv.jobscheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class JobScheduling {

	private static int getMaxUtil(List<Job> list , List<Job> choosen , int sum) {
		
		if(list.isEmpty()) {
			System.out.println(choosen);
			return sum;
		}
		else {
			Job job = list.remove(0);

			//when choosing check if satisfies the condition.
			int a =0;
			int endTime = Integer.MIN_VALUE;
			if(!choosen.isEmpty()) {
				endTime =  choosen.get(choosen.size()-1).getFinishTime();
			}
			if(endTime<job.getStTime()) {
				choosen.add(job);
				a =  getMaxUtil(list, choosen, sum+job.getWeight());
				choosen.remove(choosen.size()-1);
			}
			
			
			int b = getMaxUtil(list, choosen, sum);

			list.add(0,job);
			
			return Math.max(a, b);
			
		}
		
	}
	public static void getMax(List<Job> jobs) {
		
		//sort jobs. according to its endTime.. 
		Collections.sort(jobs);
		
		int max = getMaxUtil(jobs, new ArrayList<Job>(), 0);
		System.out.println("--max : " + max);
		
	}
	
	public static void main(String[] args) {
		
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job(1,2,150));
		
		jobs.add(new Job(6,19,100));
		jobs.add(new Job(3,5,20));
		jobs.add(new Job(2,100,200));
	
		getMax(jobs);
		
	}
	
}
