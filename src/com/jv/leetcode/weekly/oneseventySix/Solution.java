package com.jv.leetcode.weekly.oneseventySix;

import java.util.Arrays;

class Solution {
   
    
    private boolean isPossibleUtil(int [] target , int [] cur , int sum){
        
        boolean isEqual= true;
        for(int i=0;i<cur.length;i++){
            if(cur[i] > target[i])
                return false;
            if(isEqual && cur[i]!=target[i])
                isEqual=false;
        }
        
        if(isEqual)
            return true;
        else{
            
            boolean isPossible = false;
            for(int i=0;i<target.length;i++){
                cur[i] = sum;
                sum = Arrays.stream(cur).sum();
               isPossible = isPossible || isPossibleUtil(target ,cur , sum);
            }
            
            return isPossible; 
        
        }
        
    }
    
    public boolean isPossible(int[] target) {
        int [] cur = new int[target.length];
        Arrays.fill(cur,1);
        
        return  isPossibleUtil(target,cur,target.length);
    }
    
    public static void main(String [] args){
    	int [] target= {8,5};
    	
    	Solution sol = new Solution();
    	System.out.println("--possible : " + sol.isPossible(target));
    	
    	
    }
}