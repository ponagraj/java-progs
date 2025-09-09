package com.programs.graph;

public class CycleInUndirectedGraph {

	boolean findCycle(int[][] graph, boolean[] visited, int v, int parent, int grandparent) {
		if(!visited[v]) {
			visited[v] = true;
		} else {
			if(v != grandparent) {
				return true;
			} else {
				return false; //we must return else it will keep loop as this is an undirected graph.
			}
		}
		
		for(int i=0; i<graph.length; i++) {//adjacent vertices of 'v'
			if(graph[v][i] != 0) {
				if(findCycle(graph,visited,i,v,parent)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		int[][] graph = {{0,1,1,1,0},  // 1--0--3
						 {1,0,1,0,0},  // | /   |
						 {1,1,0,0,0},  // 2     4
						 {1,0,0,0,1},
						 {0,0,0,1,0}
						};
		CycleInUndirectedGraph cycle = new CycleInUndirectedGraph();
		boolean[] visited = new boolean[graph.length];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		System.out.println("find cycle: " +cycle.findCycle(graph, visited, 0, -1,-1));
	}
}
