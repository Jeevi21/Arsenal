package com.jv.socure;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.math.*;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(int[] T) {
        // write your code in Java SE 8
        
        if(T==null || T.length==0 || T.length%4!=0)
            return "Invalid Input";
        
        //List of seasons
        List<String> seasons = Arrays.asList("WINTER","SPRING","SUMMER","AUTUM");
        
        int daysInSeason = T.length/4;
        
        String maxAmplitudeSeason = "";
        int maxAmplitude = Integer.MIN_VALUE;
        for(int i=0;i<seasons.size();i++){
            
            String curSeason = seasons.get(i);
            int curMax = Integer.MIN_VALUE;
            int curMin = Integer.MAX_VALUE;
            System.out.println(i*daysInSeason + " -- " + ((i*daysInSeason) + daysInSeason));
            for(int j=i*daysInSeason;j<(i*daysInSeason)+daysInSeason;j++){
                
                curMax = Math.max(curMax,T[j]);
                curMin = Math.min(curMin,T[j]);
                
            }
            
            if(maxAmplitude<(curMax-curMin)){
                maxAmplitude = curMax-curMin;
                maxAmplitudeSeason = curSeason;
            }
        }
        
        return maxAmplitudeSeason;

    }
    
    public static void main(String ... args) {
    	int [] T = {-3, -14, -5, 7, 8, 42, 8, 3,9,2,3,4,5,6,7,8};
    	
    	Solution sol = new Solution();
    	
    	//System.out.print(sol.solution(T));
    	
    	System.out.print(Math.floor(10));
    	
    	Double.valueOf(d
    }
}
