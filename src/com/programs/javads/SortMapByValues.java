package com.programs.javads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Display Popular hash tags
 * @author VineelaNagu
 *
 */
public class SortMapByValues {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Abdul", 10);
		map.put("Modi", 20);
		map.put("Mahesh", 20);
		map.put("Munich", 20);
		map.put("Trump", 100);
		map.put("Biden", 200);
		
		//convert map to list
		/*List<Map.Entry<String, Integer>> list = new ArrayList<>();
		map.entrySet().forEach(entry -> {
			list.add(entry);
		});*/
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		//sort list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				if(o1.getValue() < o2.getValue()) {
					return 1; //descending order
				} else if(o1.getValue() > o2.getValue()) {
					return -1;
				} else {
					if(o1.getKey().compareTo(o2.getKey()) < 0) {
						return -1;
					} else if(o1.getKey().compareTo(o2.getKey()) > 0) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});
		
		//print list
		list.stream().forEach(System.out::println);
		
	}
} 
