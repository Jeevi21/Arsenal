package com.jv.list;

/**
 * Just detect the loop in linked LIst. 
 * @author Jeevi.Natarajan
 *
 */
public class DetectAndRemoveLoopInList {
	
	
	public static void detectAndRemoveLoop(ListNode head) {
		
		if(head!=null) {
			
			//Check for loop
			ListNode fastPtr = head.next;
			ListNode slowPtr = head;
			
			while(fastPtr!=null && fastPtr.next!=null) {
				if(fastPtr==slowPtr)
					break;
				
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
			}
			
			if(fastPtr!=null) { //there is a loop.. Now remove the loop...
				
				slowPtr = head;
				
				while(slowPtr!=null & fastPtr.next!=null) {
					
					if(slowPtr==fastPtr.next) { //They meet at the start of loop...
						fastPtr.next=null; // this removes the loop.
						break;
					}
					
					slowPtr = slowPtr.next;
					fastPtr = fastPtr.next;
				}	
			}
		}
		
	}
	
	/**
	 * Detecting the loop.
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {
		
		if(head!=null) { //TODO remember this as well.
		
			ListNode fastPtr = head.next; //TODO notice this.. you initialized it to head before. 
			ListNode slowPtr = head;
			
			while(fastPtr!=null && fastPtr.next!=null) {
				
				if(fastPtr==slowPtr)
					return true;
				
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;
				
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ListNode head = LinkedList.getMyDefaultList();
		
		ListNode tail = LinkedList.getTail(head);
		
		System.out.println(" -- tail is  : " + tail.data);
		
		tail.next= head; //Introduced a loop
		
		
		System.out.println("--Does this have cycle : " + hasCycle(head));
		
		detectAndRemoveLoop(head);
		
		System.out.println("--Does this have cycle : " + hasCycle(head));
		
		LinkedList.printList(head);
		
	}

}
