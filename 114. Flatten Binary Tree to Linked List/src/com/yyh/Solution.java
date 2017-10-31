package com.yyh;
// Given a binary tree, flatten it to a linked list in-place.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	private TreeNode pre = null;
    
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
