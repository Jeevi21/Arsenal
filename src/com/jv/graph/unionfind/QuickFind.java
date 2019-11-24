package com.jv.graph.unionfind;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Trying to implement QuickFind.. was following this sedgewick tutorial.
 * https://www.youtube.com/watch?v=pnkqqb-WaRg
 * 
 * @author Jeevi.Natarajan
 *
 */
public class QuickFind {
	
	
	public static boolean find(int [] vertices , int a , int b ) { //Tells if node a and b are connected or not.
		
		return vertices[a] == vertices[b];  //If both have same representative. Then they are connected.. else they belong to two different set.
		
	}
	
	public static void union(Edge edge , int [] vertices) {
		
		//Given an edge.. take the dest and replace all elements with src value to dest..
		//Always dest becomes representative of my set.
		
		//First make the src to point to dest..
		int idSrc = vertices[edge.getSrc()];
		int idDest = vertices[edge.getDest()];
		
		for(int i=0;i<vertices.length;i++) {
			
			if(vertices[i]==idSrc)
				vertices[i] = idDest;
			
		}
		
		System.out.println("--after union : " + Arrays.toString(vertices));
		
		//Union takes O(n) for one edge.. If we have N edges.. then it tends to take.. N2 time.. Quadratic..
	}
	
	public static void main(String[] args) {
		
		int [] vertices = IntStream.range(0, 10).toArray();// have vertices 0 to 9.
		
		
		union(new Edge(0,1),vertices);
		union(new Edge(1,2),vertices);
		union(new Edge(4,3),vertices);
		union(new Edge(3,1),vertices);
		union(new Edge(5, 6), vertices);
		
		System.out.println("-- find : " + find(vertices, 3, 5));		
	}

}

class Edge{
	private int src;
	private int dest;
	
	public Edge(int src , int dest) {
		this.src = src;
		this.dest = dest;
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
	
}
