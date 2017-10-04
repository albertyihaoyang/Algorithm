package com.yyh;
//Given a binary tree in which each node contains an integer number. Find the maximum possible 
// subpath sum(both the starting and ending node of the subpath should be on the same path from root 
// to one of the leaf nodes, and the subpath is allowed to contain only one node).

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class MaxPathSum {
	public int maxPathSum(TreeNode root){
		// Assumptions: root is not null
		int[] max = new int[] {Integer.MIN_VALUE};
		helper(root, max);
		return max[0];
	}
	
	private int helper(TreeNode root, int[] max){
		if (root == null){
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		int sin = Math.max(Math.max(left, right), 0) + root.key;
		max[0] = Math.max(max[0], sin);
		return sin;
	}
}
