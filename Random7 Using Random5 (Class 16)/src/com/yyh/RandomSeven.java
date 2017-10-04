package com.yyh;

public class RandomSeven {
	public int random7() {
	    while (true){
	      int row = RandomFive.random5();
	      int col = RandomFive.random5();
	      int result = row * 5 + col;
	      if (result < 21){
	        return result % 7;
	      }
	    }
	}
}
