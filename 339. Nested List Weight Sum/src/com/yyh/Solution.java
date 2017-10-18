package com.yyh;

import java.util.List;

/*
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class Solution {
	public int depthSum(List<NestedInteger> nestedList) {
		return helper(nestedList, 1);
	}

	public int helper(List<NestedInteger> list, int layer){
		int res = 0;
		for (NestedInteger n : list){
			res += n.isInteger()? n.getInteger() * layer: helper(n.getList(), layer + 1);
		}
		return res;
	}
}
