package com.jv.graph.unionfind;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://www.youtube.com/watch?v=huukjQa1jU0
 * 
 * @author Jeevi.Natarajan
 *
 */
public class QuickUnion {

	
	private static int getRoot(int x , int [] ids) {
		
		while(ids[x]!=x) {
			x = ids[x];
		}
		return x;
	}
	
	public static boolean find(int [] ids , int a , int b) {
		
		return getRoot(a, ids) ==getRoot(b, ids);
	
	}
	
	public static void union(int [] ids , int src, int dest) { 
		//union is simpler.. take the dest as representative as usual..  
		//instead of changing all the nodes with srcId.. change only the src node.
		
		ids[src] = ids[dest]; // wrong..
		
	
	}
	
	public static void main(String[] args) {
		
		int [] ids = IntStream.range(0, 10).toArray();
		union(ids, 0, 1);
		union(ids, 1, 2);
//		union(ids, 2, 3);
		union(ids, 3, 4);
		
		System.out.println("-- arrays : " + Arrays.toString(ids));
		System.out.println("--root : " + getRoot(0, ids)); // my dest becomes representative.
		
		System.out.println("--find  : " + find(ids, 2, 3));
		
		
	}
}
