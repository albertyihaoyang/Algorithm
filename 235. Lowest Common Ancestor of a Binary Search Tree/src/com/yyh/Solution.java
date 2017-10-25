package com.yyh;
/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as 
 * the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null){
            if (root.val != p.val && root.val != q.val){
                return null;
            }
            return root;
        } else if (l != null && r != null) {
        	return root;
        } else if (l != null){
            if (root.val != p.val && root.val != q.val){
                return l;
            }
            return root;
        } else if (r != null){
            if (root.val != p.val && root.val != q.val){
                return r;
            }
            return root;
        }
		return root;
    }
}
