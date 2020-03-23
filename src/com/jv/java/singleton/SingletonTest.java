package com.jv.java.singleton;

public class SingletonTest {


	private SingletonTest(){}
	
	private static SingletonTest getInstance(){
		System.out.println("Instance");
		return new SingletonTest();
	}	
	
	public static void main(String [] args){
		SingletonTest.getInstance();
	}
}
