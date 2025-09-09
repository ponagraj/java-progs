package com.programs.javads;

import java.math.BigDecimal;

public class GenericClassExample {
	public static void main(String[] args) {
		MyGenericClass<String> genClass = new MyGenericClass<String>("Naga");
		System.out.println("Value: " +genClass.getData());
		
		MyGenericClass<BigDecimal> genClass2 = new MyGenericClass<>(new BigDecimal(1111));
		System.out.println("Value: " +genClass2.getData());
		//Compilation error because the data type is fixed in prior
		//genClass2.setData("sttring");
	}
	
	public static class MyGenericClass<T> {
		
		private T data;
		
		public MyGenericClass(T data) {
			this.data = data;
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
	}
	
}
