package com.yyh;
import java.util.*;
public class IsValid {

	public static void main(String[] args) {
		IsValid my = new IsValid();
		System.out.println(my.isValid("()"));

	}

	public boolean isValid(String s) {
		if (s == null || s.length() == 0){
			return true;
		} else if (s.length() % 2 == 1){
			return false;
		}
		char[] arr = s.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++){
			if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
				stack.offerFirst(arr[i]);
			} else if (arr[i] == ')'){
				if (stack.isEmpty() || stack.pollFirst() != '('){
					return false;
				}
			} else if (arr[i] == ']'){
				if (stack.isEmpty() || stack.pollFirst() != '['){
					return false;
				}
			} else if (arr[i] == '}'){
				if (stack.isEmpty() || stack.pollFirst() != '{'){
					return false;
				}
			} else {
				return false;
			}
		}
		if (stack.isEmpty()){
			return true;
		}
		return false;
	}
}
