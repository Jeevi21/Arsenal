package com.jv.graph.weighted;

import java.util.ArrayList;
import java.util.List;

import com.jv.graph.Edge;

/**
 * adjacency list implementation for weighted graph.
 * @author Jeevi.Natarajan
 *
 */
public class WeightedGraph {
	
	private List<List<Edge>> adjList;
	
	public WeightedGraph(List<Edge> edges , boolean isDirected) {
		this.adjList = new ArrayList<List<Edge>>();
		
		for(int i=0;i<edges.size();i++) 
			adjList.add(new ArrayList<Edge>());			
		
		for(Edge edge : edges) {
			
			adjList.get(edge.getSrc()).add(edge);
			
			if(!isDirected)
				adjList.get(edge.getDest()).add(edge);
		}
		
	}
	
	public List<List<Edge>> getAdjList() {
		return adjList;
	}

}
