package com.yyh;

public class DeleteNode {
	public TreeNode delete(TreeNode root, int target){
		if (root == null){
			return null;
		}
		
		// find target node
		if (root.key > target) {
			root.left = delete(root.left, target);
			return root;
		} else if (root.key < target){
			root.right = delete(root.right, target);
			return root;
		}
		
		// guarantee root!=null && root.val == target
		if (root.left == null){
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}
		
		// guarantee root.left!=null && root.right!=null
		// 4.1
		if (root.right.left == null){
			root.right.left = root.left;
			return root.right;
		}
		
		// 4.2
		// 1. find and delete smallest node in root.right
		TreeNode smallest = deleteSmallest(root.right);
		// 2. connect the smallest node with root.left and root.right
		smallest.left = root.left;
		smallest.right = root.right;
		// 3. return the smallest node. Smallest is the new root of THIS subtree
		return smallest;
	}
	
	// returns the smallest node in THSI subtree
	private TreeNode deleteSmallest(TreeNode cur){
		TreeNode prev = cur;
		cur = cur.left;
		while (cur.left != null){
			prev = cur;
			cur = cur.left;
		}
		
		// cur is the smallest one, and prev is its parent.
		// Invariance: cur (pre.left) does not have left child
		prev.left = prev.left.right; // or prev.left = cur.right
		return cur;
	}
}
