package com.jv.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DFS {
	
	private static int counter=0;
	
	private static void previsit(int v) {
		counter++;
		System.out.println("---- Previst of Node : " + v +" is : "+ counter);
	}
	
	private static void postvisit(int v) {
		counter++;
		System.out.println("---- Postvist of Node : " + v +" is : "+ counter);
	}
	
	private static void depthFirstSearchUtil(List<List<Integer>> adjList, int v, boolean [] isvisted) {
		
		previsit(v);
		System.out.println(v);
		isvisted[v] = true;
		
		
		for(int u : adjList.get(v)) {
			if(!isvisted[u])
				depthFirstSearchUtil(adjList, u, isvisted);
		}

		postvisit(v);
	}
	
	
	public static void depthFirstSearch(Graph graph) {
		boolean [] isVisited = new boolean[graph.getAdjList().size()];
		depthFirstSearchUtil(graph.getAdjList() , 0, isVisited);
		
		//There can be a disconnected components... If all are not visited.. then try with that again.
		for(int i=1;i<isVisited.length;i++) {
			if(!isVisited[i])
				depthFirstSearchUtil(graph.getAdjList() , i, isVisited);
		}
		
		
	}
	
	
	public static void dfsIterative(Graph graph) {
		
		int v=0;

		List<List<Integer>> adjList = graph.getAdjList();
		
		boolean [] isVisited = new boolean[adjList.size()];
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(v);
		
		while(!stack.isEmpty()) {
			
			int u = stack.pop();
			
			System.out.println(u);
			isVisited[u]=true;
			
			for(int k : adjList.get(u)) {
				if(!isVisited[k])
					stack.add(k);	
			}
		}	
	}
	
	
	public static void directedDFS(int v , List<List<Integer>> adjList , boolean [] isVisited) {
		
		System.out.println(v + " --- visited : " + isVisited[v]);
		isVisited[v] = true;
		
		for(int u : adjList.get(v)) {
			System.out.println(u + " --- visited : " + isVisited[u]);
			if(!isVisited[u])
				directedDFS(u, adjList, isVisited);
		}
		
		
	}
	
	public static void main(String[] args) {
		
//		Graph graph = GraphBuilder.getDefaultUnDirectedGraph();
//		depthFirstSearch(graph);
		
		//System.out.println("---Let try the iterative way---");
		//dfsIterative(graph);
		
		//Directed Graph
		Graph directedGraph = GraphBuilder.getDefaultDirectedGraph();
		boolean [] isVisited = new boolean[directedGraph.getAdjList().size()];
		directedDFS(0, directedGraph.getAdjList(), isVisited);
	}

}
