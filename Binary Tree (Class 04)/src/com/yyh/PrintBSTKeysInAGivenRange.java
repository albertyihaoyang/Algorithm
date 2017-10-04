package com.yyh;

public class PrintBSTKeysInAGivenRange {
	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(6);
		TreeNode T2 = new TreeNode(4);
		TreeNode T3 = new TreeNode(10);
		TreeNode T4 = new TreeNode(2);
		TreeNode T5 = new TreeNode(5);
		TreeNode T6 = new TreeNode(7);
		TreeNode T7 = new TreeNode(12);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.left = T6;
		T3.right = T7;
		printBST(T1, 3, 7);
	}
	
	public static void printBST(TreeNode root, int min, int max){
		if (root == null){
			return;
		}
		if (root.key > min){
			printBST(root.left, min, max);
		}
		if (root.key >= min && root.key <= max){
			System.out.print(root.key + " ");
		}
		if (root.key < max){
			printBST(root.right, min, max);
		}
	}
}
