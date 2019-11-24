package com.jv.graph;

public class Edge{
	private int src;
	private int dest;
	private int weight;
	
	public Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
		this.weight =1;
	}
	
	public Edge(int src , int dest , int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getSrc() {
		return src;
	}
	
	public void setSrc(int src) {
		this.src = src;
	}
	
	public int getDest() {
		return dest;
	}
	
	public void setDest(int dest) {
		this.dest = dest;
	}
	
	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj!=null) {
			Edge edge = (Edge) obj;
			return (this.src == edge.getSrc() && this.dest == edge.getDest() && this.weight==edge.getWeight());
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "[ src :"+ this.src + " -  dest : " + this.dest +" - weight : " + this.weight +" ]"; 
	}
}