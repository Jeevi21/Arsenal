package com.jv.graph.weighted;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Shortest path alogrithm
 * 
 * It is a single source shortest path algorithm
 * 
 * My adjacent nodes depends on the directions i choose to move. 
 * 
 * I choose to move in all 4 directions (left , right , down , up)
 * 
 * @author Jeevi.Natarajan
 *
 *	It is shortest path.. so disconnected components cannot 
 */
public class DijkstraMatrix {
	
	
	public static void shortestPath(int [][] grid , int x , int y ,  int xDest , int yDest) {
		
		Queue<GraphNodeWithDistance> heap = new PriorityQueue<GraphNodeWithDistance>((a,b)-> a.getDistance() - b.getDistance()); //Min-Heap

		List<GraphNodeWithDistance> relaxed = new ArrayList<>();
		
		heap.add(new GraphNodeWithDistance(xDest, yDest, 0));
		
		while(heap.is)
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		int [][] grid = {
				{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3}
		};
		
		
	}

}


class GraphNodeWithDistance{
	private int x;
	private int y;
	private int distance; //How can a node have weight??
	
	public GraphNodeWithDistance(int x,int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int getDistance() {
		return distance;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj!=null) {
			GraphNodeWithDistance node = (GraphNodeWithDistance) obj;	
			return this.x == node.x && this.y== node.y;
		}
		
		return false;
	}
	
}




