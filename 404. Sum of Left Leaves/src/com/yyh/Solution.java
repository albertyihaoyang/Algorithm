package com.yyh;
// Find the sum of all left leaves in a given binary tree.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        helper(root, sum);
        return sum[0];
    }
    
    private void helper(TreeNode root, int[] sum){
        if (root == null) return;
        if (root.left != null){
            if (root.left.left == null && root.left.right == null) sum[0] += root.left.val;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
