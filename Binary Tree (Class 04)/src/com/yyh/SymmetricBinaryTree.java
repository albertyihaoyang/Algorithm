package com.yyh;

/*
 * Check if a given binary tree is symmetric.

Examples

        5

      /    \

    3        3

  /   \    /   \

1      4  4      1

is symmetric.

        5

      /    \

    3        3

  /   \    /   \

1      4  1      4

is not symmetric.


 */

public class SymmetricBinaryTree {
	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(5);
		TreeNode T2 = new TreeNode(3);
		TreeNode T3 = new TreeNode(3);
		TreeNode T4 = new TreeNode(1);
		TreeNode T5 = new TreeNode(4);
		TreeNode T6 = new TreeNode(1);
		TreeNode T7 = new TreeNode(4);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.left = T6;
		T3.right = T7;
		System.out.print(isSymmetric(T1));
	}
	
	public static boolean isSymmetric(TreeNode root) {
	    if (root == null){
	    	return true;
	    }
	    return isSymmetric(root.left,root.right);
	}
	
	public static boolean isSymmetric(TreeNode left, TreeNode right){
		if (left == null && right == null){
			return true;
		} else if (left == null || right == null){
			return false;
		} else if (left.key != right.key){
			return false;
		} else {
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
	}
}
