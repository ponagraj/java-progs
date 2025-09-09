package com.programs.stacknqueue;

public class Queue {
	int[] queue;
	int SIZE;
	int front = -1, rear = -1;
	
	public Queue(int size) {
		this.SIZE = size;
		queue = new int[SIZE];
	}
	
	public void enqueue(int ele) {
		if(isFull()) {
			System.out.println("Q full");
		} else if(isEmpty()) {
			front = 0; rear = 0;
			queue[rear] = ele;
			System.out.println("first ele enQueued: "+ele +"at position: " +rear);
		} else {
			rear = (rear + 1) % SIZE;
			queue[rear] = ele;
			System.out.println("ele enQueued: "+ele +" at position: " +rear);
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Q empty");
			return -1;
		} else {
			int ele = queue[front];
			front = (front + 1) % SIZE;
			if(isFull()) {//it appears like full but its actually empty
				front = -1;
				rear = -1;
			}
			System.out.println("ele dequeeud: "+ele);
			return ele;
		}
	}
	
	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}
	
	public boolean isFull() {
		return (rear + 1) % SIZE == front;
	}
	
	public static void main(String args[]) {
		Queue queue = new Queue(3);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		queue.dequeue();
		
		queue.enqueue(40);
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}
}
