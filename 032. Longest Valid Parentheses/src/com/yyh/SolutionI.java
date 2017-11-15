package com.yyh;

import java.util.ArrayDeque;
import java.util.Deque;

// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
public class SolutionI {
	// Time complexity: O(n^3)
	public int longestValidParentheses(String s) {
		int maxLen= 0;
		for (int i = 0; i < s.length(); i++){
			for (int j = i + 2; j <= s.length(); j += 2){
				if (isValid(s.substring(i, j))){
					maxLen = Math.max(maxLen, j - 1);
				}
			}
		}
		return maxLen;
	}
	
	private boolean isValid(String s){
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '('){
				stack.offer('(');
			} else if (!stack.isEmpty() && stack.peek() == '('){
				stack.poll();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
