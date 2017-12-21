package com.yyh;
/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	class Pair{
		int ind;
		TreeNode node;
		public Pair(int ind, TreeNode node){
			this.ind = ind;
			this.node = node;
		}
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int left = 0;
		int right = 0;
		if (root == null){
			return new ArrayList<>();
		}
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, root));
		while (!q.isEmpty()){
			Pair cur = q.poll();
			int ind = cur.ind;
			if (!map.containsKey(ind)){
				map.put(ind, new ArrayList<>());
			}
			map.get(ind).add(cur.node.val);
			left = Math.min(left, ind);
			right = Math.max(right, ind);
			if (cur.node.left != null){
				q.offer(new Pair(ind - 1, cur.node.left));
			}
			if (cur.node.right != null){
				q.offer(new Pair(ind + 1, cur.node.right));
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < right - left + 1; i++){
			res.add(new ArrayList<>());
		}
		for (Map.Entry<Integer, List<Integer>> en : map.entrySet()){
			int ind = en.getKey() - left;
			res.set(ind, en.getValue());
		}
		return res;
	}

}