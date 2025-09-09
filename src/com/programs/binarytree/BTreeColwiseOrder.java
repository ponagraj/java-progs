package com.programs.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.programs.binarytree.LCA.Node;

public class BTreeColwiseOrder {
	public static void main(String[] args) {
		Node root = formTree();
		Map<Integer, List<Integer>> map = new HashMap<>();
		colWisePrinting(root, map, 0);
		for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
			//for(Integer value: entry.getValue()) {
				System.out.println("key: " +entry.getKey() +" value: " +entry.getValue().toString()) ;
			//}
		}
	}
	
	private static void colWisePrinting(Node root, Map<Integer,List<Integer>> map, int col) {
		if(root == null) {
			return;
		}
		//add index to map
		List<Integer> list = map.get(col);
		if(list == null) {
			list = new ArrayList<Integer>();
		}
		list.add(root.data);
		map.put(col, list);
		
		colWisePrinting(root.left, map, col-1);
		colWisePrinting(root.right, map, col+1);;
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
