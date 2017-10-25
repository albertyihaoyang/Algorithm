package com.yyh;
// Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
// Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
// If no such second minimum value exists, output -1 instead.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int findSecondMinimumValue(TreeNode root) {
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        helper(root, min);
        return min[1] == Integer.MAX_VALUE ? -1 : min[1];
    }
    
    private void helper(TreeNode root, int[] min){
        if (root == null) return;
        if (root.val < min[0]){
            min[1] = min[0];
            min[0] = root.val;
        } else if (root.val > min[0] && root.val < min[1]){
            min[1] = root.val;
        }
        helper(root.left, min);
        helper(root.right, min);
    }
}
