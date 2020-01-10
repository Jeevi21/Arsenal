package com.jv.graph;

import java.util.ArrayList;
import java.util.List;

import com.jv.utils.Constants;

public class Graph {
	
	private List<List<Integer>> adjList;
	
	
	public List<List<Integer>> getAdjList() {
		return adjList;
	}
	
	public Graph(List<Edge> edges , boolean isDirected , int N) {
		
		adjList = new ArrayList<>();
		
		for(int i=0;i<N;i++) { //Allocate space for adjList
			adjList.add(new ArrayList<Integer>());
		}
		
		for(Edge edge : edges) {
			if(edge.getDest()!=Constants.DUMMY_NODE) {
				adjList.get(edge.getSrc()).add(edge.getDest());
				
				if(!isDirected)
					adjList.get(edge.getDest()).add(edge.getSrc());
				
			}
		}
	}
	
}
