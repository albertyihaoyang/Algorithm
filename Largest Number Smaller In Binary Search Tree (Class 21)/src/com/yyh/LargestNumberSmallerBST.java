package com.yyh;
//In a binary search tree, find the node containing the largest number smaller than the given target number.
//If there is no such number, return INT_MIN.

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class LargestNumberSmallerBST {
	public int largestSmaller(TreeNode root, int target) {
		//Assumptions: the binary search tree is not null.
		int result = Integer.MIN_VALUE;
		while (root != null){
			if (root.key >= target){
				root = root.left;
			} else {
				// the candidates are all the nodes on the path of 
				// searching for target, which is smaller than target.
				// and notice that, the latter searched node has larger
				// value than the earlier searched ones.
				result = root.key;
				root = root.right;
			}
		}
		return result;
	}
}
