package com.yyh;
/*
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". 
 * And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship 
 * between the string and the original binary tree.
 */
//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public String tree2str(TreeNode t) {
		if (t == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		helper(t, sb);
		return sb.toString().substring(1, sb.length() - 1);
	}

	private void helper(TreeNode t, StringBuilder sb){
		sb.append("(").append(t.val);
		if (t.left == null && t.right == null){
		} else if (t.left == null){
			sb.append("()");
			helper(t.right, sb);
		} else if (t.right == null){
			helper(t.left, sb);
		} else {
			helper(t.left, sb);
			helper(t.right, sb);
		}
		sb.append(")");
	}
}
