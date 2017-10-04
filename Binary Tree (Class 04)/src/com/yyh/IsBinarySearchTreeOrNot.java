package com.yyh;

import java.util.ArrayList;
import java.util.List;

public class IsBinarySearchTreeOrNot {
	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(6);
		TreeNode T2 = new TreeNode(4);
		TreeNode T3 = new TreeNode(10);
		TreeNode T4 = new TreeNode(2);
		TreeNode T5 = new TreeNode(5);
		TreeNode T6 = new TreeNode(6);
		TreeNode T7 = new TreeNode(12);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.left = T6;
		T3.right = T7;
		System.out.println(inOrder(T1));
		System.out.println(isBST(T1));
	}
	
	public static boolean isBST(TreeNode root) {
	    if (root == null){
	    	return true;
	    }
	    int treeSize = inOrder(root).size();
	    for (int i = 1; i < treeSize; i++){
	    	if (inOrder(root).get(i-1) >= inOrder(root).get(i)) {
	    		return false;
	    	}
	    }
	    return true;
	}
	
	public static List<Integer> inOrder(TreeNode root) {
		if (root == null){
			return new ArrayList<Integer>();
		}
	    List<Integer> traversal = new ArrayList<Integer>();
	    traversal.addAll(inOrder(root.left));
	    traversal.add(root.key);
	    traversal.addAll(inOrder(root.right));
	    return traversal;
	 }
}