package com.jv.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Jeevi.Natarajan
 * 
 * 
 * Try BFS with level breaks..
 *
 */
public class BFS {

	public static void breadthFirstSearchUtil( int v,  List<List<Integer>> adjList , boolean [] isVisited) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(v);
		
		while(!queue.isEmpty()) {
			
			int u = queue.poll();
			
			
			if(!isVisited[u]) {
				System.out.print(u + "  ");
				isVisited[u] = true;
				queue.addAll(adjList.get(u));
				
			}
			
		}
		
	}
	public static void breadthFirstSearch(Graph graph){
		boolean [] isVisited = new boolean[graph.getAdjList().size()];
		breadthFirstSearchUtil(3, graph.getAdjList(), isVisited);
		
		//If there are dis-connected components.. loop again...
		for(int i=1;i<isVisited.length;i++) {
			if(!isVisited[i])
				breadthFirstSearchUtil(i, graph.getAdjList(), isVisited);
		}
	}
	
	
	private static void bfsRecUtil(List<List<Integer>> adjList , int v , int level , boolean [] isVisited) {
		
		if(level==0) {
			if(!isVisited[v]) {
				System.out.println(v);
				isVisited[v] = true;
			}
		}
		else {
			
			for(int u : adjList.get(v)) {
				bfsRecUtil(adjList, u, level-1,isVisited);
			}
			
		}
	}
	
	public static void bfsRec(Graph graph) {
		
		List<List<Integer>> adjList = graph.getAdjList();
		
		boolean [] isVisited = new boolean[adjList.size()];
		
		for(int i=0 ; i< adjList.size() ; i++) {
			bfsRecUtil(adjList, 0, i , isVisited);
			System.out.println();
		}
		
	}
	
	private static void levelByLevelBFS(List<List<Integer>> adjList, int v , boolean [] isVisited) {
//		Queue<Integer> queue = new ArrayDeque<Integer>();   - ArrayDeque does not accepts NULL
		
		/**
		 * Queue implementations generally do not allow insertion of null elements.
		 *  The LinkedList implementation (which was retrofitted to implement Queue) is an exception. 
		 *  For historical reasons, it permits null elements, but you should refrain from taking advantage of this,
		 *   as null is used as a special return value by the poll and peek methods.
		 * 
		 */
		
		List<Integer> queue = new java.util.LinkedList<Integer>(); //accepts NULL.
		
		queue.add(v);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			Integer u = queue.remove(0);
			
			if(u==null) {
				System.out.println();
				if(!queue.isEmpty())
					queue.add(null);
			}
			else {
				System.out.print(u + " ");
				isVisited[u] = true;
				
				for(int k : adjList.get(u)) {
					if(!isVisited[k])
						queue.add(k);
				}
			}
			
		}
		
	}
	public static void levelByLevel(Graph graph) {
		List<List<Integer>> adjList = graph.getAdjList();
		boolean [] isVisited = new boolean[adjList.size()];
		
		levelByLevelBFS(adjList, 0, isVisited);
		
	}
	
	public static void main(String[] args) {
		
		Graph graph = GraphBuilder.getDefaultUnDirectedGraph();
		breadthFirstSearch(graph);
		
		System.out.println("\n---Lets try Recursive ----");
		bfsRec(graph);
		
		System.out.println("\n---- Lets try Level By level traversal----");
		levelByLevel(graph);
		
		
	}
}
