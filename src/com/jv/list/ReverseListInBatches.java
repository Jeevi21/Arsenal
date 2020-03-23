package com.jv.list;

import com.jv.utils.CommonUtils;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class ReverseListInBatches {

	public static ListNode reverseInK(ListNode head,int k) {
		
		if(head==null)
			return null;
		
		
		ListNode cur = head;
		ListNode prev = null;
		ListNode prevTail =null;
		ListNode first = null;
		ListNode mainHead = null;
		
		while(cur!=null) {
			
			int count=0;
			first = cur;
			
			while(cur!=null && count<k) {
				//reverse
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				
				count++;
			}
			
			//Now it has reversed the first chuck.
			
			if(mainHead==null) // This will be set only for first time.
				mainHead = prev;
			
//			prev.next = null;
			first.next = cur;
			if(prevTail!=null)
				prevTail.next = prev;
			
			prevTail = first;
			prev = prevTail;
				
		}
		
		return mainHead;
		
	}
	
	public static void main(String [] args) {
		
		ListNode head = CommonListUtil.getDefaultList(8);
		
		CommonListUtil.printList(head);
		
		ListNode revHead = reverseInK(head, 3);
		
		System.out.println("************After Reversal***********");
		
		CommonListUtil.printList(revHead);
	}
	
}
