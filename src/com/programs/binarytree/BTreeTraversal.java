package com.programs.binarytree;

import java.util.concurrent.SynchronousQueue;

public class BTreeTraversal {
	
	public static void main(String[] args) {
		Node root = formTree();
		System.out.println("preorder");
		preorder(root);
		System.out.println("inorder");
		inorder(root);
		System.out.println("postorder");
		postorder(root);
	}
	
	private static void postorder(Node root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data +" ");
	}

	private static void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data +" ");
		inorder(root.right);
	}

	private static void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	private static Node formTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		return root;
	}
	
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
	
	
	
}
