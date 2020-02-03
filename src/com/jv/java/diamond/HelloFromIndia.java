package com.jv.java.diamond;

public class HelloFromIndia implements HelloFromBangalore , HelloFromChennai {

	@Override
	public void sayHello() {
		System.out.println("Hello India!!");
	}
	
	
	public static void main(String[] args) {
		
		HelloFromChennai helloFromChennai = new HelloFromIndia();
		helloFromChennai.sayHello();
		
		
		HelloFromBangalore helloFromBangalore = new HelloFromIndia();
		helloFromBangalore.sayHello();
		
	}

}
