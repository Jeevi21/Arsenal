package com.jv.stack;

import com.jv.dll.DllNode;

/**
 *  Idea is to have doubly linked list as underlying structure
 * @author Jeevi.Natarajan
 *
 */
public class DeleteMiddleStack {
	
	
	//doubly linked list.
	private DllNode tail;
	private int size;
	private DllNode middle;
	
	public DeleteMiddleStack() {
		this.tail=null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return (tail==null) ;
	}
	
	public void push(int data) {
		
		if(tail==null) {
			tail = new DllNode(data);
			middle=tail;
		}
		else {
			this.tail.setNext(new DllNode(data));
			this.tail = this.tail.getNext(); // tail = tail.next -- tail always points to the last night. 
		}
		size++;
		
		//update middle
		if(size%2==0)
			middle = middle.getNext();
		
	}
	
	public int peek() {
		if(!isEmpty()) 
			return tail.getData();
		
		return -1;
	}

	public int pop() {
		if(!isEmpty()) {
			int data =  tail.getData();
			tail = tail.getPrev();
			
			//Update middle
			if(size%2==0)
				middle = middle.getPrev();
			
			size--;
			return data;
		}
		
		return -1;
	}
	
	public int getMiddle() {
		
		if(!isEmpty()) {
			return middle.getData();
		}
		
		return -1;
	}
	
	public void deleteMiddle() {
		
		if(!isEmpty()) {
			DllNode tmp = middle;
			if(middle.getPrev()!=null)
				middle.getPrev().setNext(tmp.getNext());
			if(middle.getNext()!=null)
				middle.getNext().setPrev(tmp.getPrev());
			
			if(size%2==0) {
				middle = middle.getPrev();
				tmp=null;
			}
			
			size--;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		DeleteMiddleStack stack = new DeleteMiddleStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("--get middle : " + stack.getMiddle());
		stack.deleteMiddle();
		System.out.println("-- get middle : " + stack.getMiddle());
		
	}
}
