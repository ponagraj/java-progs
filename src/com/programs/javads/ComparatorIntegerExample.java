package com.programs.javads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorIntegerExample {

	public static void main(String[] args) {
		List<Integer>nums = new ArrayList<>();
		nums.add(-2147483648);
		nums.add(2);
		nums.add(3);
		nums.add(1);
		
		Collections.sort(nums, new BigToSmallComparator<>());
		System.out.println(Arrays.toString(nums.toArray()));
		
	}
	
	public static class BigToSmallComparator<Integer> implements Comparator<Integer> {
		
		/**
		 * HOW COMPARE WORKS?
		 * The comparision works oppposite to that of the logic
		 * if MergeSort.compare([j-1],[j]) > 0 then the swap(j-1,j) happens.
		 * else the ele will be in their same place.
		 * So compare() has to return a +value if we want to swap else 0,-values    
		 */
		public int compare(Integer i1, Integer i2) {
			
			System.out.println(i1 +" " +i2);
			System.out.println((int)i2 == -2147483648);
			if((int)i1-(int)i2 < 0) { //if i1 is smaller than i2 then swap (return >0 vlaue)
				return 1;
			} else if((int)i1-(int)i2 > 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}

