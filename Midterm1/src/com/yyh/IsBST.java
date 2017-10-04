package com.yyh;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode (int val) {
		this.val = val;
	}
}

public class IsBST{
	
	public static void main(String[] args) {
		IsBST mySol = new IsBST();
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
		System.out.println(mySol.isBST(T1));
	}
	
	// Assumption: all value of TreeNode is integer
	// Time complexity: O(n) / Space Complexity: O(lgn)	
	public boolean isBST(TreeNode head){
		return helper(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean helper(TreeNode head, int left, int right){
		if (head == null) {
			return true;
		}
		// Return false if value of head is out of range
		if (head.val < left || head.val > right) {
			return false;
		}
		// Next level
		return helper(head.left, left, head.val - 1) && helper(head.right, head.val + 1, right);
	}
}
