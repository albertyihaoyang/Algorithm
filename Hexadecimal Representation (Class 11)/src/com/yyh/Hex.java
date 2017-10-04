package com.yyh;

/*
 * Generate the hexadecimal representation for a given non-negative integer number as a string. 
 * The hex representation should start with "0x".
 * There should not be extra zeros on the left side.
 */
public class Hex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hex my = new Hex();
		System.out.println(my.hex(0));
		System.out.println(my.hex(255));
	}

	public String hex(int number) {
	    if (number == 0){
	      return "0x0";
	    }
	    StringBuilder sb = new StringBuilder();
	    sb.append("0x");
	    boolean init = false;
	    for (int i = 7; i >= 0; i--){
	      char dig = charConv((number >> (i * 4)) & 15);
	      if (init == true){
	        sb.append(dig);
	      } else if (dig != '0'){
	        sb.append(dig);
	        init = true;
	      }
	    }
	    return sb.toString();
	  }
	  
	  public char charConv(int num){
	    if (0 <= num && num < 10){
	      return (char)((int)'0' + num);
	    } else if (num >= 10 && num < 16){
	      return (char)((int)'A' + num - 10);
	    }
	    return ' ';
	  }
}
