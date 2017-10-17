package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. 
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null){
			return false;
		}
		List<TreeNode> list = new ArrayList<>();
		find(s, t, list);
		if (list.isEmpty()){
			return false;
		}
		for (TreeNode start : list){
			if (sameTree(start, t)) return true;
		}
		return false;
	}
	
	private void find(TreeNode s, TreeNode t, List<TreeNode> list){
		if (s == null){
			return;
		}
		find(s.left, t, list);
		find(s.right, t, list);
		if (s.val == t.val) {
			list.add(s);
		}
	}
	
	private boolean sameTree(TreeNode s, TreeNode t){
		if (s == null && t == null) return true;
		if ((s == null && t != null) || (s != null && t == null)){
			return false;
		}
		return sameTree(s.left, t.left) && sameTree(s.right, t.right) && (s.val == t.val);
	}
}
