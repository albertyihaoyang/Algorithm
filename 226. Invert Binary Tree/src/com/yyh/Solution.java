package com.yyh;
// Invert Binary Tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)){
			return root;
		}
		TreeNode newLeft = invertTree(root.right);
		TreeNode newRight = invertTree(root.left);
		root.left = newLeft;
		root.right = newRight;
		return root;
	}
}
