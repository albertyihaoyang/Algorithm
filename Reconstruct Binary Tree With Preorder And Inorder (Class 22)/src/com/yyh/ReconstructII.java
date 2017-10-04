package com.yyh;

public class ReconstructII {
	// Method 2: Another Linear Solution with traversing and constructing the binary tree using preOrder and inOrder at the same time.
	public TreeNode reconstructII(int[] in, int[] pre){
		// Assumptions: pre, in are not null, there is no duplicates in the binary tree, the length of pre and in are guaranteed to be the same.
		int[] preIndex = new int[]{0};
		int[] inIndex = new int[]{0};
		return helperII(pre, in, preIndex, inIndex, Integer.MAX_VALUE);
	}

	private TreeNode helperII(int[] pre, int[] in, int[] preIndex, int[] inIndex, int target){
		// Traversing and construct the binary tree using preOrder and inOrder,
		// the preOrder is [root][left subtree][right subtree]
		// from the preOrder, we know the root of the binary tree,
		// the inOrder is [left subtree][root][right subtree]
		// when we know the root, we actually know the boundary of the left/right subtree.
		// The "target" is actually the root, and we are using inOrder to identify the boundary of left subtree.
		if (inIndex[0] >= in.length || in[inIndex[0]] == target){
			return null;
		}
		TreeNode root = new TreeNode(pre[preIndex[0]]);
		// preOrder, advance the index by 1 since we already finish the root.
		preIndex[0]++;
		root.left = helperII(pre, in, preIndex, inIndex, root.key);
		// inOrder, after finish the left subtree, we can advance the index by 1.
		inIndex[0]++;
		root.right = helperII(pre, in, preIndex, inIndex, target);
		return root;
	}
}
