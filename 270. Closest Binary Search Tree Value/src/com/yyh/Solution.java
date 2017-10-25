package com.yyh;
// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int closestValue(TreeNode root, double target) {
        double[] cl = new double[2];
        cl[0] = Math.abs(root.val - target);
        cl[1] = root.val;
        helper(root, target, cl);
        return (int)cl[1];
    }
    
    private void helper(TreeNode root, double target, double[] cl){
        if (root == null) return;
        if (Math.abs(root.val - target) < cl[0]){
            cl[0] = Math.abs(root.val - target);
            cl[1] = root.val;
        }
        helper(root.left, target, cl);
        helper(root.right, target, cl);
    }
}
