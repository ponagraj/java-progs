package com.programs.backtracking;

public class AllCombAndPermPractise1 {

	public static void main(String[] args) {
		String str = "abc";
		//findAllComb(str, new StringBuilder(), 0);
		findAllPerm(str, 0);
	}
	
	private static void findAllPerm(String str, int start) {
		if(start == str.length() ) {
			System.out.println(str);
			return;
		}
		for(int i=start; i<str.length(); i++) {
			str = swap(str,start,i);
			findAllPerm(str, start+1);
			str = swap(str,start,i);
		}
	}
	private static void findAllComb(String str, StringBuilder sb, int start) {
		for(int i=start; i<str.length(); i++) {
			sb.append(str.charAt(i));
			System.out.println(sb.toString());
			findAllComb(str,sb,i+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	private static String swap(String str, int start, int end) {
		char[] array = str.toCharArray();
		char temp = array[start];
		array[start] = array[end];
		array[end] = temp;
		return String.valueOf(array);
	}
}
