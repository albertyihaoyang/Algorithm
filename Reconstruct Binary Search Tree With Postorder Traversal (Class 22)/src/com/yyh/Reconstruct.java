package com.yyh;
// Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class Reconstruct {
	public TreeNode reconstruct(int[] post) {
		// Assumptions: post is not null,
		// there is no duplicate in the BST.
		// Traversing position of the post order,
		// we traverse and construct the BST from the postOrder right to left.
		int[] index = new int[]{post.length - 1};
		return helper(post, index, Integer.MIN_VALUE);
	}
	
	private TreeNode helper(int[] postorder, int[] index, int min){
		// Since it is a BST, the "min" is actually the root,
		// and we are using the root value to determine the boundary of left/right subtree.
		if (index[0] < 0 || postorder[index[0]] <= min){
			return null;
		}
		TreeNode root = new TreeNode(postorder[index[0]--]);
		root.right = helper(postorder, index, root.key);
		root.left = helper(postorder, index, min);
		return root;
	}
}
