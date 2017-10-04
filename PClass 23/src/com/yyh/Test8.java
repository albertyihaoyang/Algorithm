package com.yyh;

import java.io.FileInputStream;
import java.io.IOException;

public class Test8 {
	public static void main(String[] args) throws IOException{
		FileInputStream in = null;
		try{
			in = new FileInputStream("/Users/yihao/Documents/workspace/testdata/input.txt");
			byte[] bytes = new byte[7];
			int n = in.read(bytes);
			System.out.println("n = " + n);
			for (byte b : bytes){
				System.out.print((char)b);
			}
		} finally {
			if (in != null){
				in.close();
			}
		}

	}
}
