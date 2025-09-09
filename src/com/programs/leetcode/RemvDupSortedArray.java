package com.programs.leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class RemvDupSortedArray {
	/**
	    So, in-place means with out extra memory (in large quantities).
	    Like no duplicate array, list, map, set etc.
	 **/
	public int removeDuplicatesOld(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		} else {
			int length = 1;
			int presentEle = nums[0];
			for(int i=1; i<nums.length; i++) {
				if(presentEle != nums[i]) {
					presentEle = nums[i];
					nums[length] = presentEle;
					length++;
				}
			}
			return length;

		}
	}

	public int removeDuplicates(int[] nums) {
		if(nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		SortedSet<Integer> sortedSet =  new TreeSet<>();
		for(int i=0; i<nums.length; i++) {
			sortedSet.add(nums[i]);
		}
		int indx = 0;
		for(Integer ele: sortedSet) {
			nums[indx++] = ele;
		}
		return sortedSet.size();
	}
}
