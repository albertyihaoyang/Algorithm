package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 */
public class Solution {
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++){
            if (isSD(i)){
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean isSD(int i){
        int n = i;
        while (n != 0){
            if ((n % 10) == 0 || i % (n % 10) != 0){
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
