package com.yyh;

/*
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.
 */

public class MaxPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	public int helper(TreeNode root){
		if (root == null){
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		left = left > 0 ? left : 0;
		right = right > 0 ? right : 0;
		max = Math.max(max, root.val + left + right);
		return root.val + Math.max(left, right);
	}
}