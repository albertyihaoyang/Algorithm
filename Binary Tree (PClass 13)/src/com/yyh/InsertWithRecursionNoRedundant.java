package com.yyh;

public class InsertWithRecursionNoRedundant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(InorderTraversalOfBinaryTreeSolution.inOrder(T1));
		System.out.println(InorderTraversalOfBinaryTreeSolution.inOrder(insert(T1, 7)));
	}

	public static TreeNode insert(TreeNode root, int target){
		if (root == null){
			return new TreeNode(target);
		}
		helper(root, target);
		return root;
	}
	
	public static void helper(TreeNode root, int target){
		if (target < root.key) {
			if (root.left == null) {
				root.left = new TreeNode(target);
			} else {
				helper(root.left, target);
			}
		} else {
			if (root.right == null){
				root.right = new TreeNode(target);
			} else {
				helper(root.right, target);
			}
		}
	}
}
