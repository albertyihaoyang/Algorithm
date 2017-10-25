package com.yyh;
/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		System.out.println(my.isStrobogrammatic("69"));
	}
	
	public boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;
        while (l < r){
            char lc = num.charAt(l++);
            char rc = num.charAt(r--);
            if ((lc == '8' && rc == '8') || (lc == '1' && rc == '1') || (lc == '6' && rc == '9')
                || (lc == '9' && rc == '6') || (lc == '0' && rc == '0')) continue;
            return false;
        }
        if (l > r) return true;
        if (l == r && (num.charAt(l) == '1' || num.charAt(l) == '8' || num.charAt(l) == '0')) return true;
        return false;
    }
}
