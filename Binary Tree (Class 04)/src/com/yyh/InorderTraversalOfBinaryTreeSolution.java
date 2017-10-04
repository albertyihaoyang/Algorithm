package com.yyh;

import java.util.ArrayList;
import java.util.List;

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
public class InorderTraversalOfBinaryTreeSolution {

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
		System.out.print(inOrder(null));

	}
	
	public static List<Integer> inOrder(TreeNode root) {
	    // Write your solution here.
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
