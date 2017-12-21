package com.yyh;
/*
 * Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		TreeNode T1 = new TreeNode(1);
		TreeNode T2 = new TreeNode(3);
		TreeNode T3 = new TreeNode(2);
		TreeNode T4 = new TreeNode(4);
		TreeNode T5 = new TreeNode(5);
		T1.right = T2;
		T2.left = T3;
		T2.right = T4;
		T4.right = T5;
		System.out.println(my.longestConsecutive(T1));
	}
	
	int max;

	public int longestConsecutive(TreeNode root) {
		max = 0;
		if (root == null){
			return 0;
		}
		helper(root);
		return max;
	}

	private int helper(TreeNode root){
		if (root == null){
			return 0;
		}
		int cur = 1;
		int left = helper(root.left);
		int right = helper(root.right);
		if (root.left != null && root.left.val == root.val + 1){
			cur = Math.max(cur, left + 1);
		}
		if (root.right != null && root.right.val == root.val + 1){
			cur = Math.max(cur, right + 1);
		}
		max = Math.max(cur, max);
		return cur;
	}
}