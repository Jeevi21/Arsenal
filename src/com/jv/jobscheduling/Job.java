package com.jv.jobscheduling;

public class Job implements Comparable<Job>{
	
	private int stTime;
	private int finishTime;
	private int weight;
	
	public Job(int stTime , int finishTime , int weight) {
		this.stTime = stTime;
		this.finishTime = finishTime;
		this.weight = weight;
	}
	
	public int getStTime() {
		return stTime;
	}
	
	public void setStTime(int stTime) {
		this.stTime = stTime;
	}
	
	public int getFinishTime() {
		return finishTime;
	}
	
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Job o) {
		return this.finishTime - o.finishTime;
	}
	
	

}
