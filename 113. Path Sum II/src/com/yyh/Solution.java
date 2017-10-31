package com.yyh;

import java.util.ArrayList;
import java.util.List;

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root, sum, cur, res);
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res){
        if (root == null){
            return;
        }
        sum -= root.val;
        cur.add(root.val);
        if (sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(cur));
        } else {
            helper(root.left, sum, cur, res);
            helper(root.right, sum, cur, res);
        }
        cur.remove(cur.size() - 1);
    }
}
