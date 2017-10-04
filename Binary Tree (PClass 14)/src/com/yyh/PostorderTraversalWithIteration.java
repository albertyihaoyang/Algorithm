package com.yyh;

import java.util.*;

public class PostorderTraversalWithIteration {
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
	    TreeNode prev = null;
	    stack.offerFirst(root);
	    while(!stack.isEmpty()){
	    	TreeNode cur = stack.peekFirst();
	    	if (prev == null || cur == prev.left || cur == prev.right){
	    		if (cur.left != null) { //A1
	    			stack.offerFirst(cur.left);
	    		} else if (cur.right != null){ //A2;
	    			stack.offerFirst(cur.right);
	    		} else { //A3
	    			System.out.print(cur.key + " ");
	    			stack.pollFirst();
	    		}
	    	} else if (prev == cur.left){ //from left tree
	    		if (cur.right != null){ //B1
	    			stack.offerFirst(cur.right);
	    		} else { //B2
	    			System.out.print(cur.key + " ");
	    			stack.pollFirst();
	    		}
	    	} else { //from right subtree C
	    		System.out.print(cur.key + " ");
    			stack.pollFirst();
		    }
	    	prev = cur;	
	    }
	 }
}
