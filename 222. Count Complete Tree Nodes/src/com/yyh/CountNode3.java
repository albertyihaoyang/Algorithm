package com.yyh;
// Given a complete binary tree, count the number of nodes.
public class CountNode3 {

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
		T3.left = T6;
		CountNode3 my = new CountNode3();
		System.out.println(my.countNodes(T1));
	}

	public int countNodes(TreeNode root) {
		if (root == null){
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
    }
	
}
