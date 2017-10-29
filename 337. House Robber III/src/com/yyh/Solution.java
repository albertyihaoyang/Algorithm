package com.yyh;
/*
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int rob(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }
    
    private int[] helper(TreeNode root, int[] max){
        if (root == null){
            return new int[]{0, 0};
        }
        int[] left = helper(root.left, max);
        int[] right = helper(root.right, max);
        int[] cur = new int[2];
        cur[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        cur[1] = root.val + left[0] + right[0];
        max[0] = Math.max(max[0], Math.max(cur[0], cur[1]));
        return cur;
    }
}
