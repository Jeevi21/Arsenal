package com.jv.list;

/**
 * This is my default linked list. 
 * @author Jeevi.Natarajan
 *
 */
public class LinkedList {
	
	/**
	 * It returns 1->2-> 3 -> 4-> 5
	 */
	public static ListNode getMyDefaultList() {
		
		ListNode head = new ListNode(1);
		ListNode curr = head;
		
		for(int i=2;i<=5;i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		
		return head;
	}
	
	public static ListNode getTail(ListNode head) {
		
		if(head==null)
			return null;
		
		ListNode curr = head;
		
		while(curr.next!=null) {
			curr = curr.next;
		}
		
		return curr;
		
	}
	
	public static void printList(ListNode head) {
		
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		
		System.out.println();
	}

}
