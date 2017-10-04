package com.yyh;

public class MyHashMap<K, V> {
	public static class Node<K, V>{
		final K key;
		V value;
		Node<K, V> next;
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public K getKey(){
			return key;
		}
		
		public V getValue(){
			return value;
		}
		
		public void setValue(V value){
			this.value = value;
		}	
	}
	
	public V put(K key, V value){
		// what if size ~ array.length
		int index = getIndex(key);
		Node<K, V> cur = array[index];
		while (cur != null){
			if (isEqual(cur.getKey(), key)){
				V old = cur.getValue();
				cur.setValue(value);
				return old;
			}
			cur = cur.next;
		}
		Node<K, V> newNode = new Node<>(key, value);
		newNode.next = array[index];
		array[index] = newNode;
		size++;
		if (size > LOAD_FACTOR * array.length){
			reHash();
		}
		return null;
	}
	
	public V remove(K key){
		int index = getIndex(key);
		Node<K, V> pre = null;
		Node<K, V> curr = array[index];
		while (curr != null){
			if (isEqual(curr.getKey(), key)){
				if (pre == null){
					array[index] = curr.next;
				} else {
					pre.next = curr.next;
				}
				size--;
				return curr.getValue();
			}
			pre = curr;
			curr = curr.next;
		}
		return null;
	}
	
	public V get(K key){
		int index = getIndex(key);
		Node<K, V> head = array[index];
		while (head != null){
			if (isEqual(head.getKey(), key)){
				return head.getValue();
			}
			head = head.next;
		}
		return null;
	}
	
	private void reHash(){
		int newLength = array.length * 2;
		Node<K, V>[] oldArray = array;
		array = (Node<K, V>[])(new Node[newLength]);
		for (int i = 0; i < oldArray.length; i++){
			Node<K, V> curr = oldArray[i];
			while (curr != null){
				Node<K, V> next = curr.next;
				put(curr.getKey(), curr.getValue());
				curr = next;
			}
		}
	}
	
	private int hash(K key){
		// return the hash# of the key
		if (key == null){
			return 0;
		}
		int hashNumber = key.hashCode();
		// post-possessing to make the hashNumber non-negative
		return hashNumber & 0x7fffffff;
	}
	
	int getIndex(K key){
		return hash(key) % array.length;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void clear(){
		size = 0;
		for (int i = 0; i < array.length; i++){
			array[i] = null;
		}
		// Arrays.fill(array, null)
	}
	
	private boolean isEqual(K key1, K key2){
		if (key1 == null && key2 == null){
			return true;
		}
		if (key1 == null || key2 == null){
			return false;
		}
		return key1.equals(key2);
	}
	
	public boolean containsKey(K key){
		int index = getIndex(key);
		Node<K, V> head = array[index];
		while (head != null){
			if (isEqual(head.getKey(), key)){
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	public MyHashMap(){
		array = (Node<K, V>[])(new Node[INITIAL_CAPACITY]);
		size = 0;
	}
	private Node<K, V>[] array;
	private int size;
	private static final int INITIAL_CAPACITY = 18;
	private static final double LOAD_FACTOR = 0.7;
}
