package com.yyh;
// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
public class Solution {
	public int addDigits(int num) {
		if (num == 0) return 0;
		return num % 9 == 0 ? 9 : num % 9;
	}
}
