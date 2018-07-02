package com.yyh;
// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//You may assume each number in the sequence is unique.


public class Solution {
	public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 2) return true;
        int low = Integer.MIN_VALUE, i = -1;
        for (int p: preorder){
            if (p < low) return false;
            while (i >= 0 && p > preorder[i]) low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}
