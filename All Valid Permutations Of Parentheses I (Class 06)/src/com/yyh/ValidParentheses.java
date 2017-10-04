package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 * Assumptions
 * 	N >= 0
 * Examples
 * 	N = 1, all valid permutations are ["()"]
 * 	N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * 	N = 0, all valid permutations are [""]
 */

public class ValidParentheses {
	public static void main(String[] args){
		System.out.println(validParentheses(3));
	}
	
	public static List<String> validParentheses(int n) {
	    if (n == 0){
	    	List<String> empty= new ArrayList<String>();
	    	empty.add("");
	    	return empty;
	    }
	    String cur = "";
	    List<String> result = new ArrayList<String>();
	    validParentheses(n, 0, 0, cur, result);
	    return result;
	  }
	
	public static void validParentheses(int n, int left, int right, String cur, List<String> result){
		if (left + right == n * 2){
			result.add(cur);
			return;
		} else if (left == right) {
			cur = cur + "(";
			validParentheses(n, left + 1, right, cur, result);
		} else if (left == n){
			cur = cur + ")";
			validParentheses(n, left, right + 1, cur, result);
		} else {
			cur = cur + "(";
			validParentheses(n, left + 1, right, cur, result);
			cur = cur.substring(0, cur.length() - 1) + ")";
			validParentheses(n, left, right + 1, cur, result);
			cur = cur.substring(0, cur.length() - 1);			
		}
	}
	
	
}
