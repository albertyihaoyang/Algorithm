package com.yyh;

/*
 * Determine whether two given binary trees are identical assuming any number of 
 * ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.

Examples

        5

      /    \

    3        8

  /   \

1      4

and

        5

      /    \

    8        3

           /   \

          1     4

the two binary trees are tweaked identical.
 */

public class TweakedIdenticalBinaryTrees {
	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(5);
		TreeNode T2 = new TreeNode(3);
		TreeNode T3 = new TreeNode(8);
		TreeNode T4 = new TreeNode(4);
		TreeNode T5 = new TreeNode(1);
		TreeNode T21 = new TreeNode(5);
		TreeNode T22 = new TreeNode(3);
		TreeNode T23 = new TreeNode(8);
		TreeNode T24 = new TreeNode(4);
		TreeNode T25 = new TreeNode(1);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T21.left = T23;
		T21.right = T22;
		T22.left = T25;
		T22.right = T24;
		System.out.print(isTweakedIdentical(T1,T21));
	}
	
	public static boolean isTweakedIdentical(TreeNode one, TreeNode two) {
	    if (one == null && two == null){
	    	return true;
	    } else if (one == null || two == null){
	    	return false;
	    } else if (one.key != two.key) {
	    	return false;
	    } else {
	    	return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) 
	    			|| (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left));
	    }
	  }
}
