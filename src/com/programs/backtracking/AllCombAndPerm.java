package com.programs.backtracking;

/**
 * Rule of Thumb
 * 1. Solving involves backtracking
 * 2. combination needs add-> call -> delete
 * 3. permutation needs swap -> call -> swap_back
 * @author VineelaNagu
 *
 */
public class AllCombAndPerm {

	public static void main(String[] args) {
		String str = "abc";
		findAllCombAndPerm(str);	
	}
	
	
	private static void findAllCombAndPerm(String str) {
		if(str == null || str.isEmpty()) {
			return;
		}
		else 
			//findAllComb(str, new StringBuilder(), 0);
			findAllPerm(str, 0);
	}
	
	/**
	 * find all combinations starting with 'a', then 'b', then 'c'
	 * You don't have to think about the value, recursion will take care :P
	 * @param str
	 * @param sb
	 * @param startIndex
	 */
	private static void findAllComb(String str, StringBuilder sb, int startIndex) {
		for(int i=startIndex; i<str.length(); i++) {
			sb.append(str.charAt(i));
			System.out.println("value: " +sb.toString());
			findAllComb(str,sb, i+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	/**
	 * 				abc (i,j)
	 * 		abc(i,j) bac(i,j+1) cba(i,j+2)
	 * @param str
	 * @param start
	 */
	private static void findAllPerm(String str, int start) {
		if(start == str.length()) {
			System.out.println(str);
			return;
		}
		for(int i=start; i<str.length(); i++) {
			str = swap(str,start, i);
			findAllPerm(str,start+1);
			str = swap(str,start,i);
		}
	}
	
	private static String swap(String str, int start, int end) {
		char[] charArray = str.toCharArray();
		char temp = charArray[start];
		charArray[start] = charArray[end];
		charArray[end] = temp;
		str = String.valueOf(charArray);
		return str;
	}
}
