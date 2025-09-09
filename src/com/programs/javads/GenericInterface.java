package com.programs.javads;

import java.util.List;
import java.util.Set;

public interface GenericInterface<T1,T2, T3> {
	
	T1 method1(T1 a);
	
	T2 method2(T2 b);
	
	List<T1> method3(Set<T2> c);
	
	T3 method3(T2 d);
}
