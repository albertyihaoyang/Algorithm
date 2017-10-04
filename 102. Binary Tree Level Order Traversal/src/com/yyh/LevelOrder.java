package com.yyh;
import java.util.*;
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
public class LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		LevelOrder my = new LevelOrder();
		System.out.println(my.levelOrder(T1));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> myList = new ArrayList<>();
        Queue<TreeNode> cur = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();
        if (root == null) {
            return myList;
        }
        cur.add(root);
        List<Integer> level = new ArrayList<>();
        while (!cur.isEmpty()){
        	TreeNode curNode = cur.poll();
        	level.add(curNode.val);
        	if (curNode.left != null) {
        		next.offer(curNode.left);
        	}
        	if (curNode.right != null){
        		next.offer(curNode.right);
        	}
        	if (cur.isEmpty()){
        		cur = next;
        		next = new ArrayDeque<>();
        		myList.add(new ArrayList<>(level));
        		level = new ArrayList<>();
        	}
        }
        return myList;
    }
}
