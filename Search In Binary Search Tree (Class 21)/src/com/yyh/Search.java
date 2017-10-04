package com.yyh;
// Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.
class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class Search {
	public TreeNode search(TreeNode root, int key) {
		if (root == null){
			return root;
		}
		if (root.key == key){
			return root;
		} else if (root.key < key){
			return search(root.right, key);
		} else {
			return search(root.left, key);
		}
	}
}
