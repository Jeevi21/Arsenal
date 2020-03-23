package com.jv.java.threads.numbers;

public class PrinterThread implements Runnable {

	private volatile int count;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public void run() {
		
		synchronized(this) {
			while(count%2!=0) {
				
				
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//Its odd..
				System.out.print(count);
				count++;
				notify();
			}
		}
	}
	


	
}
