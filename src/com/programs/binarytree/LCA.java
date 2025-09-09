package com.programs.binarytree;

import com.programs.binarytree.BTreeTraversal.Node;

public class LCA {
	
	public static void main(String[] args) {
		Node root = formTree();
		System.out.println("LCA is: " +lca(root, 2, 3).data);
		System.out.println("LCA is: " +lca(root, 1, 3).data);
		System.out.println("LCA is: " +lca(root, 4, 7).data);
 		System.out.println("LCA is: " +lca(root, 2, 5).data);
		System.out.println("LCA is: " +lca(root, 6, 7).data);
	}
	
	private static Node lca(Node root, int left, int right) {
		if(root == null) {
			return null;
		} else if(root.data == left || root.data == right) {
			return root;
		}
		Node leftLca = lca(root.left, left, right);
		Node rightLca = lca(root.right, left, right);
		if(leftLca != null && rightLca != null) {
			return root;
		} else if(leftLca != null) {
			return leftLca;
		} else {
			return rightLca;
		}
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
