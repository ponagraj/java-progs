package com.programs.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolCreation {
	
	private BlockingQueue<Runnable> queue;
	
	public static void main(String[] args) {
		ThreadPoolCreation pool = new ThreadPoolCreation();
		List<WorkerThread> threadPool = pool.initializePool(10, 10);
		pool.runThreads(threadPool);
		pool.addTasks();
	}
	
	private void addTasks() {
		for(int i=0; i<20; i++) {
			//IllegalStateException if full
			//queue.add(null);
			//check implementation next time
			//queue.offer(null);
			 
			try {
				queue.put(new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getId());
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void runThreads(List<WorkerThread> threadPool) {
		for(WorkerThread thread: threadPool) {
			try {
				thread.start();
			} catch(IllegalThreadStateException ex) {
				ex.printStackTrace();
			}
		}
	}

	private List<WorkerThread> initializePool(int noOfThreads, int queueSize) {
		queue = new ArrayBlockingQueue<>(queueSize);
		List<WorkerThread> threadPool = new ArrayList<>(noOfThreads);
		for(int i=0; i<noOfThreads; i++) {
			threadPool.add(new WorkerThread(queue));
		}
		return threadPool;
	}

	public static class WorkerThread extends Thread {
		
		private BlockingQueue<Runnable> queue;
		
		public WorkerThread(BlockingQueue<Runnable> queue) {
			this.queue = queue;
		}
		
		public void run() {
			//throws NoSuchElementException on empty
			//Runnable runnable = queue.remove();
			//return null if queue is empty
			//Runnable runnable = queue.poll();
			
			try {
				while(true) {
					//waits until an element is available
					Runnable runnable = queue.take();
					if(runnable != null) {
						runnable.run();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
