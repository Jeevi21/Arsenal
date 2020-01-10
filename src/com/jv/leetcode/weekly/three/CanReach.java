package com.jv.leetcode.weekly.three;
class CanReach {
    
    
    private boolean canReachUtil(int[] arr , int st , Boolean [] cache , boolean [] isvisited){
        
        if(st<0 || st>=arr.length)
            return false;
        
        if(cache[st]!=null)
            return cache[st];
        else{
        
        	isvisited[st] =true;
            boolean canReach = false;
            if(arr[st]==0)
                canReach = true;
            else if(st<arr.length){
            	boolean left = false;
            	if(st + arr[st]<arr.length && !isvisited[st+arr[st]])
                  left = canReachUtil(arr , st + arr[st],cache,isvisited);
                boolean right = false;
            	if(st - arr[st]>=0 && !isvisited[st-arr[st]])
            		right = canReachUtil(arr, st - arr[st],cache,isvisited);
            	
            	canReach = left || right;
            }
            cache[st] = canReach;
            isvisited[st] = false;
            return canReach;
        }
    }
    
    public boolean canReach(int[] arr, int start) {
        
        Boolean []  cache = new Boolean[arr.length];
        
        boolean [] isvisited = new boolean[arr.length];
        return canReachUtil(arr,start , cache , isvisited); 
    }
    
    public static void main(String[] args) {
		int [] arr = {3,0,2,1,2};
		
		CanReach sol = new CanReach();
		System.out.println(sol.canReach(arr, 2));
	}
}