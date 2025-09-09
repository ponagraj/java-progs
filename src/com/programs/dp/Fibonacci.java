package com.programs.dp;

/**
 * The general case:
the number of solutions to the problem of size n can be explained as the number of solutions to the problem of size (n-1) PLUS the number of solutions of the problem of size (n-2), i.e.
if f(n) is "the number of solutions to the problem of size n" then f(n) = f(n-1) + f(n-2)
This is called the general case because it must apply for all sizes, n, of the puzzle.

 * @author VineelaNagu
 *
 */
public class Fibonacci {

	int fibRec(int n) { 
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return fibRec(n-1) + fibRec(n-2);
		}
		
	}
	
	int fibTabular(int n) {
		int[] fib = new int[n+1];
		for(int i=0; i<fib.length; i++) {
			if(i <=1) {
				fib[i] = i;
			}
			else {
				fib[i] = fib[i-1] + fib[i-2];
			}
		}
		return fib[n];
	}
	
	int fibMemoization(int[] memoize, int n) {
		if(n <= 1) {
			memoize[n] = n;
			return n;
		} else	if(memoize[n] != -1) {
			return memoize[n];
		} else {
			memoize[n] = fibMemoization(memoize, n-1) + fibMemoization(memoize, n-2);
			return memoize[n];
		}
	}
	
	public static void main(String[] args) {
		int ele = 10;
		Fibonacci rec = new Fibonacci();
		System.out.println(rec.fibRec(ele));
		
		System.out.println(rec.fibTabular(ele));
		
		int[] memoize = new int[ele+1];
		for(int i=0; i<memoize.length; i++) {
			memoize[i] = -1;
		}
		System.out.println(rec.fibMemoization(memoize,ele));
	}
}
