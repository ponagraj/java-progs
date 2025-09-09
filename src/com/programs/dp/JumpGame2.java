package com.programs.dp;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {
	public static int minJumps;
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		//int[] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		JumpGame2 jg2 = new JumpGame2();
		System.out.println(jg2.jumpRec(nums));
	}
	
	/*public int jump(int[] nums) {
		int[] store = new int[nums.length+1];
		store[0] = 0;
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<i; j++) {
				
			}
		}
	}*/
	public int jumpRec(int[] nums) {
		minJumps = Integer.MAX_VALUE;
		minJumps(nums,0,0);
		return minJumps;
    }
	
	public void minJumps(int[] nums, int jumps, int i) {
		if(i >= nums.length-1) {
			if(minJumps > jumps) {
				 minJumps = jumps;
			}
			return;
		}
		for(int len=1; len<=nums[i] && i+len<= nums.length-1; len++) {
			minJumps(nums,jumps+1,i+len);
		}
	}
}
