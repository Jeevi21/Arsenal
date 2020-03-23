package com.jv.leetcode.weekly.oneseventySix;

class MaxEvents {
    public int maxEvents(int[][] events) {
        
    
        //sort according to st time.
        java.util.Arrays.sort(events, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int day =1 ;
        for(int event = 0 ; event < events.length;event++){
            
            int stTime = events[event][0];
            int endTime = events[event][1];
            
            if(stTime<=day && day <= endTime)
                day ++;
            
        }
        
        return day-1;

    }
    
     public static void main(String [] args){
     
     int [][] events = {{1,2},{1,2},{3,3},{1,5},{1,5}};
    	MaxEvents sol = new MaxEvents();
    	System.out.println("--possible : " + sol.maxEvents(events));
    	
    	
    }
}