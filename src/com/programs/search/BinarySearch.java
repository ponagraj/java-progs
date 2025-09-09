package com.programs.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {1,3,5,7,9};
		System.out.println("Index: " +binarySearch(nums, 5, 0, nums.length-1));
		System.out.println("Index: " +binarySearch(nums, 8, 0, nums.length-1));
		System.out.println("Index: " +binarySearch(nums, 3, 0, nums.length-1));
		System.out.println("Index: " +binarySearch(nums, 4, 0, nums.length-1));
	}
	public static int binarySearch(int[] nums, int target, int low, int high) {
        int index = -1;
        if(low <= high) {
            int mid = (low+high)/2;
            if(target == nums[mid]) {
                index = mid;
            } else if(target < nums[mid]) {
                index = binarySearch(nums, target, low, mid-1);
            } else {
                index = binarySearch(nums,target,mid+1,high);
            }
        }
        return index;
    }
}
