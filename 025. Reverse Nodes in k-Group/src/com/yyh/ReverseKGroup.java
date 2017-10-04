package com.yyh;
// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}
public class ReverseKGroup {
	public static void main(String[] args){
		ReverseKGroup my = new ReverseKGroup();
		ListNode L1 = new ListNode(1);
		ListNode L2 = new ListNode(2);
		ListNode L3 = new ListNode(3);
		ListNode L4 = new ListNode(4);
		ListNode L5 = new ListNode(5);
		L1.next = L2;
		L2.next = L3;
		L3.next = L4;
		L4.next = L5;
		ListNode cur = my.reverseKGroup(L1, 3);
		while (cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null){
        	return head;
        }
        ListNode end = head;
        for (int i = 0; i < k - 1; i++){
        	end = end.next;
        	if (end == null){
        		return head;
        	}
        }
        ListNode nextHead = end.next;
        end.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(nextHead, k);
        return newHead;
      }
   	
	
	private ListNode reverse(ListNode head){
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = head;
		while (cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

}
