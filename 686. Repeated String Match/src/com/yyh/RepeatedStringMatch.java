package com.yyh;
/*
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1.
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
 * and B is not a substring of A repeated two times ("abcdabcd").
 */
public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		if (A.length() == 0 || B.length() == 0){
			return -1;
		}
		return 0;
	}
}