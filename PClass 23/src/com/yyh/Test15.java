package com.yyh;

import java.io.File;

public class Test15 {

	public static void main(String[] args) {
		String dirname = "/Users/yihao/Documents/workspace/testdata/";
		File d = new File(dirname);
		String[] paths = d.list();
		for (String p : paths){
			System.out.println(p);
		}
	}

}
