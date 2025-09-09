package com.programs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LEET CODE PROBLEM
 * @author VineelaNagu
 *
 */
class CombinationSum2 {
	
	public static void main(String[] args) {
		CombinationSum2 sum2 = new CombinationSum2();
		int[] candidates = {10,1,2,7,6,1,5};
		Arrays.sort(candidates);
		List<List<Integer>> numsList = sum2.combinationSum2(candidates, 8);
		System.err.println(numsList.toString());
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> nums = new ArrayList<Integer>();
        List<List<Integer>> numsList = new ArrayList<>();
        
        backtrack(candidates, target, nums, numsList, 0);
        return numsList;
    }
    

    public void backtrack(int[] candidates, int target, List<Integer> nums, List<List<Integer>> numsList, int startIndex) {
        if(target < 0) {
            return;
        } else if(target == 0) {
        	System.out.println(nums.toString());
            numsList.add(new ArrayList<>(nums));
        } else {
            for(int i=startIndex; i<candidates.length; i++) {
            	System.out.println(startIndex + " " +i);
            	if(i > startIndex && candidates[i] == candidates[i-1]) {
            		System.out.println("skipping: "+nums.toString());
            		continue;
            	}
                nums.add(candidates[i]);
                backtrack(candidates, target-candidates[i], nums, numsList, i+1);
                nums.remove(nums.size()-1);
            }
        }
    }
}