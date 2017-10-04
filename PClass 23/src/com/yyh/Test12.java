package com.yyh;
import java.io.*;
public class Test12 {
	public static void main(String[] args) throws IOException{
		FileInputStream input = null;
		try {
			input = new FileInputStream("/Users/yihao/Documents/workspace/testdata/input.txt");
			MyBufferedReader myReader = new MyBufferedReader(input);
			String line1 = myReader.nextLine();
			System.out.println(line1);
		} finally {
			input.close();
		}
	}
}

class MyBufferedReader {
	private FileInputStream in;
	private StringBuffer buffer;
	public MyBufferedReader(FileInputStream in){
		this.in = in;
		buffer = new StringBuffer();
	}
	public String nextLine() throws IOException{
		while (true){
			int c = in.read();
			if (c == -1 || c == '\n'){
				break;
			}
			buffer.append((char)c);
		}
		String output = buffer.toString();
		buffer = new StringBuffer();
		return output;
	}
}
