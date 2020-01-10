package com.jv.dp;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class MinCost {
	
	public static int minCost(int [][] grid , int x , int y,String prepend) {
	
		int min =0;
		if(x > 1 || y>2 )
			min = 0;
		else if(x==1 && y==2) {
			min = grid[x][y];
		}
		else {

			
			int right =0;
			//if(y+1<grid[0].length)
			  right = minCost(grid, x, y+1,prepend+"----");
			
			int down =0;
			//if(x+1<grid.length)
				down = minCost(grid, x+1, y,prepend+"----");
			
			int diag =0;
			//if(x+1< grid.length && y+1 < grid[0].length)
				diag = minCost(grid, x+1, y+1,prepend+"----");
				
			 min =  grid[x][y] + Math.min(Math.min(right, down),diag);
			System.out.println(prepend+"-mincost(,"+x+","+y+")  : "+ min);
			
			
			
			// min = grid[x][y] + Math.min(Math.min(minCost(grid, x, y+1, prepend+"----"), minCost(grid, x+1, y, prepend+"----")), minCost(grid, x+1, y+1, prepend+"----"));
			
		
		}
		
		System.out.println(prepend+"-mincost(,"+x+","+y+")  : "+ min);
		return min;
	}
	
	public static void main(String[] args) {
		
		int [][] grid = {
				{1,2,3},
				{4,8,2},
				{1,5,3}
		};
		
		System.out.println("--- mincost : " + minCost(grid, 0, 0,""));
	}

}
