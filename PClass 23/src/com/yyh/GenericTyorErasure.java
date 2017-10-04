package com.yyh;

import java.util.ArrayList;

public class GenericTyorErasure {

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<String> a2 = new ArrayList<>();
		Class c1 = a1.getClass();
		Class c2 = a2.getClass();
		System.out.println(c1 == c2);
		System.out.println(c1);
		try{
			a2.getClass().getMethod("add", Object.class).invoke(a2, "a");
			System.out.println(a2.size());
		} catch (Throwable e){
			e.printStackTrace();
		}
	}

}
