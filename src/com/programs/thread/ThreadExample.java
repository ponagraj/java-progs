package com.programs.thread;

public class ThreadExample extends Thread {
	
	public static void main(String args[]) {
		ThreadExample sample = new ThreadExample();
		sample.start();
		

		Thread anonymousThread = new Thread("Type 2 Initialization") {
			
			public void run() {
				System.out.println("Hi, I am an anonymous dude: " +getName());
			}
		};
		
		//you need to do the start after thread initialization
		anonymousThread.start();
		
		//we can't predict the order of thread execution
		
		//I'm stuck on how to pass the value 'i' to the thread
		//Declaring outside is error. Declaring inside is always printing 0.
		//How??? Think for a minute dude!!
		//NAGU: THIS IS FANTASTIC. NEVER SAY AGAIN. YOU DONT KNOW THREADS.
		//Update: Better to create a class and pass object to constructor :P
		System.out.println("Thread Name: " +Thread.currentThread().getName());
		for(int i=0; i<10; i++) {
			new Thread(i + "") {

				public void run() {
					System.out.print(getName() + " ");

				}
				
			}.start();
		}
	}
	
	public void run() {
		System.out.println("Hi, I am extend Thread class type: " +getName());
	}
}
