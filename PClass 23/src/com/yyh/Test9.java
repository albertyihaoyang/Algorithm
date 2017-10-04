package com.yyh;

import java.io.*;

public class Test9 {
	public static void main(String[] args) throws IOException{
		FileReader in = null;
		FileWriter out = null;
		try{
			in = new FileReader("/Users/yihao/Documents/workspace/testdata/chineseinput.txt");
			out = new FileWriter("/Users/yihao/Documents/workspace/testdata/chineseoutput.txt");
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
