package com.yyh;
import java.io.*;
public class Test10 {
	public static void main(String[] args) throws IOException{
		InputStreamReader cin = null;
		try{
			cin = new InputStreamReader(System.in);
			System.out.println("Enter characters, 'q' to quit.");
			StringBuffer userInput = new StringBuffer();
			while (true) {
				char c = (char) cin.read();
				if (c == 'q'){
					break;
				}
				userInput.append(c);
			}
			System.out.println(userInput);
		} finally{
			if (cin != null){
				cin.close();
			}
		}
	}
}
