package com.jv.dp;

public class DungeonGame {
	
	public static int enegryRequired(int [][] grid , int x , int y , int currEnegry) {
		
		if(x==grid.length-1 && y ==grid[0].length-1)
			return grid[x][y];
		else if(x>=grid.length || y>=grid[0].length)
			return 0;
		else {
			
			int cur = grid[x][y];
			int deficit =0;
			if(cur>=0)
				currEnegry+=cur;
			else if(currEnegry> Math.abs(cur))
				currEnegry -= Math.abs(cur);
			else
				deficit += Math.abs(currEnegry- Math.abs(cur));
			
			
			return deficit + Math.min(enegryRequired(grid, x+1, y, currEnegry), enegryRequired(grid, x, y+1, currEnegry));
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int [] [] grid ={
				{-2, -3 ,3},
				{-5,-10,1},
				{10,30,-5}
		};
		
		System.out.println(1+enegryRequired(grid, 0, 0, 0));
	}
	

}
