package com.yyh;

/*
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 */
public class Solution {
	public void reverseWords(char[] str) {
        int len = str.length;
        rotate(str, 0, len - 1);
        int start = 0;
        for (int i = 0; i < len; i++){
            if (str[i] != ' ' && (i == len - 1 || str[i + 1] == ' ')){
                rotate(str, start, i);
                start = i + 2;
            }
        }
    }
    
    private void swap(char[] str, int a, int b){
        char tmp = str[a];
        str[a] = str[b];
        str[b] = tmp;
    }
    
    private void rotate(char[] str, int a, int b){
        while (a < b){
            swap(str, a++, b--);
        }
    }
}
