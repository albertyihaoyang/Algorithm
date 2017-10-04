package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class Reconstruct {
	public TreeNode reconstruct(int[] in, int[] level) {
		// Assumptions: level, in are not null, there is no duplicate in the binary tree.
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < in.length; i++){
			inMap.put(in[i], i);
		}
		List<Integer> lList = new ArrayList<>();
		for (int num : level){
			lList.add(num);
		}
		return helper(lList, inMap);
	}
	
	private TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap){
		if (level.isEmpty()){
			return null;
		}
		TreeNode root = new TreeNode(level.remove(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int num : level){
			if (inMap.get(num) < inMap.get(root.key)){
				left.add(num);
			} else {
				right.add(num);
			}
		}
		root.left = helper(left, inMap);
		root.right = helper(right, inMap);
		return root;
	}
}
