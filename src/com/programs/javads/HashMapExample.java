package com.programs.javads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<Integer,String> hashMap = new HashMap<Integer, String>();
		hashMap.put(10, "naga");
		hashMap.put(2, null); //value is null
		hashMap.put(null, "nullvalue"); //key is null
		hashMap.put(13, "raju");
		
		System.out.println("printing with key set");
		Set<Integer> allKeys = hashMap.keySet();
		Iterator<Integer> iterator = allKeys.iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println("key: " +key+" " +"value: " +hashMap.get(key));
			
		}
		
		System.out.println("printing with entry set");
		Iterator<Map.Entry<Integer, String>> entryIterator = hashMap.entrySet().iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<Integer, String> entry = entryIterator.next();
			System.out.println("key: " +entry.getKey()+" " +"value: " +entry.getValue());
		}
		
		//sorted map
		//just use treemap
		TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>();
		
		
		
	}
}
