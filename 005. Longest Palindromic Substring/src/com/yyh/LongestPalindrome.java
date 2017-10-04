package com.yyh;

public class LongestPalindrome {

	public static void main(String[] args) {
		LongestPalindrome my = new LongestPalindrome();
		System.out.println(my.longestPalindrome("ccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"
				+ "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
	}

	public String longestPalindrome(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++){
        	for (int j = s.length() - 1; j >= i; j--){
        		if (isPS(s, i, j)){
        			if (j - i > max - min){
        				max = j;
        				min = i;
        			}
        			if (max - min > s.length() - i) {
        				return s.substring(min, max + 1);
        			}
        		}
        	}
        }
        return s.substring(min, max + 1);
    }

	public boolean isPS(String s, int i, int j){
		while (i < j){
			if (s.charAt(i++) != s.charAt(j--)){
				return false;
			}
		}
		return true;
	}
}
