package com.programs.graph;

public class BFSDirected {

	int V;
	int[][] graph;
	boolean[] visited;
	
	public static void main(String[] args) {
		int[][] graph = {{0,1,1,0},
						 {0,0,1,0},
						 {1,0,0,1},
						 {0,0,0,1}
						};
		int[][] graph2 = {{0,1,1,0,0,0},
						 {1,0,0,1,1,0},
						 {1,0,0,0,1,0},
						 {0,1,0,1,1,1},
						 {0,1,1,1,0,1},
						 {0,0,0,1,1,0}
						};
		BFSDirected bfs = new BFSDirected();
		bfs.bfsTraversal(graph2);
	}
	
	public void bfsTraversal(int[][] graph) {
		boolean[] visited = new boolean[graph.length];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		Queue queue = new Queue(100);
		queue.enQueue(2);
		visited[2] = true;
		
		while(!queue.isEmpty()) {
			int ele = queue.deQueue();
			System.out.println("ele: "+ele);
			for(int i=0; i<visited.length; i++) { //O(V) complexity
				if(graph[ele][i] == 1 && !visited[i]) {
					queue.enQueue(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
	public class Queue {
		int N;
		int front = -1;
		int rear = -1;
		int[] queue;
		
		public Queue(int n) {
			this.N = n;
			queue = new int[N];
		}
		
		public void enQueue(int ele) {
			if(isFull()) {
				System.out.println("helpless");
			} else if(isEmpty()) {
				front =0;
				rear = 0;
				queue[rear] = ele;
			} else {
				rear = (rear + 1) % N ;
				queue[rear] = ele;
			}
		}
		
		public int deQueue() {
			if(isEmpty()) {
				System.out.println("helpless");
				return -1;
			} else {
				int ele = queue[front];
				front = (front+1)%N;
				if((rear+1)%N == front) {
					front = -1;
					rear = -1;
				}
				return ele;
			}
		}
		
		public boolean isFull() {
			return front == ((rear + 1) % N);
		}
		
		public boolean isEmpty() {
			return front == -1 && rear == -1;
		}
	}
}
