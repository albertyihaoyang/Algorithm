package com.yyh;

/*
 * Populate each next pointer to point to its next right node. If there is no next right node, 
 * the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 */
public class Connect {
	public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
        	return;
        }
        root.left.next = root.right;
        connect(root.left, root.right);
    }
	
	public void connect(TreeLinkNode left, TreeLinkNode right){
		if (left.left == null){
			return;
		}
		left.left.next = left.right;
		left.right.next = right.left;
		right.left.next = right.right;
		connect(left.left, left.right);
		connect(left.right, right.left);
		connect(right.left, right.right);
	}
}
