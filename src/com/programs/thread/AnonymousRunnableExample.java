package com.programs.thread;

public class AnonymousRunnableExample {
	public static void main(String[] args) {
		Runnable myRunnable = new Runnable() {

			public void run() {
				System.out.println("Inside Runnable -- Thread state: " +Thread.currentThread().getState());
				System.out.println("Inside RUnnale -- thread name: " +Thread.currentThread().getName());
			}
			
		};
		
		Thread myThread = new Thread(myRunnable);
		myThread.start();
		System.out.println("Thread Name: " +myThread.getName());
		System.out.println("Thread Group: " +myThread.getThreadGroup());
	}
}
