package com.programs.stacknqueue;

public class Stack {
	int SIZE;
	int[] stack;
	int top = -1;
	
	public Stack(int size) {
		this.SIZE = size;
		stack = new int[size];
	}
	
	public void push(int ele) {
		if(isFull()) {
			System.out.println("cannot push ele");
		} else {
			top++;
			stack[top] = ele;
			System.out.println("element pushed: "+ele);
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("cannot pop.. already empty..");
			return -1;
		} else {
			int ele = stack[top];
			top--;
			System.out.println("element popped: "+ele);
			return ele;
		}
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE-1;
	}
	
	public static void main(String args[]) {
		Stack stack = new Stack(3);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.pop();
		stack.push(40);
		stack.pop();
		stack.pop();
		stack.pop();
	}
}
