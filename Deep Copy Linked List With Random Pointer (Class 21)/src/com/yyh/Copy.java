package com.yyh;
// Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
import java.util.HashMap;
import java.util.Map;

class RandomListNode {
	public int value;
	public RandomListNode next;
	public RandomListNode random;
	public RandomListNode(int value) {
		this.value = value;
	}
}

public class Copy {
	// Method 1: using HasMap to avoid copy multiple times for the same node
	public RandomListNode copy(RandomListNode head) {
		if (head == null){
			return null;
		}
		// Sentinel node to help construct the deep copy.
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode cur = dummy;
		// Maintains the mapping between the node in the original list and
		// the corresponding node in the new list.
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		while (head != null){
			// Copy the current node if necessary.
			if (!map.containsKey(head)){
				map.put(head, new RandomListNode(head.value));
			}
			// Connect the copied node to the deep copy list.
			cur.next = map.get(head);
			// Copy the random node if necessary
			if (head.random != null){
				if (!map.containsKey(head.random)){
					map.put(head.random, new RandomListNode(head.random.value));
				}
				// Connect the copied node to the random pointer.
				cur.next.random = map.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}
