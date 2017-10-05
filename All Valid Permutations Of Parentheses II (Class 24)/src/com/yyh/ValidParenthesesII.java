package com.yyh;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidParenthesesII {
	private static final char[] PS = new char[] {'(', ')', '[', ']', '{', '}'};
	
	public List<String> validParentheses(int l, int m, int n) {
		// Assumptions: l,m,n>=0
		int[] remain = new int[]{l, l, m, m, n, n};
		int targetLen = 2 * l + 2 * m + 2 * n;
		StringBuilder cur = new StringBuilder();
		Deque<Character> stack = new LinkedList<Character> ();
		List<String> result = new ArrayList<String>();
		helper(cur, stack, remain, targetLen, result);
		return result;
	}
	
	private void helper(StringBuilder cur, Deque<Character> stack, int[] remain, int targetLen, List<String> result){
		if (cur.length() == targetLen){
			result.add(cur.toString());
			return;
		}
		for (int i = 0; i < remain.length; i++){
			if (i % 2 == 0){
				if (remain[i] > 0){
					cur.append(PS[i]);
					stack.offerFirst(PS[i]);
					remain[i]--;
					helper(cur, stack, remain, targetLen, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.pollFirst();
					remain[i]++;
				}
			} else {
				if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]){
					cur.append(PS[i]);
					stack.pollFirst();
					remain[i]--;
					helper(cur, stack,remain, targetLen, result);
					cur.deleteCharAt(cur.length() - 1);
					stack.offerFirst(PS[i - 1]);
					remain[i]++;
				}
			}
		}
	}
}
