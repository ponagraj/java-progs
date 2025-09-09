package com.programs.thread;

public class SampleThread {

	public static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String args[]) {
		MyThread myThread = new MyThread();
		System.out.println("I am in main thread --start ");
		myThread.start();
		System.out.println("I am in main thread -- exit");
	}
}
