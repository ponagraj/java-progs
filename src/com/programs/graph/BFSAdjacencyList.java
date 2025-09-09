package com.programs.graph;

import java.util.LinkedList;

public class BFSAdjacencyList {

	int V;
	LinkedList<Integer>[] adjList;
	
	public BFSAdjacencyList(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		for(int i=0; i<V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
