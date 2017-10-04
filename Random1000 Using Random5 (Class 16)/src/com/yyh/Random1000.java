package com.yyh;

public class Random1000 {
	public int random1000() {
	    while (true){
	      int result = 0;
	      int count = 1;
	      while (count < 1000){
	        count *= 5;
	        int digit = RandomFive.random5();
	        result = result * 5 + digit;
	      }
	      int limit = count / 1000 * 1000;
	      if (result < limit){
	        return result % 1000;
	      }
	    }
	 }
}
