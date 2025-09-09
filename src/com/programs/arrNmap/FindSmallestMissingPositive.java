package com.programs.arrNmap;
/**
 * LEET CODE PROBLEM
 * @author VineelaNagu
 *
 */
class FindSmallestMissingPositive {
	
	public static void main(String[] args) {
		int[] nums = {0,2,2,1,1};
		firstMissingPositive(nums);
	}
    
	 public static int firstMissingPositive(int[] nums) {
	        long small = Long.MAX_VALUE;
	        long big = Long.MIN_VALUE;
	        long noOfPositives = 0;
	        long positiveSum = 0;
	        for(int i=0; i<nums.length; i++) {
	            if(nums[i] > 0) {
	                noOfPositives++;
	                positiveSum += nums[i];
	                
	                if(small > nums[i]) {
	                    small = nums[i];
	                }
	                if(big < nums[i]) {
	                    big = nums[i];
	                }
	            }
	        }
	        
	        long calculatedSum = 0; long value = small;
	        for(long i=small; i<=big; i++) {
	            calculatedSum += i;
	        }
	        if(small > 1) {
	            return 1;
	        } else if(calculatedSum - positiveSum == 0) {
	            return (int)big+1;
	        } else {
	            return (int)small+1;
	        }
	    }
}