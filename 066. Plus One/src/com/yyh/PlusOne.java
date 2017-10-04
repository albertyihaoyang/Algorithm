package com.yyh;
import java.util.*;
/*
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOne my = new PlusOne();
		System.out.println(Arrays.toString(my.plusOne(new int[]{9, 9, 9})));
	}

	public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int next = 1;
        for (int i = digits.length - 1; i >= 0; i--){
        	int cur = digits[i] + next;
        	if (cur > 9){
        		result.add(cur - 10);
        		next = 1;
        	} else {
        		result.add(cur);
        		next = 0;
        	}
        }
        if (next == 1){
        	result.add(1);
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < resultArr.length; i++){
        	resultArr[i] = result.get(result.size() - 1 - i);
        }
        return resultArr;
    }
}
