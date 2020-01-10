package com.jv.leetcode.weekly.one;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
	 private int getLen(int val){
	        int length=0;
	        while(val>0){
	            length++;
	            val = val/10;
	        }
	        
	        return length;
	    }
	    
	   private int getSeq(int [] arr , int st , int end){
	       int mul =1;
	       int seq =0;
	       int i = end;
	       while(i>=st){
	           seq += arr[i] * mul;
	           mul=mul*10;
	           i --;
	       }
	       
//	       System.out.println("--- " + st+ "-- end : " + end +" --- seq : "+ seq);
	       
	       return seq;
	   }
	    
	    public List<Integer> sequentialDigits(int low, int high) {
	        
	        //Get the length of low and high.
	        int lowLen = getLen(low);
	        int highLen  = getLen(high);
	        
//	        System.out.println("-- lowLen : " + lowLen + " -- highLen : " + highLen);
	        
	        int [] digits ={1,2,3,4,5,6,7,8,9};
	        List<Integer> sequence = new ArrayList<>();
	        
	        for(int winLen = lowLen; winLen<= highLen ; winLen ++ ){ //Sequence can be in these lengths..
	            
	            int st= 0;
	            int end=winLen-1;
	            
	            while(end<digits.length){
	                //st to end form a sequence...
	            	int seq = getSeq(digits, st , end);
	            	
	            	if(seq>high)
	            		break;
	            	
	            	if(seq>=low)
	            		sequence.add(seq);
	                
	                st++;
	                end++;
	            }
	            
	        }        
	        
	        return sequence;
	        
	    }
	    
	    
	    public static void main(String[] args) {
			
	    	SequentialDigits seqDigits = new SequentialDigits();
	    	
	    	System.out.println("-- " + seqDigits.sequentialDigits(100, 300));
	    	
	    	
	    	
		}
}
