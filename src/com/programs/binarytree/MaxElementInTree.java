package com.programs.binarytree;


public class MaxElementInTree {
	
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
	
	int maxElement(Node root) {
		int leftMax, rightMax,max = Integer.MIN_VALUE;
		if(root != null) {
			//int tempMax; WE DONT NEED TEMP MAX HERE. WHY? BCOZ MAX U R INITING TO MIN VALUE IN EVERY METHOD
			//AND IT HOLDS MIN VALUE ALL THE TIME. THE MAX VALUE IS HOLDED BY RETURN VALUE OF THIS METHOD
			leftMax = maxElement(root.left);
			rightMax = maxElement(root.right);
			max = root.data;
			if(rightMax > max) {
				max = rightMax;
			}
			if(leftMax > max) {
				max = leftMax;
			}
			/*if(tempMax > max) {
				max = tempMax;
			}*/
		}
		return max;
	}

	/**
	 * This method fails BIZZARELY cos max ele returned is always root node
	 * You should store the results globally or return the values and compare
	 * @param root
	 * @param max
	 * @return
	 */
	int maxElePreOrder(Node root, int max) {
		if(root == null) {
			return max;
		} else if(root.data > max){
			max = root.data;
		}
		maxElePreOrder(root.left, max);
		maxElePreOrder(root.right, max);
		return max;
	}
	public static void main(String args[]) {
		MaxElementInTree btree = new MaxElementInTree();
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(60);
		
		root.left.left.left = new Node(7);
		
		System.out.println("max ele of a tree: " +btree.maxElement(root));
		System.out.println("max ele of a tree: " +btree.maxElePreOrder(root, Integer.MIN_VALUE));
		
	}
}
