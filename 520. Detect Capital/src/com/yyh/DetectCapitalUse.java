package com.yyh;
/*
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 	All letters in this word are capitals, like "USA".
 * 	All letters in this word are not capitals, like "leetcode".
 * 	Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapitalUse {
	public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if (arr.length <= 1){
            return true;
        }
        if (arr[0] >= 'A' & arr[0] <= 'Z'){
            if (arr[1] >= 'A' & arr[1] <= 'Z'){
                for (int i = 2; i < arr.length; i++){
                    if (arr[i] < 'A' || arr[i] > 'Z'){
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < arr.length; i++){
                    if (arr[i] < 'a' || arr[i] > 'z'){
                        return false;
                    }
                }
            }
        } else {
            for (int i = 1; i < arr.length; i++){
                if (arr[i] < 'a' || arr[i] > 'z'){
                        return false;
                }
            }
        }
        return true;
    }
}
