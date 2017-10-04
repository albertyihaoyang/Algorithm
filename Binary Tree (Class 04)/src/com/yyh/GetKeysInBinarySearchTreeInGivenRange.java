package com.yyh;

/*
 * Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]
 */

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBinarySearchTreeInGivenRange {
	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(5);
		TreeNode T2 = new TreeNode(3);
		TreeNode T3 = new TreeNode(8);
		TreeNode T4 = new TreeNode(1);
		TreeNode T5 = new TreeNode(4);
		TreeNode T6 = new TreeNode(11);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.right = T6;
		System.out.print(inOrder(T1));
		System.out.print(getRange(T1, 2, 5));
	}

	public static List<Integer> inOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		List<Integer> traversal = new ArrayList<Integer>();
		traversal.addAll(inOrder(root.left));
		traversal.add(root.key);
		traversal.addAll(inOrder(root.right));
		return traversal;
	}

	public static List<Integer> getRange(TreeNode root, int min, int max) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		List<Integer> curList = inOrder(root);
		int treeSize = curList.size();
		List<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < treeSize; i++) {
			int nodeKey = curList.get(i);
			if (nodeKey >= min && nodeKey <= max) {
				newList.add(nodeKey);
			}
		}
		return newList;
	}
}
