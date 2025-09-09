package com.programs.dp;

class LIS {
    
    int globalLis = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
		LIS lis = new LIS();
		int[] nums = {1,3,6,7,9,4,10,5,6};
		System.out.println(lis.lengthOfLIS(nums));
	}
    
    public int lengthOfLIS(int[] nums) {
    	
        if(nums == null || nums.length == 0) {
            return 0;
        }

        for(int i=0; i<nums.length; i++) {
            lis(nums,i,0);
        }
        return globalLis+1;
    }
    
    public int lis(int nums[], int i, int localLis) {
        if(i >= nums.length-1) {
            if(localLis > globalLis) {
                globalLis = localLis;
            }
            return globalLis;
        }
        for(int j=i+1; j<nums.length; j++) {
            if(nums[i] < nums[j]) {
                lis(nums,j, localLis+1);
            }
        }
        if(globalLis < localLis) {
        	globalLis = localLis;
        }
        return globalLis;
    }
}