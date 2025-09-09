package com.programs.thread;

public class SharedRunnableExample {

	
	public static void main(String[] args) {
		
	}
	
	public static class MyRunnable implements Runnable {

		@Override
		public void run() {
			
		}
		
	}
	
	public static class NotThreadSafeObject {
		int value = 0;
		
		public void add() {
			value = value+1;
		}
		
		public int get() {
			return value;
		}
	}
	
}
