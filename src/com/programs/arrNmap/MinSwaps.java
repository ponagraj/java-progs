package com.programs.arrNmap;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	boolean[] visited = new boolean[arr.length];
    	int minKeyIndex = getMinKey(arr, visited);
    	int startIndex = 0;
    	int swapCount = 0;
    	while(minKeyIndex != -1) {
    		if(minKeyIndex != startIndex) {
    	  		int temp = arr[startIndex];
        		arr[startIndex] = arr[minKeyIndex];
        		arr[minKeyIndex] = temp;
        		swapCount++;
    		}
    		visited[startIndex] = true;
    		startIndex++;
    		minKeyIndex = getMinKey(arr, visited);
    	}
    	return swapCount;
    }
    
    static int getMinKey(int[] arr, boolean[] visited) {
    	int minKey = Integer.MAX_VALUE, minKeyIndex = -1;
    	for(int i=0; i<arr.length; i++) {
    		if(visited[i] == false && minKey > arr[i]) {
    			minKey = arr[i];
    			minKeyIndex = i;
    		}
    	}
    	return minKeyIndex;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

       // bufferedWriter.write(String.valueOf(res));
       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }
}

