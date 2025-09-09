package com.programs.graph;

public class DFS {

	public void dfsTraversal(int[][] graph, boolean[] visited, int v) {
		if(!visited[v]) {
			System.out.println("visited: " +v);
			visited[v] = true;
		} else {
			return;
		}
		for(int i=0; i<graph.length; i++) {
			if(graph[v][i] != 0/* && !visited[i]*/) {//commented because it is good to check as base condition.
				                                     //useful for cycle finding etc.
				dfsTraversal(graph, visited, i);
			}
		}
		
	}
	public static void main(String[] args) {
		int[][] graph = {{0,1,1,0}, //0->1, 0->2
				 {0,0,1,0},  //1->2
				 {1,0,0,1}, //2->0, 2->3
				 {0,0,0,1} //3->3
				};
		int[][] graph2 = {{0,1,1,0,0,0}, // 0->1, 0->2
				 {1,0,0,1,1,0}, //1->0, 1->3, 1->4
				 {1,0,0,0,1,0}, //2->0, 2->4
				 {0,1,0,1,1,1}, //2->1, 2->3,2->4,2->5
				 {0,1,1,1,0,1}, 
				 {0,0,0,1,1,0}
				};
		DFS dfs = new DFS();
		boolean[] visited = new boolean[graph.length];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		//returns all the trees starting with node 'i'
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<visited.length; j++) {
				visited[j] = false;
			}
			System.out.println("Printing tree starting with node: "+i);
			dfs.dfsTraversal(graph, visited, i);
		}
	}
}