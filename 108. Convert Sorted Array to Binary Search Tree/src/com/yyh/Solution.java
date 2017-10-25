package com.yyh;
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) return null;
		return helper(nums, 0, nums.length);
	}

	private TreeNode helper(int[] nums, int start, int end){
		if (start == end){
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode cur = new TreeNode(nums[mid]);
		cur.left = helper(nums, start, mid);
		cur.right = helper(nums, mid + 1, end);
		return cur;
	}
}
