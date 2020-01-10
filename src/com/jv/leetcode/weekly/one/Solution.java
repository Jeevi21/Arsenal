package com.jv.leetcode.weekly.one;
class Solution {
    
    
    boolean solved = false; 
    private int SPutil(int [][] grid , int [][] sol , int i , int j ,int k , int sp , int n , int m ){
     
        if(i==n && j==m){
            solved=true;
            sol[i][j] = 1;
            return sp;
        }
        else if (i>=0 && j>=0 && i<=n && j<=m){
            
           //Try All 4 paths
        	sol[i][j] = 1;
            
            int min = -1;
            //Down
            if(i+1<=n){
                if(grid[i+1][j]==0) //No obstacle.. Just proceed.
                    min = Math.min(min,SPutil(grid , sol, i+1 , j , k , sp+1,n , m));
                else if(k>0) // There is an obstacle.. if you have the option of breaking it.. just proceed...
                	min = Math.min(min,SPutil(grid , sol , i+1 , j , k-1 , sp+1,n , m));
            }
          
            //Right
            if(j+1<=m){
            	if(grid[i][j+1]==0) //No obstacle.. Just proceed.
                    min = Math.min(min,SPutil(grid , sol,  i , j+1 , k , sp+1,n , m));
                else if(k>0) // There is an obstacle.. if you have the option of breaking it.. just proceed...
                	min = Math.min(min,SPutil(grid , sol, i , j+1 , k-1 , sp+1,n , m));
            }
            
            //Up
            if(i-1>=0){
            	if(grid[i-1][j]==0) //No obstacle.. Just proceed.
                    min = Math.min(min,SPutil(grid , sol,  i-1 , j , k , sp+1,n , m));
                else if(k>0) // There is an obstacle.. if you have the option of breaking it.. just proceed...
                	min = Math.min(min,SPutil(grid , sol ,i-1 , j , k-1 , sp+1,n , m));
            }
            
          
            //Left
            if(j-1>=0){
            	if(grid[i][j-1]==0) //No obstacle.. Just proceed.
                    min = Math.min(min,SPutil(grid , sol, i , j-1 , k , sp+1,n , m));
                else if(k>0) // There is an obstacle.. if you have the option of breaking it.. just proceed...
                	min = Math.min(min,SPutil(grid , sol, i , j-1 , k-1 , sp+1,n , m));
            }
            
            
            return min;
        }
        
        return -1;
    }
    
    public int shortestPath(int[][] grid, int k) {
    	
    	int [][] sol = new int[grid.length][grid[0].length];
    	int sp = SPutil(grid, sol, 0, 0, k, 0, grid.length-1, grid[0].length-1);
    	
    	if(!solved)
    		return -1;
    	
    	return sp;
        
    }
    
    public static void main(String[] args) {
    	int [][] grid = 
    			{{0,0,0},
    			 {1,1,0},
    			 {0,0,0},
    			 {0,1,1},
    			 {0,0,0}}; 
    
    	int k =1;
    	
    	Solution sol = new Solution();
    	System.out.println("---- " + sol.shortestPath(grid, k));

	}
}