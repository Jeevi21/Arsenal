package com.jv.graph.weighted;

import java.util.PriorityQueue;

/**
 * Testing priority queue .. will updating a node will automatically be updated?  -- NOOO
 * 
 * https://stackoverflow.com/questions/1871253/updating-java-priorityqueue-when-its-elements-change-priority
 * 
 * 
 * @author Jeevi.Natarajan
 *
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(5 , (a,b)-> { 
			
			if(a.data == b.data)
				return 0;
			if(a.data>b.data)
				return 1;
			else 
				return -1;
		});
		queue.add(new Node(1 , " one"));
		queue.add(new Node(3 , " three"));
		queue.add(new Node(4 , " four"));
		
		Node node5 = new Node(5 , " five");
		queue.add(node5);
		
		
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		//i do it again.
		queue.add(new Node(1 , " one"));
		queue.add(new Node(3 , " three"));
		queue.add(new Node(4 , " four"));
		
		node5 = new Node(-9 , " five");
		queue.add(node5);
		
		//Now let me try to update 5 to 0.. head should return 0.
		
		node5.data =5;  // It is not working.. 
		//https://stackoverflow.com/questions/1871253/updating-java-priorityqueue-when-its-elements-change-priority
		
		System.out.println("---------");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		
		//i do it again.
				queue.add(new Node(1 , " one"));
				queue.add(new Node(3 , " three"));
				queue.add(new Node(4 , " four"));
				queue.add(new Node(5 , " four"));
				
				//Now let me try to update 5 to 0.. head should return 0.
				
				//https://stackoverflow.com/questions/1871253/updating-java-priorityqueue-when-its-elements-change-priority
				
				System.out.println("---------");
				while(!queue.isEmpty()) {
					System.out.println(queue.poll());
				}
		
				
				
	}
}

class Node{
	int data;
	String label;
	
	public Node(int data , String label) {
		this.data  = data;
		this.label = label;
	}
	
	@Override
	public String toString() {
		
		return "[" + this.label +" - " + this.data + " ] ";
	}
}
