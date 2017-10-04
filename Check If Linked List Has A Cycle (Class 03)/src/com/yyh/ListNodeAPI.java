package com.yyh;

public class ListNodeAPI {
	public static int len(ListNode head){
		int n = 0;
		while (head != null){
			head = head.next;
			n += 1;
		}
		return n;
	}
	
	public ListNode get(ListNode head, int index){
		int curPos = 0;
		while (head != null){
			if (curPos == index) {
				return head;
			}
			head = head.next;
			curPos += 1;
		}
		return head;		
	}
	
	public static ListNode appendHead(ListNode head, int value){
		ListNode newHead = new ListNode(value);
		newHead.next = head;
		return newHead;
	}
	
	public static ListNode appendTail(ListNode head, int value){
		ListNode newTail = new ListNode(value);
		if (head == null){
			return newTail;
		}
		ListNode pre = head;
		while (pre.next != null){
			pre = pre.next;
		}
		pre.next = newTail;
		return head;
	}
	
	public static ListNode remove(ListNode head, int value){
		if (head == null){
			return head;
		}
		if (head.value == value){
			return head.next;
		}
		ListNode pre = head;
		while (pre.next != null){
			if (pre.next.value == value){
				pre.next = pre.next.next;
				break;
			}
			pre = pre.next;
		}
		return head;
	}
	
	public static void printNode(ListNode head){
		if (head == null){
			System.out.print("Null");
		}
		while (head != null){
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}

