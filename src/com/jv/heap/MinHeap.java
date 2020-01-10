package com.jv.heap;

import java.util.Arrays;

/**
 * Trying to implement min heap.
 * @author Jeevi.Natarajan
 *
 */
public class MinHeap {

	private int [] heap;
	private int size;
	
	public MinHeap(int length) {
		this.heap = new int[length+1];
	}
	
	public void insert(int x) {
		heap[size] = x;
		size++;
		percolateUp(size-1);
	}
	
	
	public int getMin() {
		if(isEmpty())
			throw new RuntimeException("Heap is empty!");
		
		return heap[0];
	}
	
	public void deleteMin() {
		//swap the last elem with root.
		swap(heap, 0, size-1);
		size--;
		percolateDown(0);
	}
	
	private boolean isEmpty() {
		return size==0;
	}
	
	private void percolateDown(int i) {
		
		if(i>=size)
			return ;
		
		if((2*i+1)<size && heap[i]>heap[2*i+1]) {
			swap(heap, i, 2*i+1);
			percolateDown(2*i+1);
		}
		if((2*i+2)<size && heap[i]>heap[2*i+2]) {
			swap(heap, i, 2*i+2);
			percolateDown(2*i+2);
		}
		
	}
	
	private void percolateUp(int i) {
		if(i<=0)
			return ;
		
		if(heap[i]<heap[i/2]) {
			swap(heap, i, i/2);
			percolateUp(i/2);
		}			
	}
	
	private void swap(int [] heap , int i , int j) {
		int tmp = heap[i];
		heap[i] = heap[j] ;
		heap[j] = tmp;
	}
	
	public static void main(String[] args) {
		
		MinHeap heap = new MinHeap(10);
		heap.insert(5);
		heap.insert(10);
		heap.insert(20);
		heap.insert(15);
		
		System.out.println("--- getMin : " + heap.getMin());
		heap.insert(1);
		
		System.out.println(Arrays.toString(heap.heap));
		System.out.println("-- GetMin : " + heap.getMin());
		
		
		heap.deleteMin();
		System.out.println(Arrays.toString(heap.heap));
			
		
		heap.deleteMin();
		System.out.println("-- getMin : " +  heap.getMin());
		
		
		
	}
}



