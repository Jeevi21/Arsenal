package com.jv.leetcode.weekly.oneseventyFive;

import java.util.HashMap;
import java.util.Map;

class Solution {
    
    
    private boolean isSafe(int x , int y , char [][] sol){
              
        if(sol[x][y]!='.')
            return false;
        
        if(x-1>=0 && y-1>=0){
            if(sol[x-1][y-1]=='*')
                return false;
        }
        
        if(x-1>=0 && y+1<sol[0].length){
            if(sol[x-1][y+1]=='*')
                return false;
        }
        
        if(x>=0 && y-1>=0){
            if(sol[x][y-1]=='*')
                return false;
        }
    
        if(x>=0 && y+1<sol[0].length){
           if(sol[x][y+1]=='*')
                return false;
        }
        
        return true;
    }
        
    private int maxStudentsUtil(int x, int y , char [][] sol , Map<String,Integer> cache){
        
//        if(x>=sol.length && y>= sol[0].length){
//            return 0;
//        }
        
        String key = x+":"+y;
        
        if(cache.containsKey(key)){
        	return cache.get(key);
        }
        else{
            
            int max = 0;
            for(int i = x ; i<sol.length;i++){
                for(int j = y ;j<sol[0].length;j++){
                    //For each cell.. if it is safe..  occupy the seat.
                   
                    if(isSafe(i,j,sol)){
                    
                        sol[i][j]='*'; //occupied this cell.

                        //move to next cell
	                    int nextI=i , nextJ=j+1;
	                    if(nextJ>=sol[0].length){ //next row
	                    	nextI++;
	                    	nextJ=0;
	                    }

                        int choosen = 1 +  maxStudentsUtil(nextI , nextJ , sol,cache);
                    
	                    //Now i unchoose..
	                    sol[i][j]='.'; // backtrack
	                    
	                    int notChoosen = maxStudentsUtil( nextI , nextJ , sol,cache);
                    	
                   		max = Math.max(max,Math.max(choosen,notChoosen));
              
                    }
                }
                y=0;
            }
            
            System.out.println("-----------------------------");
            System.out.println( " MS ( " + x+ " , " + y  + " ) == " + max );
			
			print2d(sol);
            cache.put(key,max);
            return max;
            
        }
        
        
    }
    
    private void print2d(char [][] seats){
    	
    	
    	for(int i=0;i<seats.length;i++){
    		for(int j=0;j<seats[0].length;j++){
    			System.out.print(seats[i][j]+" " );
    		}
    		System.out.println();
    	}
    
    
    }
    public int maxStudents(char[][] seats) {
       
       Map<String,Integer> cache = new HashMap<>();
        return maxStudentsUtil(0,0,seats,cache);        
        
    }
    
	public static void main(String[] args) {
//		char[][] seats = {{'.','.','#','#','.','#','#'},{'#','#','#','.','#','#','.'},{'.','#','.','#','.','#','.'},{'.','#','.','#','.','.','#'},{'.','.','#','#','.','#','.'},{'#','.','#','#','.','#','#'}};

		char [][] seats = {{'.','.','#','.','.'},{'.','.','.','.','#'},{'.','#','#','#','.'},{'.','#','#','#','.'}};
	
		Solution sol = new Solution();
		
		

		System.out.println("--max seats : " + sol.maxStudents(seats));

	}
}


