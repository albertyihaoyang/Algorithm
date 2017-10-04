package com.yyh;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}

public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null){
            return true;
        } else if (root.val != sum && root.left == null && root.right == null){
            return false;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
