package com.yyh;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.
 */
public class Solution {
	public int calPoints(String[] ops) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (String op : ops){
			if (op.equals("C")){
				stack.pollLast();
			} else if (op.equals("D")){
				stack.offerLast(stack.peekLast() * 2);
			} else if (op.equals("+")){
				Integer cur = stack.pollLast();
				Integer newScore = cur + stack.peekLast();
				stack.offerLast(cur);
				stack.offerLast(newScore);
			} else {
				stack.offerLast(Integer.valueOf(op));
			}
		}
		int sum = 0;
		while (!stack.isEmpty()){
			sum += stack.pollLast();
		}
		return sum;
	}
}
