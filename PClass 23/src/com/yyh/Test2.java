package com.yyh;
// 比较二元对
class MyPair<K, V>{
	private K key;
	private V value;
	
	public MyPair(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString(){
		return "MyPair [key=" + key + ", value=" + value + "]";
	}
	
	public void setKey(K key){
		this.key = key;
	}
	
	public void setValue(V value){
		this.value = value;
	}
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return value;
	}
}

class Util{
	public static <K, V> boolean compare(MyPair<K, V> p1, MyPair<K, V> p2){
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
}
public class Test2 {

	public static void main(String[] args) {
		MyPair<String, Integer> p1 = new MyPair<>("a", 1);
		MyPair<String, Integer> p2 = new MyPair<>("b", 2);
		MyPair<String, Integer> p3 = new MyPair<>("a", 1);
		
		System.out.println(Util.compare(p1, p2));
		System.out.println(Util.compare(p1, p3));
	}

}
