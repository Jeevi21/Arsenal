package com.jv.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Was trying to solve Min cost problem . 
 * 	- find min cost needed to reach the dest.  (Only right , down , diag - down)  [No cycle]
 * 	- find min cost needed to reach the dest  (when right , down , up , left , and all diagonal - so 8 direction totally)
 * 												- Even when you consider the 4 directions ,without diagonal.
 * 					[This have cycle]
 * 
 * @author Jeevi.Natarajan
 *
 */
public class PrintAllPath {
	
	
	
	// I am not using any isVisited..
	//When i choose to move only right , down... - i dont have any cycles and isVisted is not required.
	public static void printAllPathRestricted(int [][] grid , int x , int y , int dest , List<Integer> path) { //Only  right , down
		if(x>=grid.length || y >= grid[0].length)
			return;
	
		path.add(grid[x][y]);
		if(grid[x][y]==dest) {
			//Now print
			System.out.println(path);
		}
	
		printAllPathRestricted(grid,x+1 ,y , dest ,path); //down	
		printAllPathRestricted(grid, x , y+1 , dest,path) ; //right
		path.remove(path.size()-1); // After exploring all the possibilities for the selected node.. Remove the node.. 
		
	}
	
	//Let me try to traverse in all 4 direction.. which will cause a cycle in matrix. 
	public static void printAllPath(int [][] grid , int x , int y , int dest , List<Integer> path , boolean [][] isVisited) {
		if(x>=grid.length || y >= grid[0].length )
			return;
		
		path.add(grid[x][y]);
		isVisited[x][y] = true;
		
		if(grid[x][y]==dest){ //Print the path
			System.out.println(path);
		}
		
		if(x+1< grid.length && !isVisited[x+1][y])
			printAllPath(grid , x+1 , y , dest , path,isVisited); //down
		if(y+1< grid[0].length && !isVisited[x][y+1])
			printAllPath(grid , x , y+1 , dest , path,isVisited); //right
		if(x-1>=0 && !isVisited[x-1][y])
			printAllPath(grid , x-1 , y , dest , path,isVisited); //left
		if(y-1>=0 && !isVisited[x][y-1])
			printAllPath(grid , x , y-1 , dest , path,isVisited); //up
		
		path.remove(path.size()-1); // when done with all exploring all possible ways.. remove the node from path.	
		isVisited[x][y] = false; //Done with exploring the current path.. I can be again visited as part of some other path. 

	}



	

	
	
	public static void main(String[] args) {
		
		int [][] grid = {
				{1,2,3},
				{4,8,2},
				{1,5,3}
		};
		
		
//		printAllPathRestricted(grid, 0, 0, 5 , new ArrayList<Integer>());
		boolean [][] isVisited = new boolean[grid.length][grid[0].length];
		
		printAllPath(grid, 0, 0, 5, new ArrayList<Integer>(),isVisited);
		
	}

}
