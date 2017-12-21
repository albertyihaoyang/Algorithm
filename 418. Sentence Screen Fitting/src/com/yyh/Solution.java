package com.yyh;
/*
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
 */
public class Solution {
	public int wordsTyping(String[] sen, int rows, int cols) {
        int res = 0;
        int ind = 0;
        for (int i = 0; i < rows; i++){
            int tempC = cols;
            if (sen[ind].length() > cols){
                return 0;
            }
            tempC -= sen[ind++].length();
            if (ind == sen.length){
                res++;
                ind = 0;
            }
            while (tempC >= sen[ind].length() + 1){
                tempC -= (sen[ind].length() + 1);
                ind++;
                if (ind == sen.length){
                    res++;
                    ind = 0;
                }
            }
        }
        return res;
    }
}
