package com.programs.leetcode;

class MoveZeroes {
	
	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		int[] nums = {0,1,0,3,12};
		mz.moveZeroes(nums);
	}
    public void moveZeroes(int[] nums) {
        int zIndex = 0;
        
        for(int nzIndex =0; nzIndex < nums.length; nzIndex++) {
             if(zIndex != 0) {
                zIndex++;
            }
            if(nums[nzIndex] == 0) {
                continue;
            }
            if(nums[nzIndex] != 0 && zIndex < nzIndex) {
                swap(nums, zIndex, nzIndex);
            }         
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    
    /** My general style of writing the prog
    is using a while-loop and inside that using 
    2 while-loops. Vey difficult to debug code
    **/
}