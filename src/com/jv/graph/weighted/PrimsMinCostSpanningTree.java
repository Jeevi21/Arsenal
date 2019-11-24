package com.jv.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jv.graph.Edge;

/**
 * https://www.youtube.com/watch?v=4ZlRH0eK-qQ
 * 
 * 
 * @author Jeevi.Natarajan
 *
 */
public class PrimsMinCostSpanningTree {
	
	/**
	 * 
	 * 
	 * How many number of min spanning tree is possible? - |E| C |V| - no of edges. - I can generate all possible spanning trees with |V|-1 edges..
	 *  then find the min spanning tree.
	 *  
	 *  Is there a better way? - yes we have Greedy approach... 1 . Prim  , 2. Kruskal 
	 *  
	 *  Lets see Prim's algorithm.
	 *  
	 *		 1. First choose the min weighted edge.. 
	 *		 2. Select the next min edge which is connected to already selected edge. 
	 *		 3. Repeat till you select |V| - 1
	 * 
	 *   How to represent the weighted graph? - same , edge will have weight as well.
	 *   
	 *   How cycle is handled in Prims algorithm.
	 * 
	 */
	
	private static Edge findEdgeWithLeastWeight(Map<Integer, List<Edge>> graph , Set<Integer> selectedVertices , List<Edge> selectedEdges ) {
		
		int min = Integer.MAX_VALUE;
		Edge minEdge = null;
		for(Integer v : selectedVertices) {
			for(Edge edge : graph.get(v)) {
				
				if(!(selectedEdges.contains(edge)) && min>edge.getWeight()) {
					min = edge.getWeight();
					minEdge = edge;
				}
			}
		}
		
		return minEdge;
	}
	

	
	public static void printMinSpanningTree(Map<Integer, List<Edge>> graph) {
		
		List<Edge> selectedEdges = new ArrayList<Edge>();
		
		//1. select the min edge in the graph
		Edge selectedEdge  = findEdgeWithLeastWeight(graph, graph.keySet() , selectedEdges );
		selectedEdges.add(selectedEdge);
		Edge reverse = new Edge(selectedEdge.getDest(), selectedEdge.getSrc() , selectedEdge.getWeight());
		selectedEdges.add(reverse);		
		
		Set<Integer>  selectedVertices = new HashSet<Integer>();
		selectedVertices.add(selectedEdge.getSrc());
		selectedVertices.add(selectedEdge.getDest());
		
		System.out.println(selectedEdge.toString());
		
		//2.Now select the min edge from the selected one..
		
		while((selectedEdges.size() /2) < graph.size()-1) { // we have to select |v| - 1 edges.
			selectedEdge  = findEdgeWithLeastWeight(graph, selectedVertices , selectedEdges);
			selectedEdges.add(selectedEdge);
			 reverse = new Edge(selectedEdge.getDest(), selectedEdge.getSrc() , selectedEdge.getWeight());
			selectedEdges.add(reverse);		
			
			selectedVertices.add(selectedEdge.getSrc());
			selectedVertices.add(selectedEdge.getDest());
			
			System.out.println(selectedEdge.toString());
			
		
		}
		
	}
	
	public static void main(String[] args) {
	
		
//		List<Integer> vertices = Arrays.asList(0,1,2,3,4,5);
		
//		List<Edge> edges = Arrays.asList(new Edge(0,1), new Edge(1,2), new Edge(2,3),
//				new Edge(3,4), new Edge(4,5), new Edge(5,0) );
		
//		Graph graph = new Graph(edges, false);
	
		/*
		Map<Integer, List<Edge>> graph = new HashMap<>(); //In edge src is ununsed.
		graph.put(0, Arrays.asList(new Edge(0,1,2)));
		graph.put(1, Arrays.asList(new Edge(1,2)));
		graph.put(2, Arrays.asList(new Edge(2,3)));
		graph.put(3, Arrays.asList(new Edge(3,4)));
		graph.put(4, Arrays.asList(new Edge(4,5)));
		graph.put(5, Arrays.asList(new Edge(5,0)));
*/
		
		// The one in video
		Map<Integer, List<Edge>> graph = new HashMap<>(); //In edge src is ununsed.
		graph.put(0, Arrays.asList(new Edge(0,1,28) , new Edge(0 , 5, 10)   ));
		graph.put(1, Arrays.asList(new Edge(1,0,28)  , new Edge(1 ,6,14) , new Edge(1, 2, 16) ));
		graph.put(2, Arrays.asList(new Edge(2,3 ,12) ,  new Edge(2,1, 16)));
		graph.put(3, Arrays.asList(new Edge(3,2 ,12)  , new Edge(3,4,22)  , new Edge(3, 6,18) ));
		graph.put(4, Arrays.asList(new Edge(4,5,25) , new Edge(4, 6, 24) , new Edge(4,3,22) ));
		graph.put(5, Arrays.asList(new Edge(5, 0, 10) , new Edge(5, 4,25) ));
		graph.put(6, Arrays.asList(new Edge(6,3,18) , new Edge(6, 4, 24)  , new Edge(6,1,14) ));
		
		
		printMinSpanningTree(graph);
		
	}

}
