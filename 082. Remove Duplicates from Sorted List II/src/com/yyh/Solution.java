package com.yyh;
// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
		ListNode FakeHead=new ListNode(0);
		FakeHead.next=head;
		ListNode pre=FakeHead;
		ListNode cur=head;
		while(cur!=null){
			while(cur.next!=null&&cur.val==cur.next.val){
				cur=cur.next;
			}
			if(pre.next==cur){
				pre=pre.next;
			}
			else{
				pre.next=cur.next;
			}
			cur=cur.next;
		}
		return FakeHead.next;
	}
}
