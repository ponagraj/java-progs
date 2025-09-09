package com.programs.thread;

public class RunnableExample {

	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable());
		thread.start();
		Thread thread2 = new Thread(new MyRunnable());
		thread2.start();
	}
	
	public static class MyRunnable implements Runnable {
		
		public void run() {
			System.out.println("I'm runnable");
		}
	}
}
