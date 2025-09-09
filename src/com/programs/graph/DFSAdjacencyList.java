package com.programs.graph;

import java.util.LinkedList;

public class DFSAdjacencyList {
	
	private int V;
	private LinkedList<Integer>[] adjList;
	
	public DFSAdjacencyList(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		for(int i=0; i<adjList.length; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	private void addEdge(int v1, int v2) {
		adjList[v1].add(v2);
	}
	public static void main(String[] args) {
		DFSAdjacencyList graph1 = new DFSAdjacencyList(4);
		graph1.addEdge(0, 1);graph1.addEdge(0, 2);
		graph1.addEdge(1, 2);
		graph1.addEdge(2, 0);graph1.addEdge(2,3);
		graph1.addEdge(3,3);
		
		graph1.callDfs();
		
		int[][] graph2 = {{0,1,1,0,0,0}, // 0->1, 0->2
				 {1,0,0,1,1,0}, //1->0, 1->3, 1->4
				 {1,0,0,0,1,0}, //2->0, 2->4
				 {0,1,0,1,1,1}, //2->1, 2->3,2->4,2->5
				 {0,1,1,1,0,1}, 
				 {0,0,0,1,1,0}
				};
	}
	
	private void callDfs() {
		boolean[] visited = new boolean[V];
		dfs(visited, 2);
	}
	
	private void dfs(boolean[] visited, int v) {
		if(visited[v]) {
			//already visited
		} else {
			LinkedList<Integer> list = adjList[v];
			visited[v] = true;
			System.out.print(v +" ");
			for(Integer node : list) {
				dfs(visited,node);
			}
		}
	}
	
	
}
