package com.yyh;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	List<Integer> res;
    
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        helper(root, 0);
        return res;
    }
    
    public void helper(TreeNode root, int layer){
        if (root == null) return;
        if (layer >= res.size()){
            res.add(root.val);
        }
        if (res.get(layer) < root.val){
            res.set(layer, root.val);
        }
        helper(root.left, layer + 1);
        helper(root.right, layer + 1);
    }
}
