package com.jv.leetcode.weekly.oneseventynine;

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    
    private static int dfs(List<Integer> [] adjList , boolean [] isvisited , int V , int t, int target , int size){
                
        if(t>0){
           
            isvisited[V]= true;
            
            if(adjList[V].contains(target))
                return size * adjList[V].size();

            if(adjList[V]!=null) {
	            for(int u : adjList[V]){
	
	                if(!isvisited[u])
	                    return dfs(adjList,isvisited,u,t-1,target,size * adjList[V].size());
	            }
            }
            
        }
        
        return 0;
    }
    

    
    public static double frogPosition(int n, int[][] edges, int t, int target) {
        
        //form the adjList
        List<Integer> [] adjList = new ArrayList[n+1];
        for(int i=0;i<edges.length;i++){
        	 	
        	if(edges[i][0] < edges[i][1]) {
       	
	            if(adjList[edges[i][0]]==null)
	                adjList[edges[i][0]] = new ArrayList<>();
	            adjList[edges[i][0]].add(edges[i][1]);   
        	}
        	else {
	            if(adjList[edges[i][1]]==null)
	                adjList[edges[i][1]] = new ArrayList<>();
	                  
	            	adjList[edges[i][1]].add(edges[i][0]); 
	        }
          
        }
        
        boolean [] isvisited = new boolean[n+1];
        
        int count = dfs(adjList,isvisited,1 , t , target, 1);
        
        System.out.print(count);
        
        return (count==0)?0:(1.0/count);
    }
    
    public static void main(String [] args) {
    	
    	int [][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
    	
    	double res = frogPosition(7 , edges , 2 , 4);
    	
    	System.out.print(res);
    	
    }
}