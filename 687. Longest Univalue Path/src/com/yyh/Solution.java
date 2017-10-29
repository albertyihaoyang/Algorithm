package com.yyh;
// Given a binary tree, find the length of the longest path where each node in the path has the same value.
// This path may or may not pass through the root.
class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.val = key;
	}
}

public class Solution {
	public int longestUnivaluePath(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0] > 0 ? max[0] - 1: 0;
    }
    
    public Integer[] helper(TreeNode root, int[] max){
        if (root == null){
            return new Integer[]{null, 0};
        }
        Integer[] left = helper(root.left, max);
        Integer[] right = helper(root.right, max);
        if (left[0] == null && right[0] == null){
            return new Integer[]{root.val, 1};
        } else if (right[0] == null){
            if (left[0] == root.val){
                max[0] = Math.max(max[0], left[1] + 1);
                return new Integer[]{root.val, left[1] + 1};
            }
            else return new Integer[]{root.val, 1};
        } else if (left[0] == null){
            if (right[0] == root.val){
                max[0] = Math.max(max[0], right[1] + 1);
                return new Integer[]{root.val, right[1] + 1};
            }
            else return new Integer[]{root.val, 1};
        } else {
            if (left[0] == root.val && right[0] == root.val){
                max[0] = Math.max(max[0], right[1] + left[1] + 1);
                return new Integer[]{root.val, Math.max(right[1], left[1]) + 1};
            } else if (left[0] == root.val){
                max[0] = Math.max(max[0], left[1] + 1);
                return new Integer[]{root.val, left[1] + 1};
            } else if (right[0] == root.val){
                max[0] = Math.max(max[0], right[1] + 1);
                return new Integer[]{root.val, right[1] + 1};
            } else return new Integer[]{root.val, 1};
        }
    }
}
