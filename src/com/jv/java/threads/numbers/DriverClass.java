package com.jv.java.threads.numbers;

public class DriverClass {
	
	private volatile int counter;
	
	public DriverClass() {
		counter =1;
	}
	
	public int getCounter() {
		return counter;
	}
	
	
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public static void main(String [] args) {
		DriverClass shared = new DriverClass();
		ThreadEven even = new ThreadEven(shared);
		PrinterThread odd = new PrinterThread(shared);
		
		Thread evenThread = new Thread(even);
		Thread oddThread = new Thread(odd);
		
		
		oddThread.start();
		evenThread.start();
		
		
		
		
	}
}
