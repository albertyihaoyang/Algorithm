package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given the root of a tree, you are asked to find the most frequent subtree sum. 
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). 
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> store = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> en: map.entrySet()){
            if (en.getValue() > max){
                store = new ArrayList<>();
                max = en.getValue();
                store.add(en.getKey());
            } else if (en.getValue() == max){
                store.add(en.getKey());
            }
        }
        int[] res = new int[store.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = store.get(i);
        }
        return res;
    }
    
    public int helper(TreeNode root, Map<Integer, Integer> map){
        if (root == null) return 0;
        int sum = root.val + helper(root.left, map) + helper(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
