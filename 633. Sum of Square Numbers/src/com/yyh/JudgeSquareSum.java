package com.yyh;
// Given a non-negative integer c, your task is to decide whether there're two 
// integers a and b such that a2 + b2 = c.
public class JudgeSquareSum {
	public boolean judgeSquareSum(int c) {
        int left = 0; 
        int right = (int) Math.sqrt(c);
        while (left <= right){
            int sum = left * left + right * right;
            if (sum == c){
                return true;
            } else if (sum < c){
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
