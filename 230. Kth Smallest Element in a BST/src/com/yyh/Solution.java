package com.yyh;
// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int kthSmallest(TreeNode root, int k) {
		int cur = count(root.left);
		if (k <= cur){
			return kthSmallest(root.left, k);
		} else if (k > cur + 1){
			return kthSmallest(root.right, k - cur - 1);
		}
		return root.val;
	}

	private int count(TreeNode root){
		if (root == null){
			return 0;
		}
		return 1 + count(root.left) + count(root.right);
	}
}
