package com.yyh;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test7 {

	public static void main(String[] args) throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			in = new FileInputStream("/Users/yihao/Documents/workspace/testdata/input.txt");
			out = new FileOutputStream("/Users/yihao/Documents/workspace/testdata/output.txt");
			int c;
			while ((c = in.read()) != -1){
				System.out.print((char)c);
				out.write(c);
			}
		} finally {
			if (in != null){
				in.close();
			}
			if (out != null){
				out.close();
			}
		}
	}

}
