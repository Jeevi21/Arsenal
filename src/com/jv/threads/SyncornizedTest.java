package com.jv.threads;

/**
 * Trying to simulate simple Syncronization
 * @author Jeevi.Natarajan
 *
 */
public class SyncornizedTest {
	
	
	public void print() throws InterruptedException {
		System.out.println("Hello" +  Thread.currentThread().getName());
		Thread.sleep(1000);
	}
	
	
	public static void main(String[] args) {
		
		for (int i=0 ;i <10;i++) {
			
			Thread t = new Thread(()-> {
				SyncornizedTest test = new SyncornizedTest();
				
			});
			
			
		}
		
	}

}
