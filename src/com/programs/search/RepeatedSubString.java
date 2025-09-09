package com.programs.search;

class RepeatedSubString {
    
    private int maxLps = 0;
    
    public static void main(String args[]) {
    	RepeatedSubString subStr = new RepeatedSubString();
    	String str = "ababac";
    	System.out.println(subStr.repeatedSubstringPattern(str));
    }
    public boolean repeatedSubstringPattern(String s) {
        maxLps = 0;
        
        if(s == null || s.length() == 0) {
            return true;
        }
        int[] lps = prepareLps(s);
      
        if(maxLps == 0) {//all chars are unique
            return false;
        } else if(maxLps == 1) {//check if all chars are same.
            for(int i=1; i<s.length(); i++) {
                if(s.charAt(i-1) != s.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else if((s.length() % (s.length()-maxLps)) == 0) {//a%(a-b)=> 'a-b' is the substring not just 'b'
            return true;
        } else {
            return false;
        }
    }
    
    int[] prepareLps(String pat) {
        int[] lps = new int[pat.length()];
        
        int j = 1, len = 0;
        lps[0] = 0;
        
        while(j < pat.length()) {
            if(pat.charAt(j) == pat.charAt(len)) {
                len++;
                lps[j] = len;
                System.out.print(lps[j] + " ");
                j++;
                
                if(maxLps < len) {
                    maxLps = len;
                }
            } else {
                if(len != 0) {
                    len = lps[len-1];
                } else {
                    lps[j] = len;
                    System.out.print(lps[j] + " ");
                    j++;
                }
            }
        }
        return lps;
    }
}
