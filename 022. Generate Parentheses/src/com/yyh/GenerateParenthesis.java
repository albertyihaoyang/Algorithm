package com.yyh;
import java.util.*;
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class GenerateParenthesis {

	public static void main(String[] args) {
		GenerateParenthesis my = new GenerateParenthesis();
		System.out.println(my.generateParenthesis(3).toString());

	}

	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0){
            return result;
        }
        char[] curR = new char[n * 2];
        helper(n, 0, 0, curR, result);
        return result;
    }
    
    private void helper(int n, int left, int right, char[] curR, List<String> result){
        if (left == right && left == n){
            result.add(new String(curR, 0, curR.length));
        } else if (left == right){
            curR[left + right] = '(';
            helper(n, left + 1, right, curR, result);
        } else if (left == n){
            curR[left + right] = ')';
            helper(n, left, right + 1, curR, result);
        } else {
            curR[left + right] = '(';
            helper(n, left + 1, right, curR, result);
            curR[left + right] = ')';
            helper(n, left, right + 1, curR, result);
        }
    }
}
