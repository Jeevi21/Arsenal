package com.jv.java.threads.callbacks;
/**
 * Idea is to check after main thread exit.. will my callback function able to print something.
 * @author Jeevi.Natarajan
 *
 */
public class ThreadJoin {
	
	public static void main(String [] args) throws InterruptedException {
		
		NumberPrinterThread  printer = new NumberPrinterThread((msg,e)-> System.out.print(msg));
		Thread th = new Thread(printer);
		th.start();
		
		th.join();
		System.out.println("Exiting the main thread!");
		
	}

}
