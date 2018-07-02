package com.yyh;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 */
public class Solution {
	public int calculate(String s) {
        Deque<int[]> operator = new ArrayDeque<>();
        Deque<Integer> operant = new ArrayDeque<>();
        int lvl = 0;
        int i = -1;
        while (++i < s.length()){
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            else if (ch == '(') lvl++;
            else if (ch == ')') lvl--;
            else if (ch == '+'){
                while (!operator.isEmpty() && operator.peekFirst()[1] >= lvl){
                    int b = operant.pollFirst();
                    int a = operant.pollFirst();
                    operant.offerFirst(a + b * operator.pollFirst()[0]);
                }
                operator.offerFirst(new int[]{1, lvl});
            }
            else if (ch == '-'){
                while (!operator.isEmpty() && operator.peekFirst()[1] >= lvl){
                    int b = operant.pollFirst();
                    int a = operant.pollFirst();
                    operant.offerFirst(a + b * operator.pollFirst()[0]);
                }
                operator.offerFirst(new int[]{-1, lvl});
            }
            else {
                int cur = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    cur = cur * 10 + s.charAt(i) - '0';
                    i++;
                }
                operant.offerFirst(cur);
                i--;
            }
        }
        while (!operator.isEmpty()){
            int b = operant.pollFirst();
            int a = operant.pollFirst();
            operant.offerFirst(a + b * operator.pollFirst()[0]);
        }
        return operant.pollFirst();
    }
}
