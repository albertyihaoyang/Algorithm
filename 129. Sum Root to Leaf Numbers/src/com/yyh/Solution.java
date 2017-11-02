package com.yyh;
/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] total = new int[1];
        helper(root, total);
        return total[0];
    }
    
    public int[] helper(TreeNode root, int[] total){
        if (root == null){
            return new int[0];
        }
        int[] left = helper(root.left, total);
        int[] right = helper(root.right, total);
        if (left.length == 0 && right.length == 0){
            total[0] += root.val;
            return new int[]{1};
        }
        int[] cur = new int[left.length + right.length];
        for (int i = 0; i < left.length; i++){
            cur[i] = left[i] * 10;
            total[0] += cur[i] * root.val;
        }
        for (int i = 0; i < right.length; i++){
            cur[i + left.length] = right[i] * 10;
            total[0] += cur[i + left.length] * root.val;
        }
        return cur;
    }
}
