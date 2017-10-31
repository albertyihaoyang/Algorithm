package com.yyh;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class SolutionI {
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> cur = new LinkedList<>();
        Queue<TreeLinkNode> nex = new LinkedList<>();
        cur.offer(root);
        while (!cur.isEmpty()){
            TreeLinkNode curNode = cur.poll();
            if (curNode.left != null){
                nex.offer(curNode.left);
            }
            if (curNode.right != null){
                nex.offer(curNode.right);
            }
            if (!cur.isEmpty()){
                curNode.next = cur.peek();
            } else {
                cur = nex;
                nex = new LinkedList<>();
            }
        }
    }
}
