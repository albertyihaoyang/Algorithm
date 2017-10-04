package com.yyh;

import java.util.HashMap;
import java.util.Map;

//Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class Reconstruct {
	// Method 1: Utilizing the inOrder sequence to determine the size of left/right subtrees
	public TreeNode reconstruct(int[] in, int[] pre) {
		// Assumptions: pre, in are not null, there is no duplicates in the binary tree,
		// the length of pre and in are guaranteed to be the same.
		Map<Integer, Integer> inIndex = indexMap(in);
		return helper(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
	}
	
	private Map<Integer, Integer> indexMap(int[] in){
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++){
			map.put(in[i], i);
		}
		return map;
	}
	
	private TreeNode helper(int[] pre,Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight){
		if (inLeft > inRight){
			return null;
		}
		TreeNode root = new TreeNode(pre[preLeft]);
		// get the position of the root in inOrder sequence, so that we will know the size of left/right subtrees
		int inMid = inIndex.get(root.key);
		root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
		root.right = helper(pre, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
		return root;
	}
}
