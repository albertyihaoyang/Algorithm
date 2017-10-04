package com.yyh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}

public class ZigZag {

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
		System.out.println(zigZag(T1).toString());
	}

	public static List<Integer> zigZag(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Deque<TreeNode> RtoL = new ArrayDeque<>();
		Deque<TreeNode> LtoR = new ArrayDeque<>();
		RtoL.offerFirst(root);
		while (!RtoL.isEmpty() || !LtoR.isEmpty()){
			if (!RtoL.isEmpty()){
				while (!RtoL.isEmpty()){
					TreeNode cur = RtoL.pollFirst();
					list.add(cur.key);
					if (cur.right != null){
						LtoR.offerFirst(cur.right);
					}
					if (cur.left != null){
						LtoR.offerFirst(cur.left);
					}
				}
			} else {
				while (!LtoR.isEmpty()){
					TreeNode cur = LtoR.pollFirst();
					list.add(cur.key);
					if (cur.left != null){
						RtoL.offerFirst(cur.left);
					}
					if (cur.right != null){
						RtoL.offerFirst(cur.right);
					}
				}
			}
		}
		return list;
	}

}
