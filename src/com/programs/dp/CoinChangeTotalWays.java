package com.programs.dp;

public class CoinChangeTotalWays {
	int totalSum = 0;

	/**
	 * This is the general approach I think of when recursion comes into mind.
	 * It is good to first try using include/exclude principle before coming up with this
	 * @param N
	 * @param S
	 * @param sum
	 * @param index
	 * @return
	 */
	int totalWaysRecursiveLoop(int N, int[] S, int sum, int startIndex) {
		if(sum == N) {
			totalSum++;
			return 1;
		}
		if(sum > N) {
			return 0;
		}
		for(int i=startIndex; i<S.length; i++) {//startIndex is very important here otherwise we will endup visiting same
			//solution multiple times.
			totalWaysRecursiveLoop(N, S, sum + S[i], i);
		}
		return 0;
	}
	
	int totalWaysIncludeExclude(int N, int[] S, int sum, int startIndex) {
		if(sum == N) {
			return 1;
		}
		if(sum > N || startIndex >= S.length) {
			return 0;
		}
		return totalWaysIncludeExclude(N, S, sum+S[startIndex], startIndex) +
				totalWaysIncludeExclude(N, S, sum, startIndex+1);
	}
	
	int totalWaysDP(int N, int[] coins) {
		int[] change = new int[N+1];
		change[0] = 1; //for 0 rupee change the total ways possible is 0
		for(int i=0; i<coins.length; i++) { //for each coin
			for(int j=0; j<change.length; j++) { //where ever that coin fits add 1 to the change
				if(j >= coins[i]) { //if the change j is greater than coin value
					change[j] = change[j] + change[j - coins[i]];
				}
			}
		}
		
		return change[N];
		//the below solution is wrong. It will add duplication
		/*for(int i=0; i<change.length; i++) { //for each change
			for(int j=0; j<coins.length; j++) { //try with all the coins for each change
				if(i >= coins[j]) { //if the change i is greater than coin value
					change[i] = change[i] + change[i - coins[j]];
				}
			}
		}*/
	}
	
	public static void main(String[] args) {
		int N = 4;
		int[] S = {1, 2, 3};
		//int N = 10;
		//int[] S = {2,5,3,6};
		CoinChangeTotalWays ways = new CoinChangeTotalWays();
		ways.totalWaysRecursiveLoop(N, S,0,0);
		System.out.println("Recursive For Loop: " +ways.totalSum);
		System.out.println("Include/Excldue: " +ways.totalWaysIncludeExclude(N, S, 0, 0));
		System.out.println("DP coin change: " +ways.totalWaysDP(N, S));
	}
}
