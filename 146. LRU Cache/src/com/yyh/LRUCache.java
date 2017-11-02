package com.yyh;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node {
        int val;
        Node prev, next;
        public Node(int val){
            this.val = val;
        }
    }
    
    Map<Integer, Node> map = new HashMap<>();
    int cap;
    int size;
    Node head = new Node(0);
    Node tail = new Node(0);
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    private void add(Node node){
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }
    
    private Node delete(Node cur){
        Node pre = cur.prev;
        Node nex = cur.next;
        pre.next = nex;
        nex.prev = pre;
        cur.prev = null;
        cur.next = null;
        return cur;
    }
    
    public int get(int key) {
        Node curNode = map.get(key);
        if (curNode == null){
            return -1;
        }
        if (curNode.next == null){
            return -1;
        }
        int res = curNode.val;
        add(delete(curNode));
        return res;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(value);
        Node curNode = map.get(key);
        if (curNode == null || curNode.next == null){
            if (this.size < this.cap){
                add(newNode);
                size++;
            } else {
                delete(tail.prev);
                add(newNode);
            }
        } else {
            delete(curNode);
            add(newNode);
        }
        map.put(key, newNode);
    }
}
