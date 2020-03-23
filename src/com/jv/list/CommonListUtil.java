package com.jv.list;

/**
 * 
 * @author Jeevi.Natarajan
 *
 */
public class CommonListUtil {
	
	public static void printList(ListNode head) {
	
		if(head==null) {
			System.out.println("List is Empty!");
			return ;
		}
		
		while(head!=null) {
			System.out.print(head.data +" -> ");
			head = head.next;
		}
	
		System.out.println();
	}
	
	
	public static ListNode getDefaultList(int n) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		return head;
		
		
	}
	
	public static void main(String args[]) {
		
	}

}
