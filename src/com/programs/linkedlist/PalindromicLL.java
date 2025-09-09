package com.programs.linkedlist;

public class PalindromicLL {

	public static class Node {
		private char data;
		private Node next;
		
		public Node(char data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/*public static boolean isPalindrome(Node last, Node slow) {
		if(last == slow) {
			return true;
		}
		// if()
	}*/
	
	public static void main(String args[]) {
		Node oddHead = new Node('n');
		oddHead.next = null;
		
		Node node2 = new Node('a');
		oddHead.next = node2;
		
		Node node3 = new Node('g');
		node2.next = node3;
		
		Node node4 = new Node('a');
		node3.next = node4;
		
		Node node5 = new Node('n');
		node4.next = node5;
		
		
	}
}
