package com.yyh;
// Given a binary tree, return the zigzag level order traversal of its nodes' values. 
// (ie, from left to right, then right to left for the next level and alternate between).

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lay = new ArrayList<>();
        Deque<TreeNode> cur = new ArrayDeque<>();
        Deque<TreeNode> nex = new ArrayDeque<>();
        if (root == null){
            return res;
        }
        int i = 0;
        cur.offerFirst(root);
        while (!cur.isEmpty() || !nex.isEmpty()){
            if (i % 2 == 0){
                while (!cur.isEmpty()){
                    TreeNode tmp = cur.pollFirst();
                    lay.add(tmp.val);
                    if (tmp.left != null){
                        nex.offerLast(tmp.left);
                    }
                    if (tmp.right != null){
                        nex.offerLast(tmp.right);
                    }
                }
                cur = nex;
                nex = new ArrayDeque<>();
                res.add(new ArrayList<>(lay));
                lay = new ArrayList<>();
                i++;
            } else {
                while (!cur.isEmpty()){
                    TreeNode tmp = cur.pollLast();
                    lay.add(tmp.val);
                    if (tmp.right != null){
                        nex.offerFirst(tmp.right);
                    }
                    if (tmp.left != null){
                        nex.offerFirst(tmp.left);
                    }
                }
                cur = nex;
                nex = new ArrayDeque<>();
                res.add(new ArrayList<>(lay));
                lay = new ArrayList<>();
                i++;
            }
        }
        return res;
    }
}
