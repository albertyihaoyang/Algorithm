package com.yyh;
/*
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution {
	public String multiply(String num1, String num2) {
        String[] store = new String[num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++){
                sb.append('0');
            }
            int inc = 0;
            for (int j = num1.length() - 1; j >= 0; j--){
                int res = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + inc;
                sb.append((char)(res % 10 + '0'));
                inc = res / 10;
            }
            if (inc > 0){
                sb.append((char)(inc + '0'));
            }
            store[i] = sb.toString();
        }
        int visited = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int inc = 0;
        while (visited < store.length){
            int cur = inc;
            for (String s : store){
                if (index > s.length()) continue;
                else if (index == s.length()) visited++;
                else {
                    cur += s.charAt(index) - '0';
                }
            }
            sb.append((char)(cur % 10 + '0'));
            inc = cur / 10;
            index++;
        }
        if (inc > 0){
            sb.append((char)(inc + '0'));
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0'){
        	sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
