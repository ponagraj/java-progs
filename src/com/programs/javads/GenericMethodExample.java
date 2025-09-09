package com.programs.javads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericMethodExample {
	public static void main(String[] args) {
		GenericMethodClass gmc = new GenericMethodClass();
		gmc.printData("String");
		gmc.printData(123);
		gmc.printData(new ArrayList<Integer>());
		//The Object can't be printed with this way
		gmc.printData(new DumbObj(1, "Naga"));
		
		System.out.println(gmc.createSetFromList(Arrays.asList("naga", "maanvi", "vineela")));
		System.out.println(gmc.createSetFromList(Arrays.asList(1,2,3)));
	}
	
	
	public static class GenericMethodClass {
		
		public <T> Set<T> createSetFromList(List<T> list) {
			Set<T> set = new HashSet<>();
			list.forEach(ele -> set.add(ele));
			return set;
		}
		public <T> void printData(T data) {
			System.out.println("Data: " +data);
		}
	}
	
	public static class DumbObj {
		int id;
		String name;
		
		public DumbObj(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}
