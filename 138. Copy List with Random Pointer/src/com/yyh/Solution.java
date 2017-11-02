package com.yyh;

import java.util.HashMap;
import java.util.Map;

/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        for (Map.Entry<RandomListNode, RandomListNode> en : map.entrySet()){
            cur = en.getValue();
            RandomListNode nex = en.getKey().next;
            if (nex != null){
                cur.next = map.get(nex);
            } else cur.next = null;
            RandomListNode ran = en.getKey().random;
            if (ran != null){
                cur.random = map.get(ran);
            } else cur.random = null;
        }
        return map.get(head);
    }
}
