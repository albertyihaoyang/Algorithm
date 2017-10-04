package com.yyh;

public class SearchWithIteration {
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
		System.out.println(T2.key);
		System.out.println(search(T1, 3).key);

	}
	
	public static TreeNode search(TreeNode root, int target){
		// 1. process root
		if (root == null){
			return root;
		}
		while (root != null && root.key != target){
			if (target < root.key) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		if (root.key == target) {
			return root;
		} else {
			return null;
		}
		
	}
	
}
