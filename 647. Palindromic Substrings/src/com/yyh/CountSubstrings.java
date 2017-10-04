package com.yyh;
/*
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different 
 * substrings even they consist of same characters.
 */
public class CountSubstrings {

	public static void main(String[] args) {
		CountSubstrings my = new CountSubstrings();
		System.out.println(my.countSubstrings("aaa"));
	}

	public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
        	for (int j = i; j < s.length(); j++){
        		if (isPS(s, i, j)){
        			count++;
        		}
        	}
        }
        return count;
    }
	
	public boolean isPS(String s, int a, int b){
		if (a == b){
			return true;
		}
		while (a < b){
			if (s.charAt(a++) != s.charAt(b--)){
				return false;
			}
		}
		return true;
	}
}
