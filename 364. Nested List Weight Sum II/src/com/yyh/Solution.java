package com.yyh;
/*
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Different from the previous question where weight is increasing from root to leaf, 
 * now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, 
 * and the root level integers have the largest weight.
 */

import java.util.List;

interface NestedInteger {
	// Constructor initializes an empty nested list.
	//public NestedInteger();

	// Constructor initializes a single integer.
	//public NestedInteger(int value);

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value);

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni);

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class Solution {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		int[] layer = new int[1];
		helper1(nestedList, 1, layer);
		return helper(nestedList, layer[0]);
	}
	
	private void helper1(List<NestedInteger> list, int l, int[] layer){
		layer[0] = Math.max(layer[0], l);
		for (NestedInteger n : list){
			if (!n.isInteger()) helper1(n.getList(), l + 1, layer);
		}
	}

	private int helper(List<NestedInteger> list, int layer){
		int res = 0;
		for (NestedInteger n : list){
			res += n.isInteger()? n.getInteger() * layer: helper(n.getList(), layer - 1);
		}
		return res;
	}
}
