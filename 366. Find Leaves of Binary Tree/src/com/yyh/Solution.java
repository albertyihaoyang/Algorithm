package com.yyh;

import java.util.ArrayList;
import java.util.List;

// Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	List<List<Integer>> res;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root){
        if (root == null) return 0;
        int curLay = Math.max(helper(root.left), helper(root.right)) + 1;
        if (curLay > res.size()){
            List<Integer> cur = new ArrayList<>();
            cur.add(root.val);
            res.add(cur);
        } else {
            List<Integer> cur = res.get(curLay - 1);
            cur.add(root.val);
        }
        return curLay;
    }
}
