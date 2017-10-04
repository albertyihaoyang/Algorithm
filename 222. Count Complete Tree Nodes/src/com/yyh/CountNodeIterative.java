package com.yyh;
// Given a complete binary tree, count the number of nodes.
public class CountNodeIterative {

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
		T3.left = T6;
		CountNodeIterative my = new CountNodeIterative();
		System.out.println(my.countNodes(T1));
	}

	public int countNodes(TreeNode root) {
		int h = height(root);
        int nodes = 0;
        
        // Otherwise check whether the height of the right subtree is just one less than that of the whole tree, 
        // meaning left and right subtree have the same height.
        while (root != null){
        	// If yes, then the last node on the last tree row is in the right subtree and the left 
        	// subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus 
        	// the 1 root node plus recursively the number of nodes in the right subtree.
        	if (height(root.right) == h - 1){
        		nodes += 1 << h;
        		root = root.right;
        	} else {
            	// If no, then the last node on the last tree row is in the left subtree and the 
        		// right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the 
        		// right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.
        		nodes += 1 << (h - 1);
        		root = root.left;
        	}
        	h--;
        }
        return nodes;
    }
	
	// The height of a tree can be found by just going left. Let a single node tree have height 0. Find the height h of the whole tree. 
	// If the whole tree is empty, i.e., has height -1, there are 0 nodes.
	private int height(TreeNode root){
		return root == null? -1: height(root.left) + 1;
	}
}
