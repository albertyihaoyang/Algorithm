package com.yyh;
/*
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values 
 * and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int findTilt(TreeNode root) {
		int[] tilt = new int[1];
		helper(root, tilt);
		return tilt[0];
	}

	private int helper(TreeNode root, int[] tilt){
		if (root == null){
			return 0;
		}
		int left = helper(root.left, tilt);
		int right = helper(root.right, tilt);
		tilt[0] += Math.abs(left - right);
		return left + right + root.val;
	}
}
