package com.programs.linkedlist;

public class ReverseSLLPractise {
	
	public static void main(String[] args) {
		Node root = formLL();
		root = reverseLL(root);
		printLL(root);
		System.out.println();
		root = reverseLLRec(root, null);
		printLL(root);
	}
	
	private static Node reverseLLRec(Node cur, Node prev) {
		if(cur == null) {
			return prev;
		}
		//tail recursion
		Node next = cur.next;
		cur.next = prev;
		prev = cur;
		cur = next;
		return reverseLLRec(cur, prev);
	}

	private static void printLL(Node root) {
		while(root != null) {
			System.out.print(root.data +" ");
			root = root.next;
		}
	}

		private static Node reverseLL(Node root) {
		Node prev = null, cur = root, next = null;
		if(root == null || root.next == null) {
			return root;
		}
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev; //bcoz cur will be null;
	}
	
	private static Node formLL() {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		return root;
	}

	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
