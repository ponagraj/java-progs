package com.programs.binarytree;

public class BTHeight {

	public static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	int max(int a, int b) {
		return a > b ? a : b;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	int heightOfATree(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + max(heightOfATree(root.left), heightOfATree(root.right));
	}
	
	public static void main(String args[]) {
		BTHeight btree = new BTHeight();
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		//root.left.left = new Node(4);
		//root.left.right = new Node(5);
		//root.right.left = new Node(6);
		
		//root.left.left.left = new Node(7);
		
		System.out.println("height of a tree: " +btree.heightOfATree(root));
	}
}
