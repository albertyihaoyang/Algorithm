package com.yyh;
/*
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go 
 * 	downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}

public class PathSum {
	
	public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, false);
    }
    
    private int pathSum(TreeNode root, int sum, boolean start){
        if (root == null){
            return 0;
        } else {
            int count = 0;
            if (start){
                count += pathSum(root.left, sum - root.val, true) + pathSum(root.right, sum - root.val, true);
                if (root.val == sum){
                    count++;
                }
                return count;
            } else {
                count += pathSum(root.left, sum - root.val, true) + pathSum(root.right, sum - root.val, true) + 
                    pathSum(root.left, sum, false) + pathSum(root.right, sum, false);
                if (root.val == sum){
                    count++;
                }
                return count;
            }
        }
    }
}
