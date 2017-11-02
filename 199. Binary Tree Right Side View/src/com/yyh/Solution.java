package com.yyh;
// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> cur = new LinkedList<>();
        cur.add(root);
        while (!cur.isEmpty()){
            Queue<TreeNode> tmp = new LinkedList<>();
            TreeNode curNode = null;
            while (!cur.isEmpty()){
                curNode = cur.poll();
                if (curNode.left != null) tmp.offer(curNode.left);
                if (curNode.right != null) tmp.offer(curNode.right);
            }
            res.add(curNode.val);
            cur = tmp;
        }
        return res;
    }
}
