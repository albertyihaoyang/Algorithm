package com.yyh;
// Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
class TreeNodeP {
	public int key;
	public TreeNodeP left;
	public TreeNodeP right;
	public TreeNodeP parent;
	public TreeNodeP(int key, TreeNodeP parent) {
		this.key = key;
		this.parent = parent;
	}
}

public class LowestCommonAncestor {
	
	public static void main(String[] args){
		LowestCommonAncestor sol = new LowestCommonAncestor();
		TreeNodeP T1 = new TreeNodeP(5, null);
		TreeNodeP T2 = new TreeNodeP(9, T1);
		TreeNodeP T3 = new TreeNodeP(12, T1);
		TreeNodeP T4 = new TreeNodeP(2, T2);
		TreeNodeP T5 = new TreeNodeP(3, T2);
		TreeNodeP T6 = new TreeNodeP(14, T3);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.right = T6;
		System.out.println(sol.lowestCommonAncestor(T4, T6).key);
	}
	
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		int l1 = length(one);
		int l2 = length(two);
		if (l1 <= l2){
			return mergeNode(one, two, l2 - l1);
		} else {
			return mergeNode(two, one, l1 - l2);
		}
	}
	
	private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff){
		while (diff > 0){
			longer = longer.parent;
			diff--;
		}
		while (longer != shorter){
			longer = longer.parent;
			shorter = shorter.parent;
		}
		return longer;
	}
	
	private int length(TreeNodeP node){
		int length = 0;
		while (node != null){
			length++;
			node = node.parent;
		}
		return length;
	}
}
