package com.yyh;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversalOfBinaryTreeSolution {
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
		System.out.print(postOrder(T1));

	}
	
	public static List<Integer> postOrder(TreeNode root) {
	    // Write your solution here.
		if (root == null){
			return new ArrayList<Integer>();
		}
	    List<Integer> traversal = new ArrayList<Integer>();
	    traversal.addAll(postOrder(root.left));
	    traversal.addAll(postOrder(root.right));
	    traversal.add(root.key);
	    return traversal;
	 }
}
