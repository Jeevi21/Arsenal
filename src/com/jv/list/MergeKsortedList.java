package com.jv.list;

import java.util.List;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class MergeKsortedList {
	
	
	public static ListNode mergeSortedList(ListNode a , ListNode b) {
		
		if(a==null)
			return b;
		
		if(b==null)
			return a;
		
		
		
		ListNode head= null;
		
		if(a.data<b.data)
			head = a;
		else
			head=b;
		
		a = a.next;
		b=b.next;
		while(a!=null && b!=null) {
			if(a.data<b.data) {
				head.next = a;
				a=a.next;
			}
			else {
				head.next = b;
				b=b.next;
			}
		}
		
		if(a!=null)
			head.next=a;
		
		if(b!=null)
			head.next=b;
		
		return head;
		
	}
	
	
	public static ListNode mergeSortedListRec(ListNode a , ListNode b) {
		
		if(a==null)
			return b;
		if(b==null)
			return a;
		
		if(a.data<b.data) {
			a.next = mergeSortedListRec(a.next, b);
			return a;
		}
		else {
			b.next = mergeSortedListRec(a, b.next);
			return b;
		}
		
	}
	
	
	public static ListNode mergeKLists(List<ListNode> list ) {
	
		if(list==null)
			return null;
		
		
		
		int interval=1;
		
		while(interval<list.size()) {
			
			for(int j=0;j<list.size();j+=interval) {
				
				list.set(j, mergeSortedListRec(list.get(j), list.get(j+interval)));
				
			}
			
			interval*=2;
		
		}
		
		
		
		return list.get(0);
		
	}
	
	public static void main(String[] args) {
		
		int interval=1 , k=7;
		
		while(interval< k) {
			
			for(int j=0;j<k-interval;j+=interval) {
				
				System.out.println(j +" --- "+ (j+interval));
				j=j+interval;
				
			}
			System.out.println();
			
			interval*=2;
		}
		
		
		
	}

}
