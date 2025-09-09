package com.leetcode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRUCache {
	public static void main(String[] args) {
		LinkedHashSet<Integer> lhashSet = new LinkedHashSet<>();
		lhashSet.add(1);
		lhashSet.add(2);
		lhashSet.add(3);
		lhashSet.forEach(ele -> System.out.print(ele +" "));
		//lhashSet.remove(2);
		lhashSet.add(2);
		lhashSet.forEach(ele -> System.out.print(ele +" "));
		
	}
}
