package com.programs.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/discuss/825572/Java-Dynamic-Programming
 * @author VineelaNagu
 *
 */
public class MinJumpsToEnd {
	private static int minJumps;
	public static void main(String[] args) {
		
		int[] nums = {2,3,1,1,4};
		MinJumpsToEnd jg2 = new MinJumpsToEnd();
		System.out.println(jg2.jumpRec(nums));
		System.out.println("DP: " +jg2.minJumpsDP(nums));
		
		int[] nums2 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		MinJumpsToEnd jg3 = new MinJumpsToEnd();
		System.out.println(jg3.jumpRec(nums2));
		System.out.println("DP: " +jg3.minJumpsDP(nums2));
	}
	
	private int jumpRec(int[] nums) {
		minJumps = Integer.MAX_VALUE;
		minJumps(nums, 0, 0);
		return minJumps;
	}
	
	private void minJumps(int[] nums, int start, int jumps) {
		if(start >= nums.length-1) {//Bug: length should len-1 
			if(minJumps >= jumps) {
				minJumps = jumps;
			}
			return;
		}
		for(int i=1; i <= nums[start]; i++) {
			if(start + i <= nums.length) {
				minJumps(nums, start+i, jumps+1);
			}
		}
	}
	
	public int minJumpsDP(int[] nums) {
		int[] storage = new int[nums.length];
		
		Arrays.fill(storage, Integer.MAX_VALUE);
		storage[0] = 0;
		
		for(int i=0; i<nums.length; i++) {//for all the ele in nums
			for(int j=1; j<= nums[i]; j++) {//it can jump upto nums[i]
				if(i+j < nums.length && storage[i] != Integer.MAX_VALUE) {
					storage[i+j] = Math.min(storage[i+j], storage[i]+1);
				}
			}
		}
		return storage[nums.length-1];
	}
}
