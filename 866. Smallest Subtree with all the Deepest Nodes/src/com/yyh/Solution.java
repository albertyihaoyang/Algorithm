package com.yyh;
/*
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

A node is deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes in it's subtree.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	TreeNode res = null;
    int max = 0;
    int layer;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        layer = findDeepest(root);
        findNode(root, 1);
        return res;
    }
    
    private int findDeepest(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = findDeepest(root.left);
        int right = findDeepest(root.right);
        return Math.max(left, right) + 1;
    }
    
    private int findNode(TreeNode root, int lay){
        if (root == null){
            return 0;
        } else if (lay == layer){
            if (max == 0){
                max = 1;
                res = root;
            }
            return 1;
        }
        int cur = findNode(root.left, lay + 1) + findNode(root.right, lay + 1);
        if (cur > max){
            max = cur;
            res = root;
        }
        return cur;
    }
}
