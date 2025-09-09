package com.programs.javads;

import java.util.List;
import java.util.Set;

import com.programs.javads.GenericInterfaceExmaple.MyObj;

public class GenericInterfaceExmaple implements GenericInterface<String, Integer, MyObj>{
	
	public static class MyObj {
		int id;
		int name;
	}

	@Override
	public String method1(String a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer method2(Integer b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> method3(Set<Integer> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyObj method3(Integer d) {
		// TODO Auto-generated method stub
		return null;
	}
}