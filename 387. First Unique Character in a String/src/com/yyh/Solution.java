package com.yyh;
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
public class Solution {
	public int firstUniqChar(String s) {
        if (s.length() == 0){
            return -1;
        }
        int res = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++){
            arr[i] = -1;
        }
        for (int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - 'a';
            if (arr[cur] == -1){
                arr[cur] = i;
            } else if (arr[cur] >= 0){
                arr[cur] = -2;
            }
        }
        for (int i = 0; i < 26; i++){
            if (arr[i] >= 0){
                res = Math.min(res, arr[i]);
            }
        }
        return res == s.length() ? -1 : res;
    }
}
