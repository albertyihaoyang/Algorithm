package com.yyh;

import java.util.*;

public class PostorderTraversalWithIteration2 {
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
		preOrder(T1);

	}
	
	public static void preOrder(TreeNode root) {
		if (root == null){
			return;
		}
	    Deque<TreeNode> stack = new LinkedList<>();
	    Deque<TreeNode> temp = new LinkedList<>();
	    stack.offerFirst(root);
	    while(!stack.isEmpty()){
	    	TreeNode cur = stack.pollFirst();
	    	temp.offerFirst(cur);
	    	if (cur.left != null){
	    		stack.offerFirst(cur.left);
	    	}
	    	if (cur.right != null){
		    		stack.offerFirst(cur.right);
		    	}
	    	
	    }
	    while (!temp.isEmpty()){
	    	System.out.print(temp.pollFirst().key + " ");
	    }
	 }
}
