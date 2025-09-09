package com.programs.search;

public class KMPAlgorithm {
	public static void main(String[] args) {
		
		String str = "AAXAAXAAC";
		String pat = "AAC";
		//String pat = "ABABCDCD";
		//String pat = "AAXAAC";
		/*String str = "ABXABCABX";
		String pat  = "ABC";*/
		KMPAlgorithm kmp = new KMPAlgorithm();
		kmp.kmpAlgorithm(str, pat);
	}
	
	public void kmpAlgorithm(String str, String pat) {
		if(str == null || str.length() == 0) {
			System.out.println("Empty String");
		} else if(pat == null || pat.length() == 0) {
			System.out.println("Empty Pattern");
		}
		
		int[] lps = constructLps(pat);
		for(int i=0; i<lps.length; i++) {
			System.out.print(lps[i] + " ");
		}
		
		int i = 0, j = 0;
		
		while(i < str.length()) {
			if(str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			//In general, I write these conditions in the beginning
			//but why should we write it after 'char' comparision??
			//bcoz i=str.len()-1 and j=pat.len()-1, after above
			//condition i = str.len() and j=pat.len()
			//and we will not enter while loop again as i<str.len() fails
			if(j == pat.length()) {
				System.out.println("Pattern Found between index1: " 
						+(i-pat.length()) +" and index2: " +i);
				j = lps[j-1];//this condition takes care of continuing next comparision
			} else if (i < str.length() && pat.charAt(j) != str.charAt(i)) { 
	            if (j != 0) //chars are not matching. lets start from lps[j-1] instead of beginning
	                j = lps[j - 1]; 
	            else
	                i = i + 1; 
	        }
		}
	}

	/**
	 * longest proper prefix which is also a suffix.
	 */
	private int[] constructLps(String pat) {
		int[] lps = new int[pat.length()];
		//len holds the lps value that is achieved so far.
		int len = 0;
		//set initial lps to 0 as there cant be proper prefix with one char.
		int j=1;
		lps[0] = 0;
		while(j < pat.length()) {
			if(pat.charAt(len) == pat.charAt(j)) {
				len++;
				lps[j] = len;
				j++;
			} else {//keep traversing back till you find matching char
				if(len != 0) {
					len = lps[len-1];
					//len--;
				} else {//no matching found. go ahead with next j
					lps[j] = len;
					j++;
				}
			}
		}
		return lps;
	}
}
