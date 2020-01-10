package com.jv.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.jv.graph.Edge;

/**
 * Single source shortest path algorithm
 * @author Jeevi.Natarajan
 * 
 * Can be applied to both directed and un-directed graph.
 *
 */
public class Dijkstra {
	
	
	public static void printSingleSourceShorestPath(WeightedGraph graph , int st) {
		
		PriorityQueue<NodeWithDist> queue = new PriorityQueue<NodeWithDist>(graph.getAdjList().size(), (a,b) -> (a.getDistance()-b.getDistance()));
		queue.add(new NodeWithDist(st, 0 ,new ArrayList<Integer>()));
		
		
		List<List<Edge>> adjList = graph.getAdjList();
		
		Map<Integer,Integer> selectedVertices = new HashMap<Integer,Integer>(); //Vertex , Distance
		
		
		while(!queue.isEmpty()) {
			
			NodeWithDist node = queue.poll();
			
			//relax the nodes with direct edges.
			for(Edge edge : adjList.get(node.getVertex())) {
				
				if(!selectedVertices.containsKey(edge.getDest())) {
					//Update distance and put it to queue.. 
					NodeWithDist v = new NodeWithDist(edge.getDest(), node.getDistance()+edge.getWeight(), node.getPath());
					queue.add(v);
					
				}
			}	
			
			//And add it to selected list...
			if(!selectedVertices.containsKey(node.getVertex()) || (selectedVertices.get(node.getVertex()) > node.getDistance()) ) {
				selectedVertices.put(node.getVertex(), node.getDistance());
				System.out.println(node.getPath() + " -- " + node.getDistance()  );
			}
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1, 10), new Edge(0, 4, 3),
				new Edge(1, 2, 2), new Edge(1, 4, 4),
				new Edge(2, 3, 9), new Edge(3, 2, 7),
				new Edge(4, 1, 1), new Edge(4, 2, 8),
				new Edge(4, 3, 2)
		);
		
		WeightedGraph graph = new WeightedGraph(edges, true);
		
		printSingleSourceShorestPath(graph, 0);// From 0 print the distance.
	}

}


class NodeWithDist {
	
	private int vertex;
	private int distance;
	private List<Integer> path ;
	
	public NodeWithDist(int vertex , int distance , List<Integer> path) {
		this.vertex = vertex;
		this.distance = distance;
		this.path = path;
	}
	
	public NodeWithDist(int vertex , int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
	
	public List<Integer> getPath() {
		return path;
	}
	
	public void setPath(List<Integer> path) {
		this.path = path;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "[" + this.vertex + " - " + this.distance + " ]";
	}
	
}