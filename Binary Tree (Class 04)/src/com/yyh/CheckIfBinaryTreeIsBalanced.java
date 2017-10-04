package com.yyh;

/*
 * Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

is balanced binary tree,

        5

      /

    3

  /   \

1      4

is not balanced binary tree.
 */

public class CheckIfBinaryTreeIsBalanced {
	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(5);
		TreeNode T2 = new TreeNode(3);
		TreeNode T3 = new TreeNode(8);
		TreeNode T4 = new TreeNode(1);
		TreeNode T5 = new TreeNode(4);
		TreeNode T6 = new TreeNode(11);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.right = T6;
		System.out.print(isBalanced(T1));
	}
	
	public static boolean isBalanced(TreeNode root) {
	    if (root == null){
	    	return true;
	    }
		if (Math.abs(height(root.left) - height(root.right)) > 1){
	    	return false;
	    }
	    return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static int height(TreeNode root){
		if (root == null){
			return 0;
		}
		return Math.max(height(root.left), height(root.right))+1;
	}
	
}
