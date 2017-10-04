package com.yyh;
import java.io.*;
public class Test11 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("/Users/yihao/Documents/workspace/testdata/input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		while ((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
	}

}
