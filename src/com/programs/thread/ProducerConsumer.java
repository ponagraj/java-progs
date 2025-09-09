package com.programs.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Doubts:
 * 1. Should the producer be Thread or Runnable? => 
 * Better if it Runnable.
 * 
 * 2. Should I declare the queue globally ? => Better to pass it as arg
 * to the class
 * 
 * 3. MOST IMPORTATNT OF ALL
 * for BlockingQueue => put, take are the methods that wait
 * add, remove => methods work normal and can throw exception.
 * You may need to control the queue using while blocks before
 * accessing the queue. 
 * Ex:-  
 * while(queue.size() == 10) {
 *				//wait, for the queue to get empty
 *				}
 * 
 * @author VineelaNagu
 *
 */
public class ProducerConsumer {
	
	/**
	 * create producer class => add to queue
	 * create consumer class => take from queue
	 * create a common queue b/n both
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		//bounded queue anta. => 10
		//unbounded queue aithey => max value is Integer.MAX_VALUE
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
		
		Producer prod = new Producer(queue);
		Consumer con = new Consumer(queue);
		
		new Thread(new Producer(queue), "Producer Thread").start();
		new Thread(new Consumer(queue), "Consumer Thread").start();
	}
	
	
	public static class Producer implements Runnable {
		
		private BlockingQueue queue;
		
		public Producer(BlockingQueue queue) {
			this.queue = queue;
		}
		
		int count = 0;
		public void run() {
			while(true) {
				try {
					System.out.println("Producing: " +queue.size() +" ");
					//put return type is void so can't do it in syso.
					//add return type is boolean so can do it in syso
					queue.put(count);
					Thread.sleep(1L);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}

				count++;
			}
		}
	}
	
	public static class Consumer implements Runnable {

		BlockingQueue queue; 
		
		public Consumer(BlockingQueue queue) {
			this.queue = queue;
		}
		public void run() {
			while(true) {
				try {
					System.out.println("Consuming: " +queue.size() + " " +queue.take());
					Thread.sleep(1L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
