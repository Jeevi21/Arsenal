package com.jv.graph;

import java.util.Arrays;
import java.util.List;

import com.jv.utils.Constants;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class GraphBuilder {
	

	/**
	 * 		0----- 1
	 * 		|
	 * 		|
	 * 		3----- 2     4(disconnected)
	 * 
	 */
	public static Graph getDefaultUnDirectedGraph() {
		
		List<Edge> edges = Arrays.asList(new Edge(0, 1) , new Edge(0,3),
				new Edge(3,2) , new Edge(4,4) , new Edge(1,3));
	
		return new Graph(edges, false);
		
	}
	
	/**
	 *  0 ----> 1
	 *  	    |
	 *    	    |
	 *  3<------2			
	 *    
	 */
	public static Graph getDefaultDirectedGraph() {
		
		List<Edge> edges = Arrays.asList(new Edge(0,1) , new Edge(1,2) ,
				new Edge(2,3) , new Edge(2, 0) , new Edge(2, Constants.DUMMY_NODE));
		
		return new Graph(edges, true);
		
	}
	
	
	/**
	 *    0 ----> 1------>4--->5
	 *  	    * |		  *    *
	 *    	   /  |		  |    |
	 *        /   *		  |    |
	 *      3<----2-------------			
	 *    
	 */
	public static Graph getDefaultDirectedGraph2() {
		
		List<Edge> edges = Arrays.asList(new Edge(0,1) , new Edge(1,2) ,
				new Edge(2,3) , new Edge(3,1) , new Edge(1,4) , new Edge(4,5) , new Edge(2, 4) , new Edge(2,5));
		
		return new Graph(edges, true);
		
	}
}
