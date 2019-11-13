package com.jv.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Jeevi.Natarajan
 * 
 * Find minimum number of rolls needed for reaching the dest.
 *
 */
public class SnakeAndLadder {
	
	public static void buildGraph(int N , Map<Integer, Integer> ladder , Map<Integer, Integer> snake ) {
		
		List<Edge> edges = new ArrayList<Edge>();
		
		int count = 100;
		boolean flag = false;
		for(int i=N-1;i>=0;i--) {
			
			if(flag) { //reverse
				
				for(int j=N-1;j>=0;j--) {
					System.out.print( count +" ");
					count--;
				}
					
			}
			else {
				for(int j=0;j<N;j++) {
					System.out.print(count + " ");
					count--;
				}
				
				
			}	
				
			flag = !flag;
			System.out.println();
			
		}
		
		
		
		
		
		Graph graph = new Graph(edges, true);
		
		
		
		
		
	}
	
	
	public static void main(String[] args){
		// snakes and ladders are represented using a map.
		Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
		Map<Integer, Integer> snake = new HashMap<Integer, Integer>();

		// insert ladders into the map
		ladder.put(1, 38);
		ladder.put(4, 14);
		ladder.put(9, 31);
		ladder.put(21, 42);
		ladder.put(28, 84);
		ladder.put(51, 67);
		ladder.put(72, 91);
		ladder.put(80, 99);

		// insert snakes into the map
		snake.put(17, 7);
		snake.put(54, 34);
		snake.put(62, 19);
		snake.put(64, 60);
		snake.put(87, 36);
		snake.put(93, 73);
		snake.put(95, 75);
		snake.put(98, 79);

		buildGraph(10, ladder, snake);
	}

}
