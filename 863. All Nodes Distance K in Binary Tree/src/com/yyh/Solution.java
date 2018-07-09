package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// We are given a binary tree (with root node root), a target node, and an integer value K.

// Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null || target == null || K < 0) return res;
        if (K == 0) {
            res.add(target.val);
            return res;
        }
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        dfs(root, map);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int dis = 0;
        while (!q.isEmpty()){
            dis++;
            int size = q.size();
            while (size > 0){
                TreeNode cur = q.poll();
                List<TreeNode> list = map.get(cur);
                for (TreeNode node: list){
                    if (visited.add(node)){
                        q.offer(node);
                    }
                }
                size--;
            }
            if (dis == K){
                for (TreeNode node: q){
                    res.add(node.val);
                }
                return res;
            }
        }
        return res;
    }
    
    public void dfs(TreeNode root, Map<TreeNode, List<TreeNode>> map){
        map.putIfAbsent(root, new ArrayList<>());
        if (root.left != null){
            map.put(root.left, new ArrayList<TreeNode>());
            map.get(root).add(root.left);
            map.get(root.left).add(root);
            dfs(root.left, map);
        }
        if (root.right != null){
            map.put(root.right, new ArrayList<TreeNode>());
            map.get(root).add(root.right);
            map.get(root.right).add(root);
            dfs(root.right, map);
        }
    }
}
