package com.yyh;

public class Copy2 {
	// Method 2: Another three pass solution, not using HashMap,
	// but changing the original list structure during the copy
	// (it will be changed back at the end).
	public RandomListNode copy(RandomListNode head) {
		if (head == null){
			return null;
		}
		// First pass, for each node in the original list, insert a
		// copied node between the node and node.next.
		RandomListNode cur = head;
		while (cur != null){
			// Make a copy of cur node, insert it to the middle of cur and cur.next.
			RandomListNode copy = new RandomListNode(cur.value);
			copy.next = cur.next;
			cur.next = copy;
			cur = cur.next.next;
		}
		// Second pass, link the random pointer for the copied node.
		cur = head;
		while (cur != null){
			if (cur.random != null){
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		// Third pass, extract the copied node
		cur = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode copyPrev = dummy;
		while (cur != null){
			copyPrev.next = cur.next;
			cur.next = cur.next.next;
			copyPrev = copyPrev.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}
