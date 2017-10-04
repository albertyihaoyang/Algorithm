package com.yyh;
// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
public class GetSum {
	public int getSum(int a, int b) {
        return b == 0? a : getSum(a ^ b, (a & b)<<1); //be careful about the terminating condition;
    }
}
