package com.jv.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Print path - 
 * 	
 * @author Jeevi.Natarajan
 *
 */
public class PrintPath {
	
	
	private static void printPathUtil(List<List<Integer>> adjList, boolean[] isVisited, int cur, int dest,
			List<Integer> path) {

		isVisited[cur] = true;

		if (cur == dest) {
			// PrintPath
			System.out.println(path);  //How to return instead of printing??  - One way is having seperate output list... Just like leetcode ones..

		}

		for (int u : adjList.get(cur)) {
			if (!isVisited[u]) {

				path.add(u);
				printPathUtil(adjList, isVisited, u, dest, path);
				path.remove(path.size() - 1);

			}

		}
	}
	
	public static List<Integer> printPath(Graph graph , int src , int dest) {
		
		boolean [] isVisited = new boolean[graph.getAdjList().size()];
		List<Integer> path = new ArrayList<Integer>();
		
		path.add(src);
		printPathUtil(graph.getAdjList(), isVisited, src, dest, path);
		
		System.out.println("---aft return : " + path);
		
		return path;
		
	}
	
	private static void printAllPathUtil(List<List<Integer>> adjList, boolean[] isVisited, int cur, int dest,
			List<Integer> path) {

		isVisited[cur] = true;

		if (cur == dest) {
			// PrintPath
			System.out.println(path);

		}

		for (int u : adjList.get(cur)) {
			if (!isVisited[u]) {

				path.add(u);
				printAllPathUtil(adjList, isVisited, u, dest, path);
				path.remove(path.size() - 1);

			}

		}
		
		isVisited[cur] = false;
	}
	
	public static List<Integer> printAllPath(Graph graph , int src , int dest) {
		
		boolean [] isVisited = new boolean[graph.getAdjList().size()];
		List<Integer> path = new ArrayList<Integer>();
		
		path.add(src);
		printAllPathUtil(graph.getAdjList(), isVisited, src, dest, path);
		
		//System.out.println("---aft return : " + path);
		
		return path;
		
	}
	
	public static boolean doesPathexits(){ //Normal DFS will work.
		return true;
	}
	
	
	//In un-weighted Graph.. BFS always gives shortest path.. But how to store the path?
	
	public static void printShortestPathUtil(List<List<Integer>> adjList ,  int src , int dest ) {
		
		boolean[] isVisited = new boolean[adjList.size()];
		
		Queue<List<Integer>> queue =  new ArrayDeque<>();
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(src);
		queue.add(list);
		
		while(!queue.isEmpty()) {
			
			List<Integer> curPath = queue.poll();
			int cur = curPath.get(curPath.size()-1);
			
			isVisited[cur] = true;
			
			
			if(cur==dest) {
				System.out.println(curPath);
				break;
			}
					
			for(int u : adjList.get(cur)) {
				if(!isVisited[u]) {
					List<Integer> newList = new ArrayList<>();
					newList.addAll(curPath);
					newList.add(u);
					queue.add(newList);
				}
			}
			
			
			
		}
		
	
		
	}
	
	public static void printShortestPath(Graph graph , int src , int dest) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		map.put(src, -1);
		
		printShortestPathUtil(graph.getAdjList(), src, dest);
		
		//System.out.println("---aft return : " + path);
		
//		return path;
		
	}
	
	
	public static void main(String[] args) {
		
		Graph graph = GraphBuilder.getDefaultDirectedGraph2();
//		printPath(graph, 2, 5);
		
//		printAllPath(graph, 2, 5);
		
		printShortestPath(graph, 3, 4);
		
	}

}
