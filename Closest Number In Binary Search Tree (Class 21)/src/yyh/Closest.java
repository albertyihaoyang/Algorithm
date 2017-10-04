package yyh;
// In a binary search tree, find the node containing the closest number to the given target number.

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key = key;
	}
}
public class Closest {
	public int closest(TreeNode root, int target) {
		// Assumption: the given BST is not null
		int result = root.key;
		// The closest number has to be on the path of finding
		// the target value in the BST
		while (root != null){
			if (root.key == target){
				return root.key;
			} else {
				if (Math.abs(root.key - target) < Math.abs(result - target)){
					result = root.key;
				}
				if (root.key < target){
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}
		return result;
	}
}
