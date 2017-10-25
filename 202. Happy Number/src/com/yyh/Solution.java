package com.yyh;

import java.util.HashSet;
import java.util.Set;

/*
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, 
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
 * or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
 */
public class Solution {
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            if (set.contains(n)) return false;
            set.add(n);
            n = helper(n);
            if (n == 1) return true;
        }
    }
    
    private int helper(int i){
        int res = 0;
        while (i > 0){
            int cur = i % 10;
            res += cur * cur;
            i /= 10;
        }
        return res;
    }
}
