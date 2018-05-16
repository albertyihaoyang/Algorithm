package com.yyh;

/*
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. 
Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class Solution {
	public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0){
            return 0;
        }
        boolean[] arr = new boolean[128];
        for (char ch: J.toCharArray()){
            arr[ch] = true;
        }
        int res = 0;
        for (char ch: S.toCharArray()){
            if (arr[ch]){
                res++;
            }
        }
        return res;
    }
}
