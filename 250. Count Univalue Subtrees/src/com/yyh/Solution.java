package com.yyh;
/*
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	int count;

	public int countUnivalSubtrees(TreeNode root) {
		count = 0;
		helper(root);
		return count;
	}

	private boolean helper(TreeNode root){
		if (root == null) return true;
		boolean right = helper(root.right);
		boolean left = helper(root.left);
		if (root.left == null && root.right == null){
			count++;
			return true;
		} else if (root.right == null){
			if (root.val == root.left.val && left){
				count++;
				return true;
			}
			return false;
		} else if (root.left == null){

			if (root.val == root.right.val && right){
				count++;
				return true;
			}
			return false;
		} else {
			if (root.val == root.left.val && left && root.val == root.right.val && right){
				count++;
				return true;
			}
			return false;
		}
	}
}
