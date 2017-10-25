package com.yyh;
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
public class Solution {
	public boolean isPalindrome(String s) {
        if (s.length() <= 1){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            char chaL = s.charAt(left);
            char chaR = s.charAt(right);
            if (chaL < '0' ||(chaL > '9' && chaL < 'A') || (chaL > 'Z' && chaL < 'a') || (chaL > 'z')){
                left++;
                continue;
            }
            if (chaR < '0' ||(chaR > '9' && chaR < 'A') || (chaR > 'Z' && chaR < 'a') || (chaR > 'z')){
                right--;
                continue;
            }
            int numL = 0;
            int numR = 0;  
            if (chaL <= '9'){
                numL = chaL - '0';
            } else {
                numL = 10 + (chaL - 'a' >= 0? chaL - 'a' : chaL - 'A');
            }
            if (chaR <= '9'){
                numR = chaR - '0';
            } else {
                numR = 10 + (chaR - 'a' >= 0? chaR - 'a' : chaR - 'A');
            }
            if (numL == numR){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
