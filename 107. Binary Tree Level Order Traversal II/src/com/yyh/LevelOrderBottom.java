package com.yyh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {

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
		LevelOrderBottom my = new LevelOrderBottom();
		System.out.println(my.levelOrderBottom(T1));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> myList = new ArrayList<>();
        Deque<List<Integer>> buffer = new ArrayDeque<>();
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
        		buffer.offerFirst(new ArrayList<>(level));
        		level = new ArrayList<>();
        	}
        }
        while (!buffer.isEmpty()){
        	myList.add(buffer.pollFirst());
        }
        return myList;
    }

}
