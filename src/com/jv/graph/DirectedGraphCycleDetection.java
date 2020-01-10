package com.jv.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class DirectedGraphCycleDetection {
	
	public static boolean hasCycle(List<List<Integer>> adjList , int v , List<Integer> recStack , boolean [] isvisited) {
	
		
//		recStack.add(v);
		
		if(isvisited[v] &&  recStack.contains(v))
			return true;
		
		isvisited[v] = true;
	
		for(int u : adjList.get(v)) {
		
				recStack.add(u);
				boolean hascycle = hasCycle(adjList, u, recStack, isvisited);
				if(hascycle)
					return true;
				recStack.remove(new Integer(u));
			
			
		}
//		recStack.remove(v);
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		List<Edge> edges = Arrays.asList(new Edge(0,1) , new Edge(1, 2) , new Edge(2,3) , new Edge(3,1));
		Graph graph = new Graph(edges, true , 4);
		
		List<List<Integer>> adjList = graph.getAdjList();
		boolean [] isVisted = new boolean[adjList.size()];
		System.out.println("--hascycle : " + hasCycle(adjList, 0, new ArrayList<Integer>(), isVisted));
	}

}
