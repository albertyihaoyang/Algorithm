package com.yyh;

public class SolutionII {
	public void connect(TreeLinkNode root) {
		if (root == null) return;

		TreeLinkNode cur = root;
		TreeLinkNode pre = null;
		TreeLinkNode nex = null;

		while (cur != null){
			while (cur != null){
				if (cur.left != null){
					if (pre == null){
						nex = cur.left;
						pre = nex;
					} else {
						pre.next = cur.left;
						pre = pre.next;
					}
				}
				if (cur.right != null){
					if (pre == null){
						nex = cur.right;
						pre = nex;
					} else {
						pre.next = cur.right;
						pre = pre.next;
					}
				}
				cur = cur.next;
			}

			cur = nex;
			nex = null;
			pre = null;
		}
	}
}
