package com.jv.graph.dag;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import com.jv.graph.Edge;
import com.jv.graph.Graph;

/**
 * Topological sort  - Nothing but DFS + timeStamp - consider the postVisit time
 * 
 * DFS - 0(V+E)
 * @author Jeevi.Natarajan
 *
 */
public class TopologicalSort {
	
	private static void dfs(List<List<Integer>> adjList , boolean [] isVisited , Deque<Integer> stack , int v) {
		
		isVisited[v] = true;
		
		for(int u : adjList.get(v)) {
			
			if(!isVisited[u])
				dfs(adjList, isVisited, stack, u);
		}
		
		//After exploring all add it to stack.
		stack.push(v);
		
	}
	
	public static void topSort(Graph graph) { //Its abt the order.. It really doesn't care about the weight
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		List<List<Integer>> adjList = graph.getAdjList();
		boolean [] isVisited = new boolean[adjList.size()];
		
		
		dfs(adjList, isVisited, stack,0);
		
		for(int i=0;i<adjList.size();i++) {
			if(!isVisited[i])
				dfs(adjList, isVisited, stack, i);
		}
		
		System.out.println(stack);
	}

	public static void main(String[] args) {
		
		List<Edge> edges = Arrays.asList(
				new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
				new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
				new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
				);
		
		int N = 8;  //This is required. You cant rely on no of edges.. think abt multiple edges.
		
		Graph graph = new Graph(edges, true , N);
		
		topSort(graph);
		
	}
}
