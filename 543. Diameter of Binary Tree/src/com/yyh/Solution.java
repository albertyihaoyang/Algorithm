package com.yyh;
// Given a binary tree, you need to compute the length of the diameter of the tree. 
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
// This path may or may not pass through the root.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null){
			return 0;
		}
		int[] res = new int[]{0};
		helper(root, res);
		return res[0] - 1;
	}
	
	private int helper(TreeNode root, int[] res){
		if (root == null){
			return 0;
		}
		int left = helper(root.left, res);
		int right = helper(root.right, res);
		res[0] = Math.max(res[0], 1 + left + right);
		return Math.max(left, right) + 1;
	}
}
