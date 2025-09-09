package com.programs.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;
import java.util.ArrayList;

public class ThreadPoolDesign {/*

	static int count = 0;
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> taskQueue = new BlockingQueue<>();
		List<SingleThread> threads = new ArrayList<>(3);
		
		//created thread pool
		System.out.println("Started creating threads");
		for(int i=0; i<3; i++) {
			SingleThread thread = new SingleThread(taskQueue, true);
			threads.add(thread);
			thread.start();
		}
		
		//adding tasks to the queue
		System.out.println("Started adding tasks");
		for(int i=0; i<=20; i++) {
			//Can't pass name to the Runnable
			//We can pass name to the Thread though
			Runnable task = new Runnable() {
				public void run() {
					System.out.println("Runnable: " +" " + ++count  +" "+Thread.currentThread().getName());
					try {
						Thread.sleep(1000L);						
					} catch(InterruptedException e) {
						
					}
				}
			};
			try {
				taskQueue.put(task);
			} catch(InterruptedException e) {
				
			}
		}
		Thread.sleep(1000L);
		System.out.println("Stopping Threads: " +threads.size());
		for(SingleThread thread: threads) {
			thread.setRunning(false);
		}
	}
	
	public static class SingleThread extends Thread {
		
		BlockingQueue<Runnable> queue;
		boolean run;
		
		public SingleThread(BlockingQueue<Runnable> queue, boolean run) {
			this.queue = queue;
			this.run = run;
		}
		
		public void setRunning(boolean run) {
			this.run = run;
		}
		
		public void run() {
			try {
				while(this.run) {
					Runnable r = queue.take();
					r.run();
				}
				System.out.println("Completed Running: " +getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
*/}
