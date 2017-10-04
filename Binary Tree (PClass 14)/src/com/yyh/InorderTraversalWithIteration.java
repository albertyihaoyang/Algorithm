package com.yyh;

import java.util.*;

/*
 * Implement an iterative, in-order traversal of a given binary tree, return the list 
 * of keys of each node in the tree as it is in-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]

Corner Cases

What if the given binary tree is null? Return an empty list in this case.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */
public class InorderTraversalWithIteration {

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
		inOrder(T1);

	}
	
	public static void inOrder(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
	    TreeNode helper = root;
	    while (!stack.isEmpty() || helper != null){
	    	if (helper != null) {
	    		stack.offerFirst(helper);
	    		helper = helper.left;
	    	} else {
	    		TreeNode toBePrinted = stack.pollFirst();
	    		System.out.print(toBePrinted.key + " ");
	    		helper = toBePrinted.right;
	    	}
	    }
	 }
}
