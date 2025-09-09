package com.programs.dp;

public class SubsetSum {

	/**
	 * very old style of coding.
	 * better to come up with include/exclude principle
	 * looks short and sweet.
	 * @param set
	 * @param i
	 * @param sum
	 * @return
	 */
	boolean recSubsetSum(int[] set, int i, int sum) {
		if(sum == 0) {
			return true;
		} if(sum < 0) {
			return false;
		}
		if(i >= set.length) {
			if(sum == 0) {
				return true;
			} else {
				return false;
			}
		}
		for(int j=i; j<set.length; j++) {
			boolean isSubsetSum = recSubsetSum(set, j+1, sum-set[j]);
			if(isSubsetSum) {
				return true;
			}
		}
		return false;
	}
	
	boolean recSubSumIncludeExclude(int[] set, int i, int sum) {
		if(sum ==0) {
			return true;
		} else if(sum < 0) {
			return false;
		}
		return recSubSumIncludeExclude(set, i-1, sum) ||
				recSubSumIncludeExclude(set, i-1, sum-set[i]);
	}
	
	/**
	 * This approach is useful when we can use the
	 * same set element any number of times.
	 * @param set
	 * @param sum
	 * @return
	 */
	public boolean dpSubsumRepeatAllowed(int[] set, int sum) {
		boolean[] subsum = new boolean[sum+1];
		for(int i=0; i<set.length; i++) {
			subsum[i] = false;
		}
		subsum[0] = false;
		for(int i=1; i<=sum; i++) {
			for(int j=0; j<set.length; j++) {
				if(i == set[j]) {
					subsum[i] = true;
				} else if(i > set[j]) {
					subsum[i] = (subsum[i]) || (subsum[j] && subsum[i-j]);
				} else if(i < set[j]) {
					subsum[i] = subsum[i] || false;
				}
			}
		}
		return subsum[sum];
	}
	
	long countWays(int S[], int m, int n) 
    { 
        //Time complexity of this function: O(mn) 
        //Space Complexity of this function: O(n) 
  
        // table[i] will be storing the number of solutions 
        // for value i. We need n+1 rows as the table is 
        // constructed in bottom up manner using the base 
        // case (n = 0) 
        long[] table = new long[n+1]; 
  
        // Initialize all table values as 0 
        //Arrays.fill(table, 0);   //O(n) 
  
        // Base case (If given value is 0) 
        table[0] = 1; 
  
        // Pick all coins one by one and update the table[] 
        // values after the index greater than or equal to 
        // the value of the picked coin 
        for (int i=0; i<m; i++) 
            for (int j=S[i]; j<=n; j++) 
                table[j] += table[j-S[i]]; 
  
        return table[n]; 
    } 
	
	boolean isSubsetSum(int set[], int n, int sum) 
	{ 
		boolean[][] subset = new boolean[n+1][sum+1]; 
	   
	    // If sum is 0, then answer is true 
	    for (int i = 0; i <= n; i++) 
	      subset[i][0] = true; 
	   
	    // If sum is not 0 and set is empty, then answer is false 
	    for (int i = 1; i <= sum; i++) 
	      subset[0][i] = false; 
	   
	     for (int i = 1; i <= n; i++) //loop through elements
	     { 
	       for (int j = 1; j <= sum; j++) //loop through sum
	       { 
	         if(j<set[i-1]) //if sum is less than set value. Just take previous optimal value
	         subset[i][j] = subset[i-1][j]; 
	         if (j >= set[i-1]) 
	        	 //include-exclude principle
	        	 //either take previous optimal value or include the ele check for true
	        	 
	           subset[i][j] = subset[i-1][j] ||  
	                                 subset[i - 1][j-set[i-1]]; 
	       } 
	     } 
	     return subset[n][sum]; 
	}

	public static void main(String[] args) {
		SubsetSum subsetSum = new SubsetSum();
		//int set[] = {34, 4, 12, 2};
		int set[] = {1,2,3};
		int sum = 5;
		//System.out.println(subsetSum.recSubsetSum(set,0, sum));
		//System.out.println(subsetSum.dpSubsum(set, sum));
		subsetSum.countWays(set, set.length, sum);
	}
}
