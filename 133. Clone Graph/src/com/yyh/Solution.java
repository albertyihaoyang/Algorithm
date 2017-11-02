package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            visited.add(cur);
            map.put(cur, new UndirectedGraphNode(cur.label));
            for (UndirectedGraphNode nei : cur.neighbors){
                if (!visited.contains(nei)){
                    queue.add(nei);
                }
            }
        }
        for (UndirectedGraphNode origin : visited){
            UndirectedGraphNode newNode = map.get(origin);
            for (UndirectedGraphNode oriNei : origin.neighbors){
                newNode.neighbors.add(map.get(oriNei));
            }
        }
        return map.get(node);
    }
}
