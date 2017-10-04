package com.yyh;

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}
public class MaxPathSum {
	public int maxPathSum(TreeNode root) {
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
		if (root.left != null && root.right != null){
			max[0] = Math.max(max[0], left + right + root.key);
			return Math.max(left, right) + root.key;
		}
		return root.left == null? right + root.key : left + root.key;
	}
}
