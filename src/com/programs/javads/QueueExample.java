package com.programs.javads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

		public static void main(String[] args) {
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			//add elements
			queue.add(10);
			queue.add(20);
			queue.add(30);
			
			//print ele
			System.out.println("present queue items");
			queue.forEach(ele -> { System.out.println(ele); });
			
			Integer dequeuedValue = queue.poll();
			System.out.println("dequeued value: " +dequeuedValue);
		
			Integer peekValue = queue.peek();
			System.out.println("peeked value: " +peekValue);
			
			//print ele
			System.out.println("present queue items");
			queue.forEach(ele -> { System.out.println(ele); });
			
			System.out.println("present queue items");
			Iterator<Integer> queueIterator = queue.iterator();
			while(queueIterator.hasNext()) {
				System.out.print(queueIterator.next() +" ");
			}
			System.out.println("is queue empty: " +queue.isEmpty());
			
		}
}
