package com.yyh;
import java.util.*;
// Given a complete binary tree, count the number of nodes.
public class CountNode {

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
		CountNode my = new CountNode();
		System.out.println(my.countNodes(T1));
	}

	public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null){
            return count;
        }
        Queue<TreeNode> cur = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();
        cur.offer(root);
        while (!cur.isEmpty()){
            TreeNode curNode = cur.poll();
            count++;
            if (curNode.left != null){
                next.offer(curNode.left);
            }
            if (curNode.right != null){
                next.offer(curNode.right);
            }
            if (cur.isEmpty()){
                cur = next;
                next = new ArrayDeque<>();
            }
        }
        return count;
    }
}
