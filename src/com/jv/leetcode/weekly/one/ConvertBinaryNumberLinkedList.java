package com.jv.leetcode.weekly.one;import java.io.ObjectInputStream.GetField;


/**
 * https://leetcode.com/contest/weekly-contest-167/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @author Jeevi.Natarajan
 *
 */
public class ConvertBinaryNumberLinkedList {

	 int decimal=0; int power=1;
	    private int getDecUtil(ListNode head){
	        
	        if(head!=null){
	            getDecUtil(head.next);
	            decimal += head.val * power;
	            power *= 2;
	        }
	        
	        return 0;
	    }
	    
	    public int getDecimalValue(ListNode head) {
	    	getDecUtil(head);
	        return decimal;
	    }
	    
	    
	    public static void main(String[] args) {
			ListNode head = new ListNode(0);
			head.next = new ListNode(0);
//			head.next.next = new ListNode(1);
			
			ConvertBinaryNumberLinkedList conv = new ConvertBinaryNumberLinkedList();
			
			System.out.println("-- dec : " +  conv.getDecimalValue(head));
		}
	
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }