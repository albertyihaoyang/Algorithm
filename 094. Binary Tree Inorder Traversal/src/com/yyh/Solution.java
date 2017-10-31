package com.yyh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Given a binary tree, return the inorder traversal of its nodes' values.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode cur = root;

		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.offerFirst(cur);
				cur = cur.left;
			}
			cur = stack.pollFirst();
			list.add(cur.val);
			cur = cur.right;
		}

		return list;   
	}
}