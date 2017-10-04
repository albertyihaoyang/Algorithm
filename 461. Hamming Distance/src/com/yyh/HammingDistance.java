package com.yyh;
/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
        int dif = x ^ y;
        int result = 0;
        while (dif > 0) {
            if ((dif & 1) > 0) {
                result++;
            }
            dif >>= 1;
        }
        return result;
    }
}
