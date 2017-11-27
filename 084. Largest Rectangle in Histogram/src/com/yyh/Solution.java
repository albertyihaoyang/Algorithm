package com.yyh;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public int largestRectangleArea(int[] array) {
        int result = 0;
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i <= array.length; i++){
			int cur = i == array.length ? 0: array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= cur){
				int height = array[stack.pollFirst()];
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				result = Math.max(result, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return result;
    }
}
