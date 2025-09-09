package com.programs.linkedlist;

public class ReverseSLLComplicated {
	public class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String args[]) {
		ReverseSLLComplicated ll = new ReverseSLLComplicated();
		Node head = ll.createLL();
		ll.printLL(head);
		/*Node head2 = ll.reverseLL(head, null);
		ll.printLL(head2);*/
		System.out.println("Doing iterative reverse");
		Node head3 = ll.reverseIterative(head);
		ll.printLL(head3);
	}
	
	private Node reverseWithChecks(Node cur, Node prev) {
		if(cur == null) {
			return cur;
		} else {
			return reverseLL(cur, prev);
		}
	}
	
	private Node reverseLL(Node cur, Node prev) {
		if(cur.next == null) {
			cur.next = prev;
			return cur;
		} else {
			Node next = cur.next;
			cur.next = prev;
			return reverseLL(next, cur);
		}
	}
	
	private Node reverseIterative(Node head) {
		if(head == null) {
			return head;
		}
		Node prev = null; //initially pointing to null
		Node cur = head;
		Node next = null; //can be null or cur.next but doesn't matter as we override
		while(cur.next != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		if(cur.next == null) {
			cur.next = prev;
			head = cur;
		}
		return head;
	}
	
	private Node createLL() {
		Node head = new Node(10);
		
		Node node1 = new Node(20);
		head.next = node1;
		
		Node node2 = new Node(30);
		node1.next = node2;
		
		Node node3 = new Node(40);
		node2.next = node3;
		
		Node node4 = new Node(50);
		node3.next = node4;
		
		return head;
	}
	
	private void printLL(Node head) {
		System.out.println("Printing the linked list");
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
