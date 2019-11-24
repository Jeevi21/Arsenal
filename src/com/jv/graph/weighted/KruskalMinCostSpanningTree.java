package com.jv.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import com.jv.graph.Edge;
import com.jv.graph.unionfind.DisjointSet;

/**
 * 
 * @author Jeevi.Natarajan
 * 
 * https://www.techiedelight.com/kruskals-algorithm-for-finding-minimum-spanning-tree/
 * https://www.youtube.com/watch?v=4ZlRH0eK-qQ
 * 
 *
 */
public class KruskalMinCostSpanningTree {
	
	
	/**
	 * https://stackoverflow.com/questions/1195872/when-should-i-use-kruskal-as-opposed-to-prim-and-vice-versa
	 * 
	 * Similar to prim ...  But
	 * 1. Kruskal takes the min cost edge always..--> we can use min heap for this.
	 * 2. If adding the edge will result in cycle.. then skip that edge (bcoz trees wont have cycle) --> union-find
	 * 
	 * 
	 * 
	 */
	
	
	public static List<Edge> getMinCostSpanningTree(PriorityQueue<Edge> queue , int N) {
		DisjointSet disjointSet = new DisjointSet();
		disjointSet.makeSet(N);
		
		List<Edge> selectedEdges = new ArrayList<Edge>();
		
		//Always select the min weighted edge if it is not forming cycle.
		
		//Priority queue - contains edges.. |E| to build .. log |E| to fetch min.
		//|V| * (log|E| + log |v| + log |v|)
		
		while(selectedEdges.size()<N-1) {  
			
			Edge edge = queue.poll();
			
			if(disjointSet.find(edge.getSrc() , edge.getDest()))
					continue;
			
			//If it is not forming cycle.. add it to selected list.
			selectedEdges.add(edge);
			
			disjointSet.union(edge.getSrc(), edge.getDest());
			
		}
		
		return selectedEdges;
	
	}
	
	public static void main(String[] args) {
		
		//How do u want to represent graph?
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1, 7), new Edge(1, 2, 8),
				new Edge(0, 3, 5), new Edge(1, 3, 9),
				new Edge(1, 4, 7), new Edge(2, 4, 5),
				new Edge(3, 4, 15), new Edge(3, 5, 6),
				new Edge(4, 5, 8), new Edge(4, 6, 9),
				new Edge(5, 6, 11)
				);

		int N=7;
		
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(N , (Edge o1, Edge o2) -> o1.getWeight()-o2.getWeight()); //Min heap
		queue.addAll(edges);
		
		List<Edge> selectedEdges = getMinCostSpanningTree(queue, N);
		
		System.out.println(selectedEdges);
		
		
//		Collections.sort(edges,(Edge o1, Edge o2) -> o1.getWeight()-o2.getWeight()); //Remember this..
		
		//Initialize ids 
		
		
	}

}
