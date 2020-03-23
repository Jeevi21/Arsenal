package com.jv.java.threads.callbacks;

/**
 * This piece can be executed by Threads. 
 * @author Jeevi.Natarajan
 *
 */
public class NumberPrinterThread implements Runnable{
	
	private Icallback callback;
	
	public NumberPrinterThread(Icallback callback) {
		this.callback = callback;
	}

	@Override
	public void run() {
		
		//Just print 1 to 10 and return sucess.
		
		for(int i=1;i<=10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		callback.onComplete("sucess" , null);  //After finishing my task I am calling the callback.
		

	}

}
