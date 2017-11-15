package com.yyh;
/*
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) 
 * for which all other nodes are descendants of this node, plus every node has exactly one parent, 
 * except for the root node which has no parents.
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), 
 * with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, 
 * and was not an edge that already existed.
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge 
 * connecting nodes u and v, where u is a parent of child v.
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, 
 * return the answer that occurs last in the given 2D-array.
 */
public class Solution {
	// Time: O(n)
	// Space: O(n)
	public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] canA = {0, 0};
        int[] canB = {0, 0};
        int[] find = new int[edges.length + 1];// child to parent match
        for (int[] edge : edges) {
            if (find[edge[1]] == 0) {
                find[edge[1]] = edge[0];
            } else { // check if one node have 2 parent
            	canA = new int[] {find[edge[1]], edge[1]};
                canB = new int[] {edge[0], edge[1]};
                edge[1] = 0; // point the edge to null(0)
            }
        }
        for (int i = 0; i < edges.length; i++) {
            find[i] = i;
        }
        // 
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            int parent = edge[0];
            int child = edge[1];
            if (unionFind(find, parent) == child) {
                if (canA[0] == 0) {
                    return edge;
                }
                return canA;
            }
            find[child] = parent;
        }
        return canB;
    }
    
	// Union Find
    private int unionFind(int[] find, int i) {
        while (i != find[i]) {
            find[i] = find[find[i]];
            i = find[i];
        }   
        return i;
    }
}
