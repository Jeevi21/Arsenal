package com.jv.leetcode.weekly.oneseventySeven;
class Solution {
    
    static boolean isPerfectSquare(double sr , int number)  { 
    	int sqrt = (int) Math.sqrt(number);
        if(sqrt*sqrt == number) 
        	return true;
        else
        	return false;
        
    } 
    public int[] closestDivisors(int num) {
        
        int [] res = new int[2];
        double sr = Math.sqrt(num+1);
        if(isPerfectSquare(sr,num+1)){
            res[0] = (int)sr;
            res[1] = res[0];
            
            return res;
        }
        
        sr = Math.sqrt(num+2);
        if(isPerfectSquare(sr,num+2)){
            res[0] = (int)sr;
            res[1] = res[0];
            
            return res;
        }
        
        int closestDivisor = Integer.MAX_VALUE;
        int prevDivisor = Integer.MAX_VALUE;
      
        for(int i=2;i<=Math.sqrt(num+1);i++){
            
            if((num+1)%i==0){
                
                if(closestDivisor>i-prevDivisor){
                    closestDivisor = i-prevDivisor;
                    res[0]= i;
                    res[1] = prevDivisor;
                }
                
                prevDivisor = i;
                
            }
        }
        
        prevDivisor = Integer.MAX_VALUE;
       
        for(int i=2;i<=Math.sqrt(num+2);i++){
            
            if((num+2)%i==0){
                
                if(closestDivisor>i-prevDivisor){
                    closestDivisor = i-prevDivisor;
                    res[0]= i;
                    res[1] = prevDivisor;
                }
                
                prevDivisor = i;
            }
            
        }
        
        return res;
    }
    
   public static void main(String [] args) {
	   Solution sol = new Solution();
	  int res [] =  sol.closestDivisors(999);
	  System.out.print("res " +  res[0] + " - " + res[1]);
   }
}