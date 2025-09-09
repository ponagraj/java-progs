package com.programs.binarytree;

public class BTDiameter {
	
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
	
	public int diameter(Node root) {
		if(root == null) {
			return 0;
		} else {
			int diameter = height(root.left) + height(root.right) + 1;// not pure binary height
			//but height of left sub tree + right sub tree + 1
			int ldiameter = diameter(root.left);
			int rdiameter = diameter(root.right);
			int maxDiameter = max(ldiameter, rdiameter);
			return max(diameter, maxDiameter);
		}
	}
	
	public int height(Node root) {
		if(root == null) {
			return 0;
		} else {
			return 1 + max(height(root.left), height(root.right));
		}
	}
	
	public int max(int a, int b) {
		return a > b ? a : b;
	}
	public static void main(String[] args) {
		
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		
		root.left.left.left = new Node(7);
		
		BTDiameter bt = new BTDiameter();
		System.out.println("diameter of the tree: " +bt.diameter(root));
	}
}
