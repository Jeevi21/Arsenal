package com.jv.graph;

import java.util.ArrayList;
import java.util.List;

import com.jv.utils.Constants;

public class Graph {
	
	private List<List<Integer>> adjList;
	
	
	public List<List<Integer>> getAdjList() {
		return adjList;
	}
	
	public Graph(List<Edge> edges , boolean isDirected) {
		
		adjList = new ArrayList<>();
		
		for(int i=0;i<edges.size();i++) { //Allocate space for adjList
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

class Edge{
	private int src;
	private int dest;
	
	
	public Edge(int src, int dest) {
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
