/*package com.leetcode;

import java.util.Arrays;

public class MaximumSubarray {
	
		public static void main(String[] args) {
			int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
			MaximumSubarray maxSub = new MaximumSubarray();
			System.out.println("Max Subsum: " +maxSub.maxSubArray(nums));
		}
	    public int maxSubArray(int[] nums) {
	        return getMaxSubArraySum(nums);
	    }
	    
	    *//**
	        what is this program doing??
	        I DONT KNOW :( :( :( :(
	        iT APPEARS TO BE A BIHEARTED SOLUTION :( :( :(
	    **//*
	    private int getMaxSubArraySum(int[] nums) {
	        int[] dp = new int[nums.length];
	        for(int i=0; i<dp.length; i++) {
	        	dp[i] = nums[i];
	        }
	        
	        for(int i=1; i<nums.length; i++) {
	        	dp[i] = Math.max(dp[i],nums[i] + dp[i-1]);
	        	System.out.println(Arrays.toString(dp));
	        }
	        int max = Integer.MIN_VALUE;
	    }
	}
*/