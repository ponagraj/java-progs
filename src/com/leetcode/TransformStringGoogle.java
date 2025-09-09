package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransformStringGoogle {

	
	public static void main(String[] args) {
		System.out.println("ab,cc " +isIsomorphicUsingMap("ab", "cc"));
		System.out.println("bca.cdb " +isIsomorphicUsingMap("bca","cdb"));
		System.out.println("bca,cdb " +convertible("bca","cdb"));
		System.out.println("acb,bdc " +convertible("acb","bdc"));
		System.out.println("ab,cc " +convertible("ab","cc"));
		System.out.println("abcda,dced " +convertible("abca", "dced"));
		System.out.println("ab,ba " +convertible("ab", "ba"));
		System.out.println(convertible("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));
		System.out.println("aa,cd " +convertible("aa", "cd"));
		System.out.println("ab, aa " +convertible("ab", "aa"));
		System.out.println(convertible("abcdefghijklmnopqrstuvwxyz", "bbcdefghijklmnopqrstuvwxyz"));
	}
	
	private static boolean convertible(String a, String b){
	    int n1 = a.length();
	    int n2 = b.length();
	    if(n1 != n2)
	        return false;
	    Map<Character, Character> map = new HashMap();
	    Set<Character> valuesSet = new HashSet();
	    for(int i = 0; i < n1; i++){
	        char cha = a.charAt(i);
	        char chb = b.charAt(i);
	        if(!map.containsKey(cha)){
	            map.put(cha, chb);
	            valuesSet.add(chb);
	        }
	        else{
	            if(map.get(cha) != chb)
	                return false;
	        }
	    }
	    return map.size() == 26 && valuesSet.size() == 26 ? false : true;
	}
	
	public static boolean isIsomorphicUsingMap(String s, String t) {
        //Solving using map
        //key is s-char, vlaue is t-char
        Map<Character, Character> map = new HashMap<>();
        boolean isIso = true;
        for(int i=0; i<s.length(); i++) {
            //is the character present in the map?
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) == t.charAt(i)) {
                    continue;
                } else {
                    isIso = false;
                    break;
                }
            } else if(map.containsValue(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return isIso;
    }
}
