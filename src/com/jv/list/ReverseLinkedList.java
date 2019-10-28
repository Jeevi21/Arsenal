package com.jv.list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author Jeevi.Natarajan
 *
 */
public class ReverseLinkedList {

	
	public static ListNode reverse(ListNode head) {
		
		ListNode prev = null, next = null;
		ListNode curr = head;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
		
	}
	
	private static ListNode reverseRecUtil(ListNode curr , ListNode prev) {
		
		if(curr==null)
			return prev;
		
		ListNode next = curr.next;
		
		curr.next = prev;
		prev = curr;
		curr = next;
		
		return reverseRecUtil(curr, prev);
		
		
	}
	
	public static ListNode reverseRec(ListNode head) {
		
		
		return reverseRecUtil(head, null);
		
		
	}
	
	public static void main(String[] args) {
		
		ListNode head = LinkedList.getMyDefaultList();
		
		System.out.println("-- My original List : ");
		LinkedList.printList(head);
		
		ListNode reversedList = reverse(head);
		System.out.println("--- My reversed List : ");
		LinkedList.printList(reversedList);
		
		
		ListNode recHead = LinkedList.getMyDefaultList(); 
		System.out.println("----------- Trying the reversing with recursion----");
		LinkedList.printList(recHead);
		ListNode reverseRecList = reverseRec(recHead);
		System.out.println("--- My reversed List using recursion : ");
		LinkedList.printList(reverseRecList);
		
		
	}
}
