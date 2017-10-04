package com.yyh;
// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
import java.util.*;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class MergeKLists {

	public static void main(String[] args) {
		MergeKLists my = new MergeKLists();
		ListNode L1 = new ListNode(1);
		ListNode L2 = new ListNode(2);
		ListNode L3 = new ListNode(3);
		L1.next = L3;
		ListNode[] l1 = new ListNode[]{L1, L2};
		System.out.println(my.mergeKLists(l1).val);
	}

	public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
        	@Override
        	public int compare(ListNode l1, ListNode l2){
        		if (l1.val == l2.val){
        			return 0;
        		} 
        			return (l1.val < l2.val) ? -1: 1;
        		}
        	}
        );
        for (int i = 0; i < lists.length; i++){
        	if (lists[i] != null){
        		minHeap.add(lists[i]);
        	}
        }
		while (minHeap.peek() != null){
			ListNode node = minHeap.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null){
				minHeap.offer(node.next);
			}
        }
		return dummy.next;
    }
}
