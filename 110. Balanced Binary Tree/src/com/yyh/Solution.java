package com.yyh;
/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
 * of the two subtrees of every node never differ by more than 1.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null){
			return true;
		}
		int left = height(root.left);
		int right = height(root.right);
		if (left == -1 || right == -1){
			return false;
		}
		return (Math.abs(left - right) <= 1)? true : false;
	}
	
	private int height(TreeNode root){
		if (root == null){
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		if (left == -1 || right == -1){
			return -1;
		}
		return (Math.abs(left - right) <= 1)? Math.max(left, right) + 1 : -1;
	}
}
