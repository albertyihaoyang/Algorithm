package com.yyh;
// Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.
class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class Insert{
	
	public TreeNode insert(TreeNode root, int key) {
		if (root == null){
			return new TreeNode(key);
		}
		if (root.key == key){
			return root;
		} else if (root.key < key){
			root.right = insert(root.right, key);
		} else {
			root.left = insert(root.left, key);
		}
		return root;
	}
}
