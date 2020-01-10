package com.jv.dll;

public class DllNode {
	
	private int data;
	private DllNode prev;
	private DllNode next;
	
	public DllNode(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public DllNode getPrev() {
		return prev;
	}
	
	public void setPrev(DllNode prev) {
		this.prev = prev;
	}
	
	public DllNode getNext() {
		return next;
	}
	
	public void setNext(DllNode next) {
		this.next = next;
	}
	
}
