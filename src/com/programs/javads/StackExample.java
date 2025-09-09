package com.programs.javads;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		//add ele
		stack.push("how");
		stack.push("are");
		stack.push("you");
		stack.add(0, "hi"); //at a specifed index
		
		//print stack
		System.out.println("print stack");
		stack.forEach(ele -> { System.out.println(ele); });
		
		//delete ele
		System.out.println("popped ele: "+stack.pop());
		
		System.out.println("peeked ele: " +stack.peek());

	}
}
