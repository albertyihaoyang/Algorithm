package com.yyh;
// Given an integer, return its base 7 string representation.
public class Solution {
	public String convertToBase7(int num) {
        if (num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean pos = true;
        if (num < 0){
            num = -num;
            pos = false;
        }
        while (num > 0){
            sb.append(num % 7 + "");
            num /= 7;
        }
        if (!pos) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
