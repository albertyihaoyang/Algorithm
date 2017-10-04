package com.yyh;

public class Test6 {
	public static void main(String[] args) {
		Node<Integer> node = new Node<>(1);
		System.out.println(node.toString());
		node.setValue(2);
		System.out.println(node.getValue());
	}
}

class Node<T>{
	private T value;
	public Node(T v){
		value = v;
	}
	public String toString(){
		return value.toString();
	}
	public T getValue(){
		return value;
	}
	public void setValue(T v){
		value = v;
	}
}
