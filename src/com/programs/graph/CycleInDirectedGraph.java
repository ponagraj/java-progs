package com.programs.graph;

public class CycleInDirectedGraph {
	
	public boolean findCycle(int[][] graph, boolean[] visited, boolean[] recStack, int v) {
		if (recStack[v]) { //found cycle
			return true;
		} else {
			recStack[v] = true; //visited the node first time in that stack call
		}
		
		if(!visited[v]) {//node not visited
			visited[v] = true;
		} else {
			return false;
		}
		for(int i=0; i<graph.length; i++) {
			if(graph[v][i] != 0) {
				if(findCycle(graph, visited, recStack, i)) {
					return true; //this return will break the loop and exit from this recursive method
				} else {
					//continue finding for a cycle
				}
			}
		}
		recStack[v] = false;
		return false;
		
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
		boolean[] visited = new boolean[graph.length];
		boolean[] recStack = new boolean[graph.length];
		CycleInDirectedGraph cycle = new CycleInDirectedGraph();
		//checking each tree starting with node 'i'
				for(int i=0; i<graph.length; i++) {
					for(int j=0; j<visited.length; j++) {
						visited[j] = false;
						recStack[j] = false;
					}
					System.out.println("Finding cycle in tree starting with node: "+i);
					System.out.println("Is cycle Present: " +cycle.findCycle(graph, visited, recStack, 0));
				}
		
	}
}
