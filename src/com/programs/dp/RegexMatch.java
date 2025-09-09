package com.programs.dp;

public class RegexMatch {

	private Boolean isMatch = null;
	
	public static void main(String[] args) {
		RegexMatch regexMatch = new RegexMatch();
		regexMatch.isMatch("mississippi","mis*is*p*.");
		System.out.println(regexMatch.isMatch != null ? regexMatch.isMatch : false);
	}

    
	public boolean isMatch(String s, String p) {
        regMatch(s,p,0,0);
        return isMatch != null ? isMatch : false;
    }
    
    public boolean regMatch(String s, String p, int i, int j) {
        if(s.length() == i) {
        	if(p.length() == j) {
                isMatch = true;
        	}
            return true;
        } else if (p.length() == j) {
            return false;
        } else if(isMatch != null) {
            return isMatch ? true : false;
        } else {
            if(s.charAt(i) == p.charAt(j)) {
                return regMatch(s,p, i+1,j+1);
            } else if(p.charAt(j) == '.') {
                return regMatch(s,p,i+1,j+1);
            } else if(p.charAt(j) == '*') {
                if(isMatch != null && !isMatch) {
                    return false;
                }
                regMatch(s,p,i,j+1);
                for(int k=1; k<=s.length()-i; k++) {
                    if(p.charAt(j-1) == '.') {
                        regMatch(s,p,i+k,j+1);
                    } else {
                        if(k == 1 && s.charAt(i+k-1) == p.charAt(j-1) && (isMatch == null || !isMatch)) {
                            regMatch(s,p,i+k,j+1);
                        }
                       else if(k > 1 && s.charAt(i+k-2) == s.charAt(i+k-1) && s.charAt(i+k-1) == p.charAt(j-1) && (isMatch == null || !isMatch)) {
                        regMatch(s,p,i+k,j+1);
                    }
                    }
                }
            } else {
                regMatch(s,p,i,j+1);
                return false;
            }
        }
        return false;      
    }
}
