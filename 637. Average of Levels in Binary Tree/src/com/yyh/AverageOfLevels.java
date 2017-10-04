package com.yyh;
import java.util.*;
// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
public class AverageOfLevels {

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
		AverageOfLevels my = new AverageOfLevels();
		System.out.println(my.averageOfLevels(T1));
	}

	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> cur = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();
        double levelSum = 0;
        int count = 0;
        cur.offer(root);
        while (!cur.isEmpty()){
            TreeNode curNode = cur.poll();
            levelSum += curNode.val;
            count++;
            if (curNode.left != null){
                next.offer(curNode.left);
            }
            if (curNode.right != null){
                next.offer(curNode.right);
            }
            if (cur.isEmpty()){
                result.add(levelSum / count);
                levelSum = 0;
                count = 0;
                cur = next;
                next = new ArrayDeque<>();
            }
        }
        return result;
    }
}
