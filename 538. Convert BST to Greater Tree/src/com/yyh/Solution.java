package com.yyh;
// Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the 
// original BST is changed to the original key plus sum of all keys greater than the original key in BST.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode convertBST(TreeNode root) {
		if (root == null){
			return root;
		}
		int[] cum = new int[1];
		helper(root, cum);
		return root;
	}
	
	public void helper(TreeNode root, int[] cum){
		if (root.right != null){
			helper(root.right, cum);
		}
		root.val += cum[0];
		cum[0] = root.val;
		if (root.left != null){
			helper(root.left, cum);
		}
	}
}
