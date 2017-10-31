package com.yyh;
/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        double min = (double)(Integer.MIN_VALUE) - 1.0;
        double max = (double)(Integer.MAX_VALUE) + 1.0;
        return is(root.left, min, root.val) && is(root.right, root.val, max);
    }
    
    public boolean is(TreeNode root, double min, double max){
        if (root == null) return true;
        if (root.val >= max || root.val <= min){
            return false;
        }
        return is(root.left, min, root.val) && is(root.right, root.val, max);
    }
}
