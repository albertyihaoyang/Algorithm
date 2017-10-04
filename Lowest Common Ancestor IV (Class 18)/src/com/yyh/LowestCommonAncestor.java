package com.yyh;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
	 public int key;
	 public TreeNode left;
	 public TreeNode right;
	 public TreeNode(int key) {
		 this.key = key;
	 }
}

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		return helper(root, set);
	}

	private TreeNode helper(TreeNode root, Set<TreeNode> set){
		if (root == null || set.contains(root)){
			return root;
		}
		TreeNode l = helper(root.left, set);
		TreeNode r = helper(root.right, set);
		if (l != null && r != null){
			return root;
		}
		return l != null ? l: r;
	}
}
