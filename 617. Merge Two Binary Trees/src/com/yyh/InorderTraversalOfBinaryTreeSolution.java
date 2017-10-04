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
		TreeNode T11 = new TreeNode(1);
		TreeNode T12 = new TreeNode(3);
		TreeNode T13 = new TreeNode(2);
		TreeNode T14 = new TreeNode(5);
		TreeNode T21 = new TreeNode(2);
		TreeNode T22 = new TreeNode(1);
		TreeNode T23 = new TreeNode(3);
		TreeNode T24 = new TreeNode(4);
		TreeNode T25 = new TreeNode(7);
		T11.left = T12;
		T11.right = T13;
		T12.left = T14;
		T21.left = T22;
		T21.right = T23;
		T22.right = T24;
		T23.right = T25;
		System.out.println(inOrder(T11));
		System.out.println(inOrder(T21));
		System.out.println(inOrder(mergeTree.mergeTrees(T11, T21)));

	}
	
	public static List<Integer> inOrder(TreeNode root) {
	    // Write your solution here.
		if (root == null){
			return new ArrayList<Integer>();
		}
	    List<Integer> traversal = new ArrayList<Integer>();
	    traversal.addAll(inOrder(root.left));
	    traversal.add(root.val);
	    traversal.addAll(inOrder(root.right));
	    return traversal;
	 }
}
