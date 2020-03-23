package com.jv.java.collections;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Trying to create priorityQueue with fixed size.
 * @author Jeevi.Natarajan
 *
 */
public class QueueWithFixedSize {
	
	private static void addElement(Queue<Integer> priorityQueue , int elem , int maxSize) {
		
		priorityQueue.add(elem);
		if(priorityQueue.size()>maxSize)
			priorityQueue.poll();
	
	}
	
	
	
	public static void main(String[] args) {
		
		int maxSize = 3;
		Queue<Integer> priorityQueue = new PriorityQueue<>(maxSize); //This is initial capacity.
		
		//Comparator is requried.. Here it is not there bcoz Integer implemetns comparable... and its MIN_HEAP
		
		for(int i=0;i<5;i++) {
			addElement(priorityQueue, i, maxSize);
			System.out.println(priorityQueue);
		}
		
		
	}

}
