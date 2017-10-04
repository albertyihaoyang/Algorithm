package com.yyh;
//Given two nodes in a binary tree, find their lowest common ancestor.
class TreeNode {
	 public int key;
	 public TreeNode left;
	 public TreeNode right;
	 public TreeNode(int key) {
		 this.key = key;
	 }
}

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(5);
		TreeNode T2 = new TreeNode(9);
		TreeNode T3 = new TreeNode(12);
		TreeNode T4 = new TreeNode(2);
		TreeNode T5 = new TreeNode(3);
		TreeNode T6 = new TreeNode(14);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.right = T6;
		LowestCommonAncestor my = new LowestCommonAncestor();
		System.out.println(T1);
		System.out.println(my.lowestCommonAncestor(T1, T4, T6));
		System.out.println(T2);
		System.out.println(my.lowestCommonAncestor(T1, T2, T4));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two){
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, one, two);
		TreeNode right = lowestCommonAncestor(root.right, one, two);
		if (left != null && right != null){
			return root;
		}
		return left != null ? left : right;
	}
}
