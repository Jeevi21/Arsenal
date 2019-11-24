package com.jv.matrix;

class Solution {

  static int calcDroneMinEnergy(int[][] route) {
    
    int enegry=0;
    int deficit = 0;
    
    for(int i=0;i<route.length-1;i++){
      int diff = route[i][2] - route[i+1][2];
     
      if(diff<0 && enegry<Math.abs(diff)) {
         deficit += Math.abs(diff)-enegry;
//         enegry=0;
      }
      else
    	  enegry += diff ;
      
    }
    
    return deficit;
  }

  public static void main(String[] args) {
	  int [][] route = { 
		       {0,2,2},
		       {3,5,38},
		       {9,20,6},
		       {10,12,15},
		       {10,10,8} };
    
    System.out.println(calcDroneMinEnergy(route));
    
  }

}