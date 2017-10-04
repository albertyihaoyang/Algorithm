package com.yyh;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBinaryTreeLayerByLayer {
	public static List<List<Integer>> layerByLayer(TreeNode root) {
	    if (root == null){
	    	return new ArrayList<List<Integer>>();
	    }
	    List<List<Integer>> tree = new ArrayList<List<Integer>>();
	    List<TreeNode> currentLayer = new ArrayList<TreeNode>();
	    currentLayer.add(root);
	    tree.add(nodeToNum(currentLayer));
	    while (getNextLayer(currentLayer).size() != 0){
	    	currentLayer = getNextLayer(currentLayer);
	    	tree.add(nodeToNum(currentLayer));
	    }
	    return tree;
	}
	
	public static List<TreeNode> getNextLayer(List<TreeNode> nodeSet){
		List<TreeNode> nextLayer = new ArrayList<TreeNode>();
		for (TreeNode i : nodeSet){
			if (i.left != null){
				nextLayer.add(i.left);
			}
			if (i.right != null){
				nextLayer.add(i.right);
			}
		}
		return nextLayer;
	}
	
	public static List<Integer> nodeToNum(List<TreeNode> nodeSet){
		List<Integer> newList = new ArrayList<Integer>();
		for (TreeNode i : nodeSet){
			newList.add(i.key);
		}
		return newList;
	}
	
	public static void main(String[] args) {
		TreeNode T1 = new TreeNode(6);
		TreeNode T2 = new TreeNode(4);
		TreeNode T3 = new TreeNode(10);
		TreeNode T4 = new TreeNode(2);
		TreeNode T5 = new TreeNode(5);
		TreeNode T6 = new TreeNode(7);
		TreeNode T7 = new TreeNode(12);
		T1.left = T2;
		T1.right = T3;
		T2.left = T4;
		T2.right = T5;
		T3.left = T6;
		T3.right = T7;
		System.out.println(layerByLayer(T1));
	}
	
}
